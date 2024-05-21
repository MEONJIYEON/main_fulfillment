package com.ot.main.out.controller.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ot.main.out.controller.OutController;
import com.ot.main.out.data.dto.OutCreateRequestDto;
import com.ot.main.out.data.dto.OutCreateResponseDto;
import com.ot.main.out.data.dto.OutSelectAllResponseDto;
import com.ot.main.out.data.dto.OutUpdateRequestDto;
import com.ot.main.out.data.dto.OutUpdateResponseDto;
import com.ot.main.out.service.OutService;


@RestController
@RequestMapping("/api/v1/main-fulfillment/out")
public class OutControllerImpl implements OutController	 {
	
	private OutService outService;
	
	@Autowired
	public OutControllerImpl(OutService outService) {
		this.outService = outService;
	}

	@Override
	@PostMapping()
	public ResponseEntity<OutCreateResponseDto> saveOut(OutCreateRequestDto OutCreateRequestDto, String productCode) {
		OutCreateResponseDto outCreateResponseDto = outService.saveOut( OutCreateRequestDto, productCode);
		return ResponseEntity.status(HttpStatus.OK).body(outCreateResponseDto);
	}

	@Override
	@GetMapping()
	public ResponseEntity<List<OutSelectAllResponseDto>> selectAllOut() throws Exception {
		List<OutSelectAllResponseDto> outSelectAllResponseDtoList = outService.selectAllOut();
		return ResponseEntity.status(HttpStatus.OK).body(outSelectAllResponseDtoList);
	}

	@Override
	@PutMapping()
	public ResponseEntity<OutUpdateResponseDto> updateOut(OutUpdateRequestDto outUpdateRequestDto) throws Exception {
		OutUpdateResponseDto outUpdateResponseDto = outService.updateOut(outUpdateRequestDto);
		return ResponseEntity.status(HttpStatus.OK).body(outUpdateResponseDto);
	}

	@Override
	@DeleteMapping()
	public ResponseEntity<String> deleteOut(Long id) throws Exception {
		String result = outService.deleteOut(id);
		return ResponseEntity.status(HttpStatus.OK).body(result) ;
	}
	
	

}
