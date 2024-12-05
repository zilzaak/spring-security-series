package com.kashful.erp.common.entity;

public class CustomException extends Exception{
   private  String message;

   public CustomException(String message){
       this.message=message;
   }

}
