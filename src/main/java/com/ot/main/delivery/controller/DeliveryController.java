package com.ot.main.delivery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ot.main.delivery.data.dto.DeliveryCreateRequestDTO;
import com.ot.main.delivery.data.dto.DeliveryCreateResponseDTO;
import com.ot.main.delivery.data.dto.DeliveryUpdateResponseDTO;

public interface DeliveryController {

	//create
	ResponseEntity<DeliveryCreateResponseDTO> createDelivery(@RequestBody DeliveryCreateRequestDTO deliveryRequestDTO);
	
	//상품코드랑 출고상태와 출고 재고량
	//select one & update
	ResponseEntity<DeliveryUpdateResponseDTO> updateDelivery(@RequestParam Long id, 
			@RequestParam String productCode, @RequestParam boolean outStatus, @RequestParam Integer outStock);
	

}
