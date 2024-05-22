package com.ot.main.in.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ot.main.in.data.dto.InCreateRequestDto;
import com.ot.main.in.data.dto.InUpdateRequestDto;


public interface InController  {
	
	//ResponseEntity<InCreateResponseDto> saveIn(@RequestBody InCreateRequestDto inCreateRequestDto, @RequestParam String productCode);
	ModelAndView saveIn(@ModelAttribute InCreateRequestDto inCreateRequestDto, @RequestParam String productCode);
	
	//ResponseEntity<List<InSelectAllResponseDto>> selectAllIn() throws Exception;
	ModelAndView selectAllIn() throws Exception;
	
	//ResponseEntity<InUpdateResponseDto> updateIn(@RequestBody InUpdateRequestDto inUpdateRequestDto) throws Exception;
	ModelAndView updateIn(@ModelAttribute InUpdateRequestDto inUpdateRequestDto) throws Exception;
	
	
	//ResponseEntity<String> deleteIn(@RequestParam Long id) throws Exception;
	ModelAndView deleteIn(@RequestParam Long id) throws Exception;
	
	
}
