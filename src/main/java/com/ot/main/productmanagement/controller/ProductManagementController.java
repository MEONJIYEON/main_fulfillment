package com.ot.main.productmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ot.main.productmanagement.data.dto.ProductManagementResponseDTO;

public interface ProductManagementController  {
 
	    //LOOK UP STOCK
		public String lookUpStock(ProductManagementResponseDTO productManagtementResponseDTO);
		
		//LOOK UP STOCK DETAIL
		public String lookUpStockDetail(@RequestParam Long id);
		
		//CREATE STOCK
		public ResponseEntity<ProductManagementResponseDTO> createStock(@RequestParam String productCode);		
		
		//MODIFY STOCK
		public ResponseEntity<ProductManagementResponseDTO> modifyStock(@RequestBody ProductManagementResponseDTO productManagementResponseDTO);
		
		//CALCULATE SAFETYSTOCK
		public void calculateSafetyStock();
}
