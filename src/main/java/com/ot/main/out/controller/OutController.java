package com.ot.main.out.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ot.main.out.data.dto.OutCreateRequestDto;
import com.ot.main.out.data.dto.OutCreateResponseDto;
import com.ot.main.out.data.dto.OutSelectAllResponseDto;
import com.ot.main.out.data.dto.OutUpdateRequestDto;
import com.ot.main.out.data.dto.OutUpdateResponseDto;

public interface OutController {
	
	ResponseEntity<OutCreateResponseDto> saveOut(@RequestBody OutCreateRequestDto OutCreateRequestDto, @RequestParam String productCode);
	ResponseEntity<List<OutSelectAllResponseDto>> selectAllOut() throws Exception;
	ResponseEntity<OutUpdateResponseDto> updateOut(@RequestBody OutUpdateRequestDto outUpdateRequestDto) throws Exception;
	ResponseEntity<String> deleteOut(@RequestParam Long id) throws Exception;

}
