package com.ot.main.out.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ot.main.out.data.dto.OutCreateRequestDto;
import com.ot.main.out.data.dto.OutUpdateRequestDto;

public interface OutController {
	
	//ResponseEntity<OutCreateResponseDto> saveOut(@RequestBody OutCreateRequestDto OutCreateRequestDto, @RequestParam String productCode);
	ModelAndView saveOut(@ModelAttribute OutCreateRequestDto OutCreateRequestDto, @RequestParam String productCode);
	
	//ResponseEntity<List<OutSelectAllResponseDto>> selectAllOut() throws Exception;
	ModelAndView selectAllOut() throws Exception;
	
	//ResponseEntity<OutUpdateResponseDto> updateOut(@RequestBody OutUpdateRequestDto outUpdateRequestDto) throws Exception;
	ModelAndView updateOut(@ModelAttribute OutUpdateRequestDto outUpdateRequestDto) throws Exception;
	
	
	//ResponseEntity<String> deleteOut(@RequestParam Long id) throws Exception;
	ModelAndView deleteOut(@RequestParam Long id) throws Exception;
}
