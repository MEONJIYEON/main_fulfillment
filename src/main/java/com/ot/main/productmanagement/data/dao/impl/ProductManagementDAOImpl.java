package com.ot.main.productmanagement.data.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ot.main.product.data.repository.ProductRepository;
import com.ot.main.productmanagement.data.dao.ProductManagementDAO;
import com.ot.main.productmanagement.data.entity.ProductManagement;
import com.ot.main.productmanagement.data.repository.ProductManagementRepository;


@Component
public class ProductManagementDAOImpl implements ProductManagementDAO{

	private final ProductManagementRepository productManagementRepository;
	
	@Autowired
	public ProductManagementDAOImpl(ProductManagementRepository productManagementRepository, ProductRepository productRepository) {
		this.productManagementRepository = productManagementRepository;
		
	}
	
//CREATE
	@Override
	public ProductManagement createStock(ProductManagement productManagement) {
    	ProductManagement createStock = productManagementRepository.save(productManagement);
    	System.out.println("createStock : " + createStock);
		return createStock;
	}

	
//	Update
	@Override
	public ProductManagement modifyInStock(String productCode, boolean inStatus, Integer inStock) {
		ProductManagement udpateStock = productManagementRepository.findByProductCode(productCode);
		
		if (udpateStock != null && inStatus == true) {
			udpateStock.setProductCode(productCode);
			
			//입고
			udpateStock.setProductStock(udpateStock.getProductStock() + inStock);
				
			productManagementRepository.save(udpateStock);
	    	System.out.println("checkStock : " + udpateStock);
		}
		return udpateStock;
	}
	
//	Update
	@Override
	public ProductManagement modifyOutStock(String productCode, boolean OutStatus, Integer OutStock) {
		ProductManagement udpateStock = productManagementRepository.findByProductCode(productCode);
		
		if (udpateStock != null && OutStatus == true) {
			udpateStock.setProductCode(productCode);
			
			//입고
			udpateStock.setProductStock(udpateStock.getProductStock() - OutStock);
				
			productManagementRepository.save(udpateStock);
	    	System.out.println("checkStock : " + udpateStock);
		}
		return udpateStock;
	}

	//selectOneDetail
	@Override
	public ProductManagement selectOneStock(Long id) {
		ProductManagement stock = productManagementRepository.getById(id);
		return stock;
	}

	//목록 조회
	@Override
	public List<ProductManagement> selectStockList( ) {
		
		List<ProductManagement> stockList = productManagementRepository.findAll();		
		
		return stockList;
	}

	
	//재고 비교
	@Override
	public ProductManagement compareStockAndSafetyStock(String productCode) {
	
		ProductManagement compareManagement = productManagementRepository.findByProductCode(productCode);
		
		if (compareManagement != null) {
			Integer compareProductStock = compareManagement.getProductStock();
			Integer compareSafetyStock = compareManagement.getSafetyStock();
			
			if (compareProductStock != null && compareSafetyStock!= null &&   compareProductStock <= compareSafetyStock ) {
				System.out.println("compareProductStock : " + compareProductStock + ":::::::::: compareSafetyStock : " +  compareSafetyStock);
				System.out.println("입고요청");
			}
		}
		return null;
	}


	

	


}
