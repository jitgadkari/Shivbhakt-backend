package com.shivbhakt.shivbhakt.controller;

import com.shivbhakt.shivbhakt.payload.MyOrderDto;
import com.shivbhakt.shivbhakt.service.MyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MyOrderController {
    @Autowired
    private MyOrderService myOrderService;

    @PostMapping("/order/{amount}")
    public ResponseEntity<String> createOrder(@PathVariable Integer amount){
        MyOrderDto myOrderDto= this.myOrderService.createOrder(amount);
        String message=myOrderDto.toString();
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}
