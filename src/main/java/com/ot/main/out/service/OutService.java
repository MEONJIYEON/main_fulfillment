package com.ot.main.out.service;

import java.util.List;

import com.ot.main.out.data.dto.OutCreateRequestDto;
import com.ot.main.out.data.dto.OutCreateResponseDto;
import com.ot.main.out.data.dto.OutSelectAllResponseDto;
import com.ot.main.out.data.dto.OutUpdateRequestDto;
import com.ot.main.out.data.dto.OutUpdateResponseDto;

public interface OutService  {

	OutCreateResponseDto saveOut(OutCreateRequestDto outCreateRequestDto, String productCode);

	List<OutSelectAllResponseDto> selectAllOut();

	OutUpdateResponseDto updateOut(OutUpdateRequestDto outUpdateRequestDto);

	String deleteOut(Long id);

}
