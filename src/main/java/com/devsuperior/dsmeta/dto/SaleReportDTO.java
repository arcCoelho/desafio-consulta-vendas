package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;
import java.util.Objects;

public class SaleReportDTO {

    private Long id;
    private Double amount;
    private LocalDate date;
    private String sellerName;

    public SaleReportDTO() {
    }

    public SaleReportDTO(Long id, Double amount, LocalDate date, String sellerName) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.sellerName = sellerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleReportDTO that = (SaleReportDTO) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SaleReportDTO{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", sellerName='" + sellerName + '\'' +
                '}';
    }
}
