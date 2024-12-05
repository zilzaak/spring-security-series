package com.kashful.erp.manageRole.create.controller;

import com.kashful.erp.common.dto.ApiResponse;
import com.kashful.erp.common.entity.CustomException;
import com.kashful.erp.manageRole.create.service.CreateRoleService;
import com.kashful.erp.security.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/role")
@Controller
public class CreateRoleController {

@Autowired
private CreateRoleService manageRoleService;

    @PostMapping("/create")
    private ResponseEntity<?> create(@RequestBody Role role) throws CustomException {
        manageRoleService.create(role);
        return new ResponseEntity<>(new ApiResponse("Successfully created role",true), HttpStatus.OK);
    }

    @PutMapping("/edit")
    private ResponseEntity<?> edit(@RequestBody Role role) throws CustomException {
        manageRoleService.edit(role);
        return new ResponseEntity<>(new ApiResponse("Successfully edited role",true), HttpStatus.OK);
    }

    @GetMapping("/get")
    private ResponseEntity<?> get(@RequestParam Map<String,String> param) throws CustomException {
        Role role = manageRoleService.getById(param);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @GetMapping("/delete")
    private ResponseEntity<?> delete(@RequestParam Map<String,String> param) throws CustomException {
        manageRoleService.delete(param);
        return new ResponseEntity<>(new ApiResponse("Successfully deleted role",true), HttpStatus.OK);
    }





}
