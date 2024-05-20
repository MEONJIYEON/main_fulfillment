package com.ot.main.productmanagement.data.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ot.main.product.data.entity.Product;
import com.ot.main.product.data.repository.ProductRepository;
import com.ot.main.productmanagement.data.dao.ProductManagementDAO;
import com.ot.main.productmanagement.data.dto.ProductManagementResponseDTO;
import com.ot.main.productmanagement.data.entity.ProductManagement;
import com.ot.main.productmanagement.data.repository.ProductManagementRepository;


@Component
public class ProductManagementDAOImpl implements ProductManagementDAO{

	private final ProductManagementRepository productManagementRepository;
	
	@Autowired
	public ProductManagementDAOImpl(ProductManagementRepository productManagementRepository, ProductRepository productRepository) {
		this.productManagementRepository = productManagementRepository;
		
	}
	
	
	@Override
	public List<ProductManagementResponseDTO> lookUpStock(ProductManagementResponseDTO productManagementResponseDTO) {
		//페이징
		
		//목록 조회		
		List<ProductManagement> checkStockList = productManagementRepository.findAll();
		
		ArrayList<ProductManagementResponseDTO> stockList = new ArrayList<ProductManagementResponseDTO>();
		
		for (ProductManagement checkStock : checkStockList) {
			if (checkStock != null) {
				productManagementResponseDTO.setId(checkStock.getId());
				productManagementResponseDTO.setProductCode(checkStock.getProductCode());
				
				stockList.add(productManagementResponseDTO);
		}
		
	}
		return stockList;
	}

	@Override
	public ProductManagementResponseDTO lookUpStockDetail(Long id) {

		Optional<ProductManagement> stock = productManagementRepository.findById(id);

		ProductManagementResponseDTO productManagementResponseDTO = new ProductManagementResponseDTO();

		ProductManagement betaStock = stock.get();

		System.out.println("betaStock : " + betaStock);

		if (stock.isPresent()) {
			productManagementResponseDTO.setId(betaStock.getId());
			productManagementResponseDTO.setProductCode(betaStock.getProductCode());
		}

		return productManagementResponseDTO;
	}
	/*
	@Override
	public ProductManagementResponseDTO modifyStock(ProductManagementResponseDTO productManagementResponseDTO) {
	//Optional<ProductManagement> modifyStock = this.productManagementRepository.findById(productManagementResponseDTO.getId());

	Optional<ProductManagement> productManagement= productManagementRepository.findById(productManagementResponseDTO.getProductCode().getProductCode());
	System.out.println("========================================================");
	System.out.println(productManagement);
	System.out.println("========================================================");
	
	
	if (modifyStock.isPresent()) {
		ProductManagement stock = modifyStock.get();
		stock = productManagementResponseDTO.fill(stock);
		this.productManagementRepository.save(stock);	//save
		
		System.out.println("stock : " + stock);
	}
	
    return productManagementResponseDTO;
	}
	*/
	
	@Override
	public ProductManagement modifyStock(ProductManagement productManagement) {
		
		System.out.println("==============================getProductCode()==========================");
		String productManagementTest = productManagement.getProductCode();
		System.out.println(productManagementTest);
		System.out.println("==============================getProductCode()==========================");
		
		Optional<ProductManagement> modifyStock = productManagementRepository.findById(productManagement.getProductCode());
		System.out.println("==============================modifyStock==========================");
		System.out.println(modifyStock);
		System.out.println("==============================modifyStock==========================");
		ProductManagement stock;
		if (modifyStock.isPresent()) {
			stock = modifyStock.get();
			System.out.println("==============================stock==========================");
			System.out.println(stock);
			System.out.println("==============================stock==========================");
			stock.setLeadTime(productManagement.getLeadTime());
			stock.setName(productManagement.getName());;
			stock.setProductStock(productManagement.getProductStock());
			stock.setSafetyStock(productManagement.getSafetyStock());
		} else {
			stock = new ProductManagement();
		}
		return stock;
	}


	/*lookUpEntity*/
	/*
	@Override
	public List<ProductManagement> lookUpEntity() {
		List<ProductManagement> orginList = this.productManagementRepository.findAll();
		
		for (ProductManagement orgin : orginList) {
			if (orgin != null) {
				Product product = orgin.getProductCode();
				if (product != null) {
					orgin.setLeadTime(product.getLeadTime());
					orgin.setName(product.getName());
					orgin.setProductStock(product.getProductStock());
					orgin.setSafetyStock(product.getSafetyStock());
					//orgin.setProduct.(product.getProductCode());
					//orgin.getProduct().setProductCode(product.getProductCode());
					orginList.add(orgin);
				}
			}
		}
		
		System.out.println("orginList : " + orginList);
		return orginList;
	}
*/

	
	@Override
	public void calculateSafetyStock() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<ProductManagement> lookUpEntity() {
		// TODO Auto-generated method stub
		return null;
	}


	


}
