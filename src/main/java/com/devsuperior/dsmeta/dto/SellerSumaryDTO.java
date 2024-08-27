package com.devsuperior.dsmeta.dto;

import java.util.Objects;

public class SellerSumaryDTO {

    private String sellerName;

    private Double total;

    private Long quantidadeDeVendas;

    public SellerSumaryDTO() {
    }

    public SellerSumaryDTO(String sellerName, Double total, Long quantidadeDeVendas) {
        this.sellerName = sellerName;
        this.total = total;
        this.quantidadeDeVendas = quantidadeDeVendas;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getQuantidadeDeVendas() {
        return quantidadeDeVendas;
    }

    public void setQuantidadeDeVendas(Long quantidadeDeVendas) {
        this.quantidadeDeVendas = quantidadeDeVendas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SellerSumaryDTO that = (SellerSumaryDTO) o;

        if (!Objects.equals(sellerName, that.sellerName)) return false;
        return Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return sellerName != null ? sellerName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SellerSumaryDTO{" +
                "sellerName='" + sellerName + '\'' +
                ", total=" + total +
                ", quantidadeDeVendas=" + quantidadeDeVendas +
                '}';
    }
}
