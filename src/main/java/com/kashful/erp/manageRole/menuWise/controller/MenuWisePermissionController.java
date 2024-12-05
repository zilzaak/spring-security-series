package com.kashful.erp.manageRole.menuWise.controller;


import com.kashful.erp.common.dto.ApiResponse;
import com.kashful.erp.common.entity.CustomException;
import com.kashful.erp.manageRole.create.service.CreateRoleService;
import com.kashful.erp.manageRole.menuWise.service.MenuWisePermissionService;
import com.kashful.erp.security.entity.AuthorityPermission;
import com.kashful.erp.security.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/apiPerm")
@Controller
public class MenuWisePermissionController {

    @Autowired
    private MenuWisePermissionService menuWisePermissionService;

    @PostMapping("/create")
    private ResponseEntity<?> create(@RequestBody AuthorityPermission authorityPermission) throws CustomException {
        menuWisePermissionService.create(authorityPermission);
        return new ResponseEntity<>(new ApiResponse("Successfully created permission",true), HttpStatus.OK);
    }

    @PutMapping("/edit")
    private ResponseEntity<?> edit(@RequestBody AuthorityPermission authorityPermission) throws CustomException {
        menuWisePermissionService.edit(authorityPermission);
        return new ResponseEntity<>(new ApiResponse("Successfully edited permission",true), HttpStatus.OK);
    }

    @GetMapping("/get")
    private ResponseEntity<?> get(@RequestParam Map<String,String> param) throws CustomException {
        AuthorityPermission obj = menuWisePermissionService.getById(param);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/delete")
    private ResponseEntity<?> delete(@RequestParam Map<String,String> param) throws CustomException {
        menuWisePermissionService.delete(param);
        return new ResponseEntity<>(new ApiResponse("Successfully deleted permission",true), HttpStatus.OK);
    }




}
