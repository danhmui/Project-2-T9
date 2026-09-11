package com.javaweb.api.admin;

import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.impl.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
public class TransactionAPI {
    @Autowired
    private TransactionService transactionService;
    @PostMapping("/transactions")
    public ResponseEntity<?> createOrUpdateTransaction(@Valid @RequestBody TransactionDTO transactionDTO,
                                                       BindingResult bindingResult) {
        try{
            if(bindingResult.hasErrors()){
                List<String> errors = bindingResult.getFieldErrors().stream()
                                        .map(FieldError::getDefaultMessage)
                                        .collect(Collectors.toList());
                return ResponseEntity.badRequest().body(errors);
            }
            Long staffId = SecurityUtils.getPrincipal().getId();
            transactionDTO.setStaffId(staffId);
            transactionService.createOrUpdateTransaction(transactionDTO);
            return ResponseEntity.ok().build();

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/transaction/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id){
        if(id != null)
            transactionService.deleteTransaction(id);
        return ResponseEntity.ok().build();
    }
}
