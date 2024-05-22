package com.ot.main.out.controller.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
	// insert 
	/*
	@Override
	@PostMapping()
	public ResponseEntity<OutCreateResponseDto> saveOut(OutCreateRequestDto OutCreateRequestDto, String productCode) {
		OutCreateResponseDto outCreateResponseDto = outService.saveOut( OutCreateRequestDto, productCode);
		return ResponseEntity.status(HttpStatus.OK).body(outCreateResponseDto);
	}
	*/
	@Override
	@PostMapping("/create")
	public ModelAndView saveOut(@ModelAttribute OutCreateRequestDto OutCreateRequestDto, @RequestParam String productCode) {
		OutCreateResponseDto outCreateResponseDto = outService.saveOut(OutCreateRequestDto, productCode);
		
		return new ModelAndView("redirect:/api/v1/main-fulfillment/out/selectAll");
	}
	
	@PostMapping("/createPage")
	public ModelAndView saveOutPage(@RequestParam String productCode) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("productCode", productCode);
		mav.setViewName("/out/out_create");
		
		return mav;
		
	}
	
	
	// selectAll
	/*
	@Override
	@GetMapping()
	public ResponseEntity<List<OutSelectAllResponseDto>> selectAllOut() throws Exception {
		List<OutSelectAllResponseDto> outSelectAllResponseDtoList = outService.selectAllOut();
		return ResponseEntity.status(HttpStatus.OK).body(outSelectAllResponseDtoList);
	}
	*/
	
	@Override
	@GetMapping("/selectAll")
	public ModelAndView selectAllOut() throws Exception {
		List<OutSelectAllResponseDto> outSelectAllResponseDtoList = outService.selectAllOut();
		ModelAndView mav = new ModelAndView();
		mav.addObject("outs", outSelectAllResponseDtoList);
		mav.setViewName("/out/out_selectall");
		return mav;
	}

	// update
	/*
	@Override
	@PutMapping()
	public ResponseEntity<OutUpdateResponseDto> updateOut(OutUpdateRequestDto outUpdateRequestDto) throws Exception {
		OutUpdateResponseDto outUpdateResponseDto = outService.updateOut(outUpdateRequestDto);
		return ResponseEntity.status(HttpStatus.OK).body(outUpdateResponseDto);
	}
	*/
	
	@Override
	@PostMapping("/update")
	public ModelAndView updateOut(@ModelAttribute OutUpdateRequestDto outUpdateRequestDto) throws Exception {
		OutUpdateResponseDto outUpdateResponseDto = outService.updateOut(outUpdateRequestDto);
		return new ModelAndView("redirect:/api/v1/main-fulfillment/out/selectAll");
	}
	
	@PostMapping("/updatePage")
	public ModelAndView updateOutPage(@ModelAttribute OutUpdateRequestDto outUpdateRequestDto) {
		ModelAndView mav = new ModelAndView("/out/out_update");
		mav.addObject("out", outUpdateRequestDto);
		return mav;
		
	}

	
	// delete
	/*
	@Override
	@DeleteMapping()
	public ResponseEntity<String> deleteOut(Long id) throws Exception {
		String result = outService.deleteOut(id);
		return ResponseEntity.status(HttpStatus.OK).body(result) ;
	}
	*/
	
	@Override
	@PostMapping("/delete")
	public ModelAndView deleteOut(Long id) throws Exception {
		String result = outService.deleteOut(id);
		return new ModelAndView("redirect:/api/v1/main-fulfillment/out/selectAll");
	}
	

	
	
	

}
