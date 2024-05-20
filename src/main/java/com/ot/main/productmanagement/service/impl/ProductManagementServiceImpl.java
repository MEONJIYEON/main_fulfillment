package com.ot.main.productmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot.main.productmanagement.data.dao.ProductManagementDAO;
import com.ot.main.productmanagement.data.dto.ProductManagementResponseDTO;
import com.ot.main.productmanagement.data.entity.ProductManagement;
import com.ot.main.productmanagement.service.ProductManagementService;

@Service
public class ProductManagementServiceImpl implements ProductManagementService {

	private ProductManagementDAO productManagementDAO;

	@Autowired
	public ProductManagementServiceImpl(ProductManagementDAO productManagementDAO) {
		this.productManagementDAO = productManagementDAO;
	}

	@Override
	public List<ProductManagementResponseDTO> lookUpStock(ProductManagementResponseDTO productManagementResponseDTO) {
		return productManagementDAO.lookUpStock(productManagementResponseDTO);
	}

	@Override
	public ProductManagementResponseDTO lookUpStockDetail(Long id) {
		return productManagementDAO.lookUpStockDetail(id);
	}

	
	@Override
	public List<ProductManagement> lookUpEntity() {
		return productManagementDAO.lookUpEntity();
	}

	@Override
	public void calculateSafetyStock() {
		// TODO Auto-generated method stub

	}

	@Override
	public ProductManagementResponseDTO modifyStock(ProductManagementResponseDTO productManagementResponseDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
