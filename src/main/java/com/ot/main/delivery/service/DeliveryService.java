package com.ot.main.delivery.service;

import com.ot.main.delivery.data.dto.DeliveryCreateRequestDTO;
import com.ot.main.delivery.data.dto.DeliveryCreateResponseDTO;
import com.ot.main.delivery.data.dto.DeliveryUpdateResponseDTO;

public interface DeliveryService  {
	
	//create
	DeliveryCreateResponseDTO createDelivery(DeliveryCreateRequestDTO deliveryRequestDTO);

	//update
	DeliveryUpdateResponseDTO updateDelivery(Long id, String productCode,
			boolean outStatus, Integer outStock);
}
