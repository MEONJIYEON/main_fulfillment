package com.ot.main.in.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ot.main.in.controller.InController;
import com.ot.main.in.data.dto.InCreateRequestDto;
import com.ot.main.in.data.dto.InCreateResponseDto;
import com.ot.main.in.data.dto.InSelectAllResponseDto;
import com.ot.main.in.data.dto.InUpdateRequestDto;
import com.ot.main.in.data.dto.InUpdateResponseDto;
import com.ot.main.in.service.InService;


@RestController
@RequestMapping("/api/v1/main-fulfillment/in")
public class InControllerImpl implements InController {
	
	private InService inService;
	
	@Autowired
	public InControllerImpl(InService inService) {
		this.inService = inService;
	}
	
	@Override
	@PostMapping()
	public ResponseEntity<InCreateResponseDto> saveIn(InCreateRequestDto inCreateRequestDto, String productCode) {
		InCreateResponseDto inCreateResponseDto = inService.saveIn(inCreateRequestDto, productCode);
		return ResponseEntity.status(HttpStatus.OK).body(inCreateResponseDto);
	}

	@Override
	@GetMapping()
	public ResponseEntity<List<InSelectAllResponseDto>> selectAllIn() throws Exception {
		List<InSelectAllResponseDto> inSelectAllResponseDtoList = inService.selectAllIn();
		
		return ResponseEntity.status(HttpStatus.OK).body(inSelectAllResponseDtoList);
	}

	@Override
	@PutMapping()
	public ResponseEntity<InUpdateResponseDto> updateIn(InUpdateRequestDto inUpdateRequestDto) throws Exception {
		InUpdateResponseDto inUpdateResponseDto = inService.updateIn(inUpdateRequestDto);
		
		return ResponseEntity.status(HttpStatus.OK).body(inUpdateResponseDto);
	}

	@Override
	@DeleteMapping()
	public ResponseEntity<String> deleteIn(@RequestParam Long id) throws Exception {
		String result = inService.deleteIn(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	
		
	
	
	
	
}
