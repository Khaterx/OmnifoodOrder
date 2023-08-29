package com.omnifood.omnifoodorder.controller;

import com.omnifood.omnifoodorder.dto.PurchaseRequest;
import com.omnifood.omnifoodorder.dto.PurchaseResponse;
import com.omnifood.omnifoodorder.services.PurchaseServices;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
@RequestMapping("/v1/api")
public class PurchasesController {

    @Autowired
    private PurchaseServices purchaseServices;


    @PostMapping("/checkout")
    public PurchaseResponse addRequestOrder(@RequestBody PurchaseRequest purchaseRequest){
//        System.out.println(purchaseRequest.g);
        return  purchaseServices.addRequestOrder(purchaseRequest);
    }

}
