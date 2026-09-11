package com.javaweb.api.web;

import com.javaweb.dto.ContactDTO;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.exception.MyException;
import com.javaweb.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactAPI {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    public ResponseEntity<?> contact(@RequestBody ContactDTO contactDTO){
        try{
            CustomerEntity customerEntity = customerService.contact(contactDTO);
            return ResponseEntity.ok(customerEntity);
        }catch (MyException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
