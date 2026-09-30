package com.spring_boot.jpa_book.project.dto;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.spring_boot.jpa_book.project.entity.ProductEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String prdNo;
    private String prdName;
    private String prdPrice;
    private String prdCompany;
    private int prdStock;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date prdDate;

    // Entity를 DTO로 변환
    public static ProductDTO toDto(ProductEntity entity) {
        return ProductDTO.builder()
                .prdNo(entity.getPrdNo())
                .prdName(entity.getPrdName())
                .prdPrice(entity.getPrdPrice())
                .prdCompany(entity.getPrdCompany())
                .prdStock(entity.getPrdStock())
                .prdDate(entity.getPrdDate())
                .build();
    }
}