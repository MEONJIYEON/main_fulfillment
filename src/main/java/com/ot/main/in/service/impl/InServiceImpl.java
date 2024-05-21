package com.ot.main.in.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot.main.in.data.dao.InDAO;
import com.ot.main.in.data.dto.InCreateRequestDto;
import com.ot.main.in.data.dto.InCreateResponseDto;
import com.ot.main.in.data.dto.InSelectAllResponseDto;
import com.ot.main.in.data.dto.InUpdateRequestDto;
import com.ot.main.in.data.dto.InUpdateResponseDto;
import com.ot.main.in.data.entity.In;
import com.ot.main.in.service.InService;

@Service
public class InServiceImpl implements InService {
	
	private InDAO inDAO;
	
	@Autowired
	public InServiceImpl(InDAO inDAO) {
		this.inDAO = inDAO;
	}
	
	@Override
	public InCreateResponseDto saveIn(InCreateRequestDto inCreateRequestDto, String productCode) {
		In in = new In();
		in.setInStatus(inCreateRequestDto.isInStatus());
		in.setInStock(inCreateRequestDto.getInStock());
		in.setInRequest_at(LocalDateTime.now());

		In savedIn = inDAO.insertIn(in, productCode);
		
		InCreateResponseDto inCreateResponseDto = new InCreateResponseDto();
		inCreateResponseDto.setId(savedIn.getId());
		inCreateResponseDto.setInStock(savedIn.getInStock());
		inCreateResponseDto.setProduct(savedIn.getProduct());
		inCreateResponseDto.setInRequest_at(savedIn.getInRequest_at());
		inCreateResponseDto.setInComplete_at(savedIn.getInComplete_at());
		
		return inCreateResponseDto;
	}

	@Override
	public List<InSelectAllResponseDto> selectAllIn() throws Exception {
		List<In> inList = inDAO.findAllIn();
		
		List<InSelectAllResponseDto> inSelectAllList  = inList.stream()
				.map(in -> InSelectAllResponseDto.builder()
						.id(in.getId())
						.Product(in.getProduct())
						.inStock(in.getInStock())
						.inRequest_at(in.getInRequest_at())
						.inComplete_at(in.getInComplete_at())
						.inStatus(in.isInStatus())
						.build())
				.collect(Collectors.toList());
		
		return inSelectAllList;
	}

	@Override
	public InUpdateResponseDto updateIn(InUpdateRequestDto inUpdateRequestDto) throws Exception {
		In in = new In();
		in.setId(inUpdateRequestDto.getId());
		in.setInStock(inUpdateRequestDto.getInStock());
		in.setInStatus(inUpdateRequestDto.isInStatus());
		in.setInComplete_at(inUpdateRequestDto.getInComplete_at());
		
		In updatedIn = inDAO.updateIn(in);
		
		InUpdateResponseDto inUpdateResponseDto = new InUpdateResponseDto();
		inUpdateResponseDto.setId(updatedIn.getId());
		inUpdateResponseDto.setInStock(updatedIn.getInStock());
		inUpdateResponseDto.setProduct(updatedIn.getProduct());
		inUpdateResponseDto.setInStatus(updatedIn.isInStatus());
		inUpdateResponseDto.setInRequest_at(updatedIn.getInRequest_at());
		inUpdateResponseDto.setInComplete_at(updatedIn.getInComplete_at());
		
		return inUpdateResponseDto;
	}

	@Override
	public String deleteIn(Long id) throws Exception {
		String result = inDAO.deleteIn(id);
		return result;
	}

}
