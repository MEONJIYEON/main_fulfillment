package com.ot.main.out.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ot.main.out.data.dao.OutDAO;
import com.ot.main.out.data.dto.OutCreateRequestDto;
import com.ot.main.out.data.dto.OutCreateResponseDto;
import com.ot.main.out.data.dto.OutSelectAllResponseDto;
import com.ot.main.out.data.dto.OutUpdateRequestDto;
import com.ot.main.out.data.dto.OutUpdateResponseDto;
import com.ot.main.out.data.entity.Out;
import com.ot.main.out.service.OutService;

@Service
public class OutServiceImpl implements OutService {
	
	private OutDAO outDAO;
	
	@Autowired
	public OutServiceImpl(OutDAO outDAO) {
		this.outDAO = outDAO;
	}

	@Override
	public OutCreateResponseDto saveOut(OutCreateRequestDto outCreateRequestDto, String productCode) {
		Out out = new Out();
		out.setOutStatus(outCreateRequestDto.isOutStatus());
		out.setOutStock(outCreateRequestDto.getOutStock());
		out.setOutRequest_at(LocalDateTime.now());

		Out savedOut = outDAO.insertOut(out, productCode);
		
		OutCreateResponseDto outCreateResponseDto = new OutCreateResponseDto();
		outCreateResponseDto.setId(savedOut.getId());
		outCreateResponseDto.setOutStock(savedOut.getOutStock());
		outCreateResponseDto.setProduct(savedOut.getProduct());
		outCreateResponseDto.setOutRequest_at(savedOut.getOutRequest_at());
		outCreateResponseDto.setOutComplete_at(savedOut.getOutComplete_at());
		
		return outCreateResponseDto;
	}

	@Override
	public List<OutSelectAllResponseDto> selectAllOut() {
		List<Out> outList = outDAO.findAllout();

		List<OutSelectAllResponseDto> outSelectectAllList = outList.stream()
				.map(out -> OutSelectAllResponseDto.builder()
					.id(out.getId())
					.Product(out.getProduct())
					.outStock(out.getOutStock())
					.outRequest_at(out.getOutRequest_at())
					.outComplete_at(out.getOutComplete_at())
					.outStatus(out.isOutStatus())
					.build())
				.collect(Collectors.toList());
		
		return outSelectectAllList;
	}
	

	@Override
	public OutUpdateResponseDto updateOut(OutUpdateRequestDto outUpdateRequestDto) {
		Out out = new Out();
		out.setId(outUpdateRequestDto.getId());
		out.setOutStock(outUpdateRequestDto.getOutStock());
		out.setOutStatus(outUpdateRequestDto.isOutStatus());
		out.setOutComplete_at(outUpdateRequestDto.getOutComplete_at());
		
		Out updatedOut = outDAO.updateOut(out);
		
		OutUpdateResponseDto outUpdateResponseDto = new OutUpdateResponseDto();
		outUpdateResponseDto.setId(updatedOut.getId());
		outUpdateResponseDto.setOutStock(updatedOut.getOutStock());
		outUpdateResponseDto.setProduct(updatedOut.getProduct());
		outUpdateResponseDto.setOutStatus(updatedOut.isOutStatus());
		outUpdateResponseDto.setOutRequest_at(updatedOut.getOutRequest_at());
		outUpdateResponseDto.setOutComplete_at(updatedOut.getOutComplete_at());
		
		return outUpdateResponseDto;
	}

	@Override
	public String deleteOut(Long id) {
		String result = outDAO.deleteOut(id);
		return result;
	}
	
	
	
}
