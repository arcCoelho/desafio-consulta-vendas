package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SellerSumaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsmeta.dto.SaleReportDTO (sale.id, sale.amount, sale.date, sale.seller.name) " +
            " FROM Sale sale " +
            " WHERE sale.date BETWEEN :dtBegin AND :dtFinal " +
            " and UPPER(sale.seller.name) LIKE CONCAT('%', UPPER(:name), '%') ")
    Page<SaleReportDTO> saleReport(LocalDate dtBegin, LocalDate dtFinal, String name, Pageable pageable);

    @Query("SELECT new com.devsuperior.dsmeta.dto.SellerSumaryDTO(sale.seller.name, SUM(sale.amount), SUM(sale.deals) ) " +
            " FROM Sale sale " +
            " WHERE sale.date BETWEEN :dtBegin AND :dtFinal " +
            " GROUP BY sale.seller.name ")
    Page<SellerSumaryDTO> sellerSumary(LocalDate dtBegin, LocalDate dtFinal, Pageable pageable);

}
