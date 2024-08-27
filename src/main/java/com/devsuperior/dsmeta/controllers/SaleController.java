package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SellerSumaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	public List<SaleMinDTO> findAll() {
		List<SaleMinDTO> dto = service.listAll();
		return dto;
	}

	@GetMapping(value = "/report")
	public ResponseEntity< Page<SaleReportDTO> > getReport(
			@RequestParam(name="minDate", defaultValue = "") String beginDt,
			@RequestParam(name="maxDate", defaultValue = "") String endDt,
			@RequestParam(name="name", defaultValue = "") String name,
			Pageable pageable
	) {


		Page<SaleReportDTO> page = service.saleReport(beginDt, endDt, name, pageable);

		return ResponseEntity.ok().body(page);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity< Page<SellerSumaryDTO> > getSummary(
			@RequestParam(name="minDate", defaultValue = "") String beginDt,
			@RequestParam(name="maxDate", defaultValue = "") String endDt,
			Pageable Pageable
	) {

		Page<SellerSumaryDTO> page = service.sellerSumary(beginDt, endDt, Pageable);
		return ResponseEntity.ok().body(page);
	}
}
