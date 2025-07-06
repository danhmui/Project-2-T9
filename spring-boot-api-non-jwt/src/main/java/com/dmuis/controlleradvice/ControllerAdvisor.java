package com.dmuis.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dmuis.customexceptions.InvalidDataException;
import com.dmuis.dto.ErrorDetailDTO;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<ErrorDetailDTO> handleArithmeticException(ArithmeticException ex){
			ErrorDetailDTO errorDetailDTO = new ErrorDetailDTO();
			errorDetailDTO.setError(ex.getMessage());
			List<String>details = new ArrayList<String>();
			details.add("So nguyen khong chia het cho 0");
			errorDetailDTO.setDetail(details);	
			return new ResponseEntity<>(errorDetailDTO,HttpStatus.BAD_GATEWAY);
	}
	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<ErrorDetailDTO> handleInvalidDataException(InvalidDataException ex){
			ErrorDetailDTO errorDetailDTO = new ErrorDetailDTO();
			errorDetailDTO.setError(ex.getMessage());
			List<String>details = new ArrayList<String>();
			details.add("Thieu basment hoac ten toa nha");
			errorDetailDTO.setDetail(details);	
			return new ResponseEntity<>(errorDetailDTO,HttpStatus.BAD_GATEWAY);
	}
}
