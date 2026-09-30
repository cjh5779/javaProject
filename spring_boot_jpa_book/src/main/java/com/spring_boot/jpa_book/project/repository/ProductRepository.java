package com.spring_boot.jpa_book.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_boot.jpa_book.project.entity.ProductEntity;

// JpaRepository<엔티티 클래스, 기본키 타입>
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    // 기본 CRUD(findAll, save, findById, deleteById)가 자동으로 제공됩니다.
}