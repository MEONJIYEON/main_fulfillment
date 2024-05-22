package com.ot.main.delivery.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ot.main.delivery.controller.DeliveryController;
import com.ot.main.delivery.data.dto.DeliveryCreateRequestDTO;
import com.ot.main.delivery.data.dto.DeliveryCreateResponseDTO;
import com.ot.main.delivery.data.dto.DeliveryListResponseDTO;
import com.ot.main.delivery.data.dto.DeliveryUpdateResponseDTO;
import com.ot.main.delivery.service.DeliveryService;

@RestController()
@RequestMapping(value = "/api/v1/main-fulfillment")
public class DeliveryControllerImpl implements DeliveryController {

	private DeliveryService deliveryService;

	@Autowired
	public DeliveryControllerImpl(DeliveryService deliveryService) {
		System.out.println("==========DeliveryControllerImpl============");
		this.deliveryService = deliveryService;
	}

	// create Delivery
	@PostMapping("/createDelivery")
	@Override
	public ResponseEntity<DeliveryCreateResponseDTO> createDelivery(DeliveryCreateRequestDTO deliveryRequestDTO) {

		System.out.println("==" + deliveryRequestDTO.toString() + "=="); // test 후 삭제
		DeliveryCreateResponseDTO result = deliveryService.createDelivery(deliveryRequestDTO);

		System.out.println(result.toString()); // test 후 삭제
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	// update
	@PutMapping("/updateDelivery")
	@Override
	public ResponseEntity<DeliveryUpdateResponseDTO> updateDelivery(Long id, String productCode, boolean outStatus,
			Integer outStock) {

		// data check ------------------ test 후 삭제처리
		System.out.println("== id : " + id + "==");
		System.out.println("== outStock : " + outStock + "==");
		System.out.println("== outStatus : " + outStatus + "==");
		System.out.println("== productCode : " + productCode + "==");

		DeliveryUpdateResponseDTO result = deliveryService.updateDelivery(id, productCode, outStatus, outStock);
		System.out.println(result.toString());

		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	// 목록조회
	@GetMapping("/selectDeliverylist")
	@Override
	public ModelAndView selectDeliverlist() {
		ModelAndView mav = new ModelAndView();
		
		List<DeliveryListResponseDTO> delivery = deliveryService.selectDeliverlist();
		mav.addObject("deliveryList",delivery);
		mav.setViewName("/delivery/delivery_List");

		return mav;
}
	
	// 재고 상태 변경 update 창 _ 입고
	@GetMapping("/updateByIn")
	@Override
	public ModelAndView updateByIn() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/productManagement/productManagement_updateByIn");
		return mav;
	}

	// 재고 상태 변경 update 창 _ 출고
	@GetMapping("/updateByOut")
	@Override
	public ModelAndView updateByOut() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/productManagement/productManagement_updateByOut");
		return mav;
	}

}
