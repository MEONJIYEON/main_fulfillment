package com.ot.main.productmanagement.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ot.main.productmanagement.data.entity.ProductManagement;

public interface ProductManagementRepository extends JpaRepository<ProductManagement, Integer> {

}
