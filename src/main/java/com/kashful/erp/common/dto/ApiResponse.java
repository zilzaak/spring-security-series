package com.kashful.erp.common.dto;

import lombok.Data;

@Data
public class ApiResponse {


    private String mesage;
    private Boolean status;
    private Object data;

    public ApiResponse(String mesage,Boolean status, Object data){
        this.data=data;
        this.mesage=mesage;
        this.status=status;
    }

    public ApiResponse(String mesage,Boolean status){
        this.mesage=mesage;
        this.status=status;
    }

    public ApiResponse(String mesage){

        this.mesage=mesage;

    }



}
