package com.spring_boot.jpa_book.project.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.spring_boot.jpa_book.project.dto.ProductDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity {
    
    @Id
    private String prdNo;
    private String prdName;
    private String prdPrice;
    private String prdCompany;
    private int prdStock;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date prdDate;

    // DTO -> Entity 변환
    public static ProductEntity toEntity(ProductDTO dto) {
        return ProductEntity.builder()
                .prdNo(dto.getPrdNo())
                .prdName(dto.getPrdName())
                .prdPrice(dto.getPrdPrice())
                .prdCompany(dto.getPrdCompany())
                .prdStock(dto.getPrdStock())
                .prdDate(dto.getPrdDate())
                .build();
    }
}