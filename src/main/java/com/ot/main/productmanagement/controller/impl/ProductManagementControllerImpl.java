package com.ot.main.productmanagement.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ot.main.productmanagement.controller.ProductManagementController;
import com.ot.main.productmanagement.data.dto.ProductManagementResponseDTO;
import com.ot.main.productmanagement.service.ProductManagementService;

@RestController
@RequestMapping(value = "/api/v1/main-fulfillment")
public class ProductManagementControllerImpl implements ProductManagementController {

	private final ProductManagementService productManagementService;

	@Autowired
	public ProductManagementControllerImpl(ProductManagementService productManagementService) {
		this.productManagementService = productManagementService;
	}

	@GetMapping("/lookUpStock")
	@Override
	// lookup stock
	public String lookUpStock(ProductManagementResponseDTO productManagementResponseDTO) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/lookUpStock");

		List<ProductManagementResponseDTO> stockList = this.productManagementService
				.lookUpStock(productManagementResponseDTO);
		System.out.println("stockList : " + stockList);
		return "list";
	}

	@GetMapping("/lookUpStockDetail")
	@Override
	public String lookUpStockDetail(Long id) {
		ModelAndView mav = new ModelAndView();

		ProductManagementResponseDTO oneStock = new ProductManagementResponseDTO();

		oneStock = productManagementService.lookUpStockDetail(id);
		System.out.println("oneStock : " + oneStock);

		mav.addObject("oneStock", oneStock);
		mav.setView(null);

		return "detail";
	}
	
	@GetMapping("")
	@Override
	public ResponseEntity<ProductManagementResponseDTO> createStock(String productCode) {
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@PutMapping("/modifyStock")
	@Override
	public ResponseEntity<ProductManagementResponseDTO> modifyStock(@RequestBody ProductManagementResponseDTO productManagementResponseDTO) {
		ProductManagementResponseDTO result = productManagementService.modifyStock(productManagementResponseDTO);
		
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@Override
	public void calculateSafetyStock() {
		// TODO Auto-generated method stub

	}

	

}
