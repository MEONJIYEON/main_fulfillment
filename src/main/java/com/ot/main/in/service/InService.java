package com.ot.main.in.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ot.main.in.data.dto.InCreateRequestDto;
import com.ot.main.in.data.dto.InCreateResponseDto;
import com.ot.main.in.data.dto.InSelectAllResponseDto;
import com.ot.main.in.data.dto.InUpdateRequestDto;
import com.ot.main.in.data.dto.InUpdateResponseDto;
import com.ot.main.in.data.dto.MainToManufacturerDto;

public interface InService {
	InCreateResponseDto saveIn(InCreateRequestDto inCreateRequestDto, String productCode);
	List<InSelectAllResponseDto> selectAllIn() throws Exception;
	InUpdateResponseDto updateIn (InUpdateRequestDto inUpdateRequestDto) throws Exception;
	String deleteIn(Long id) throws Exception;
	ResponseEntity<MainToManufacturerDto> mainToManufacturer(String out_productcode, String out_pname, Integer out_stock);
	
}
