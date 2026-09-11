package com.javaweb.api.web;

import com.javaweb.dto.RegisterDTO;
import com.javaweb.exception.MyException;
import com.javaweb.model.dto.UserDTO;
import com.javaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterAPI {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) throws MyException {
        try {
            UserDTO userDTO = userService.register(registerDTO);
            return ResponseEntity.ok(userDTO);
        }catch (MyException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
