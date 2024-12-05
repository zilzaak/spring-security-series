package com.kashful.erp.user_reg.controller;


import com.kashful.erp.common.dto.ApiResponse;
import com.kashful.erp.common.entity.CustomException;
import com.kashful.erp.security.entity.RoleRepository;
import com.kashful.erp.security.entity.User;
import com.kashful.erp.security.entity.UserRepository;
import com.kashful.erp.user_reg.dto.UserDTO;
import com.kashful.erp.user_reg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/userReg")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    private ResponseEntity<?> create(@RequestBody UserDTO userDTO) throws CustomException {
        userService.create(userDTO);
        return new ResponseEntity<>(new ApiResponse("Successfully created user",true), HttpStatus.OK);
    }

    @PutMapping("/edit")
    private ResponseEntity<?> edit(@RequestBody UserDTO userDTO) throws CustomException {
        userService.edit(userDTO);
        return new ResponseEntity<>(new ApiResponse("Successfully edited user",true), HttpStatus.OK);
    }

    @GetMapping("/get")
    private ResponseEntity<?> get(@RequestParam Map<String,String> param) throws CustomException {
        User user = userService.getByUser(param);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/delete")
    private ResponseEntity<?> delete(@RequestParam Map<String,String> param) throws CustomException {
        userService.delete(param);
        return new ResponseEntity<>(new ApiResponse("Successfully deleted user",true), HttpStatus.OK);
    }



}
