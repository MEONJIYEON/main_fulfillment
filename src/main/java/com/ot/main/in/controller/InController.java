package com.ot.main.in.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ot.main.in.data.dto.InCreateRequestDto;
import com.ot.main.in.data.dto.InCreateResponseDto;
import com.ot.main.in.data.dto.InSelectAllResponseDto;
import com.ot.main.in.data.dto.InUpdateRequestDto;
import com.ot.main.in.data.dto.InUpdateResponseDto;

public interface InController  {
	ResponseEntity<InCreateResponseDto> saveIn(@RequestBody InCreateRequestDto inCreateRequestDto, @RequestParam String productCode);
	ResponseEntity<List<InSelectAllResponseDto>> selectAllIn() throws Exception;
	ResponseEntity<InUpdateResponseDto> updateIn(@RequestBody InUpdateRequestDto inUpdateRequestDto) throws Exception;
	ResponseEntity<String> deleteIn(@RequestParam Long id) throws Exception;
	
	
}
