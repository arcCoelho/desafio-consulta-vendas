package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SellerSumaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	@Transactional(readOnly = true)
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}


	@Transactional(readOnly = true)
	public List<SaleMinDTO> listAll() {
		List<Sale> result = repository.findAll();
		return result.stream().map(x->new SaleMinDTO(x.getId(), x.getAmount(), x.getDate())).toList();
	}

	@Transactional(readOnly = true)
	public Page<SaleReportDTO> saleReport(String beginDt, String endDt, String name, Pageable pageable) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dtFinal = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

		if(!"".equals(endDt)){
			dtFinal = LocalDate.parse(endDt, dtf);
		}

		LocalDate dtBegin = dtFinal.minusYears(1L);
		if(!"".equals(beginDt)){
			dtBegin = LocalDate.parse(beginDt, dtf);
		}

		return repository.saleReport(dtBegin, dtFinal, name, pageable);
	}


	@Transactional
	public Page<SellerSumaryDTO> sellerSumary(String beginDt, String endDT, Pageable pageable) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dtFinal = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

		if(!"".equals(endDT)){
			dtFinal = LocalDate.parse(endDT, dtf);
		}

		LocalDate dtBegin = dtFinal.minusYears(1L);
		if(!"".equals(beginDt)){
			dtBegin = LocalDate.parse(beginDt, dtf);
		}

		return repository.sellerSumary(dtBegin, dtFinal, pageable);
	}
}
