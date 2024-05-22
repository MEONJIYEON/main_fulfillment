package com.ot.main.in.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ot.main.in.controller.InController;
import com.ot.main.in.data.dto.InCreateRequestDto;
import com.ot.main.in.data.dto.InCreateResponseDto;
import com.ot.main.in.data.dto.InSelectAllResponseDto;
import com.ot.main.in.data.dto.InUpdateRequestDto;
import com.ot.main.in.data.dto.InUpdateResponseDto;
import com.ot.main.in.service.InService;
import com.ot.main.out.data.dto.OutUpdateRequestDto;


@RestController
@RequestMapping("/api/v1/main-fulfillment/in")
public class InControllerImpl implements InController {
	
	private InService inService;
	
	@Autowired
	public InControllerImpl(InService inService) {
		this.inService = inService;
	}

	// create
	/*
	@Override
	@PostMapping()
	public ResponseEntity<InCreateResponseDto> saveIn(InCreateRequestDto inCreateRequestDto, String productCode) {
		InCreateResponseDto inCreateResponseDto = inService.saveIn(inCreateRequestDto, productCode);
		return ResponseEntity.status(HttpStatus.OK).body(inCreateResponseDto);
	}
	*/
	
	@Override
	@PostMapping("/create")
	public ModelAndView saveIn(InCreateRequestDto inCreateRequestDto, String productCode) {
		InCreateResponseDto inCreateResponseDto = inService.saveIn(inCreateRequestDto, productCode);
		return new ModelAndView("redirect:/api/v1/main-fulfillment/in/selectAll");
	}
	
	@PostMapping("/createPage")
	public ModelAndView saveInPage(@RequestParam String productCode) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("productCode", productCode);
		mav.setViewName("/in/in_create");
		
		return mav;
		
	}
	
	// selectAll
	/*
	@Override
	@GetMapping()
	public ResponseEntity<List<InSelectAllResponseDto>> selectAllIn() throws Exception {
		List<InSelectAllResponseDto> inSelectAllResponseDtoList = inService.selectAllIn();
		
		return ResponseEntity.status(HttpStatus.OK).body(inSelectAllResponseDtoList);
	}
	*/
	
	@Override
	@GetMapping("/selectAll")
	public ModelAndView selectAllIn() throws Exception {
		List<InSelectAllResponseDto> inSelectAllResponseDtoList = inService.selectAllIn();
		ModelAndView mav = new ModelAndView();
		mav.addObject("ins", inSelectAllResponseDtoList);
		mav.setViewName("/in/in_selectall");
		return mav;
	}
	

	// update
	/*
	@Override
	@PutMapping()
	public ResponseEntity<InUpdateResponseDto> updateIn(InUpdateRequestDto inUpdateRequestDto) throws Exception {
		InUpdateResponseDto inUpdateResponseDto = inService.updateIn(inUpdateRequestDto);
		
		return ResponseEntity.status(HttpStatus.OK).body(inUpdateResponseDto);
	}
	*/
	

	@Override
	@PostMapping("/update")
	public ModelAndView updateIn(InUpdateRequestDto inUpdateRequestDto) throws Exception {
		InUpdateResponseDto inUpdateResponseDto = inService.updateIn(inUpdateRequestDto);
		return new ModelAndView("redirect:/api/v1/main-fulfillment/in/selectAll");
	}

	
	@PostMapping("/updatePage")
	public ModelAndView updateOutPage(@ModelAttribute InUpdateRequestDto inUpdateRequestDto) {
		ModelAndView mav = new ModelAndView("/in/in_update");
		mav.addObject("in", inUpdateRequestDto);
		return mav;
		
	}

	// delete 
	/*
	@Override
	@DeleteMapping()
	public ResponseEntity<String> deleteIn(@RequestParam Long id) throws Exception {
		String result = inService.deleteIn(id);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	*/
	
	@Override
	@PostMapping("/delete")
	public ModelAndView deleteIn(Long id) throws Exception {
		String result = inService.deleteIn(id);
		return new ModelAndView("redirect:/api/v1/main-fulfillment/in/selectAll");
	}
	
	
		
	
	
	
	
}
