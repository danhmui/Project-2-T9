package com.dmuis.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dmuis.customexceptions.InvalidDataException;
import com.dmuis.dto.ErrorDetailDTO;

@ControllerAdvice
public class ControllerAdvisor {
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex) {
		ErrorDetailDTO errorDetailDTO = new ErrorDetailDTO();
		errorDetailDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("So nguyen khong the chia het cho 0!");
		errorDetailDTO.setDetail(details);
		return new ResponseEntity<>(errorDetailDTO, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<Object> handleInvalidDataException(InvalidDataException ex){
		ErrorDetailDTO errorDetailDTO = new ErrorDetailDTO();
		errorDetailDTO.setError(ex.getMessage());
		List<String> details = new ArrayList<String>();
		details.add("Ten nha hoac tang ham khong duoc thieu !!!");
		errorDetailDTO.setDetail(details);
		return new ResponseEntity<>(errorDetailDTO, HttpStatus.NOT_FOUND);
	}
}