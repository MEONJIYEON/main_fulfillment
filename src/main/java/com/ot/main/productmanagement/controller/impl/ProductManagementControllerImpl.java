package com.ot.main.productmanagement.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ot.main.productmanagement.controller.ProductManagementController;
import com.ot.main.productmanagement.data.dto.ProductManagementCreateRequestDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementCreateResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementCompareResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementSelectListResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementSelectOneResponseDTO;
import com.ot.main.productmanagement.data.dto.ProductManagementUpdateResponseDTO;
import com.ot.main.productmanagement.service.ProductManagementService;

@RestController
@RequestMapping(value = "/api/v1/main-fulfillment")
public class ProductManagementControllerImpl implements ProductManagementController {

	private final ProductManagementService productManagementService;

	@Autowired
	public ProductManagementControllerImpl(ProductManagementService productManagementService) {
		this.productManagementService = productManagementService;
	}

	// 재고 생성
	@PostMapping("createStock")
	@Override
	public ResponseEntity<ProductManagementCreateResponseDTO> createStock(
			ProductManagementCreateRequestDTO productManagementCreateRequestDTO) {

		ProductManagementCreateResponseDTO createProduct = productManagementService
				.createStock(productManagementCreateRequestDTO);
		System.out.println("============createProduct : " + createProduct + "================");

		return ResponseEntity.status(HttpStatus.OK).body(createProduct);
	}

	// 재고수정
	@PutMapping("/modifyInStock")
	@Override
	public ResponseEntity<ProductManagementUpdateResponseDTO> modifyInStock(String productCode, boolean inStatus,
			Integer inStock) {

		ProductManagementUpdateResponseDTO updateProduct = productManagementService.modifyInStock(productCode, inStatus,
				inStock);
		System.out.println("============updateProduct  : " + updateProduct + "================");

		return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
	}
	
	// 재고수정
		@PutMapping("/modifyOutStock")
		@Override
		public ResponseEntity<ProductManagementUpdateResponseDTO> modifyOutStock(String productCode, boolean outStatus, 
				Integer outStock) {

			ProductManagementUpdateResponseDTO updateProduct = productManagementService.modifyOutStock(productCode, outStatus, outStock);
	
			System.out.println("============updateProduct  : " + updateProduct + "================");

			return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
		}

	// 재고 상세보기
	@GetMapping("/selectStockDetail")
	@Override
	public ResponseEntity<ProductManagementSelectOneResponseDTO> selectStockDetail(Long id) {

		ProductManagementSelectOneResponseDTO oneStock = productManagementService.selectStockDetail(id);
		System.out.println("oneStock : " + oneStock);

		 return ResponseEntity.status(HttpStatus.OK).body(oneStock);
	}

	// 재고목록 조회
	@GetMapping("/lookUpStock")
	@Override
	public ResponseEntity<List<ProductManagementSelectListResponseDTO>> selectStockList() {

		List<ProductManagementSelectListResponseDTO> stockList = productManagementService.selectStockList();
		System.out.println("=========" + stockList + "=========");
		
		return ResponseEntity.status(HttpStatus.OK).body(stockList) ;
	}

	// 안전재고 , 보유 재고 비교
	@GetMapping("/compareStockAndSafetyStock")
	@Override
	public void compareStockAndSafetyStock(String productCode) {
		ProductManagementCompareResponseDTO productManagementCompareResponseDTO = productManagementService.compareStockAndSafetyStock(productCode);
	}
	
	// 서버로부터 주문정보를 받아옴 
	
	// 주문정보를 세션에다가 때려박음 
	
	/*
	public 서버통신(){
		서버통신 -> 데이터 
		Session session = new Session();
		session.get("id" , product.getProduct);
		
		
		session.invalid();
	
	}
	
	
	
	
	
	*/
}
