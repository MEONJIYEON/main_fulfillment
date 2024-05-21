package com.ot.main.productmanagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ot.main.productmanagement.data.dto.ProductManagementCreateRequestDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementCreateResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementCompareResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementSelectListResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementSelectOneResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementUpdateResponseDTO;
import com.ot.main.productmanagement.data.entity.ProductManagement;

public interface ProductManagementController  {
	
	
	//CREATE STOCK
	public ResponseEntity<ProductManagementCreateResponseDTO> createStock(@RequestBody ProductManagementCreateRequestDTO productManagementCreateRequestDTO);		
	
	//MODIFY STOCK (상품코드랑 입고상태와 수량)
	public ResponseEntity<ProductManagementUpdateResponseDTO> modifyInStock(@RequestParam String productCode , boolean inStatus, Integer inStock);
	
	//MODIFY STOCK (상품코드랑 출고상태와 수량)
	public ResponseEntity<ProductManagementUpdateResponseDTO> modifyOutStock(@RequestParam String productCode , boolean outStatus, Integer outStock);
	
	//selectStockDetail
	public ResponseEntity<ProductManagementSelectOneResponseDTO> selectStockDetail(@RequestParam Long id);
	
	//selectStockList
	public ResponseEntity<List<ProductManagementSelectListResponseDTO>> selectStockList();
			
	//compareStockAndSafetyStock
	//상품코드를 가진 주문이 있으면, ProductManagementSelectOneResponseDTO의 안전재고와 보유재고를 비교하고 IN OUT create 
	public void compareStockAndSafetyStock(@RequestParam String productCode);

}
