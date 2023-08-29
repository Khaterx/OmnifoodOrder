package com.omnifood.omnifoodorder.services;

import com.omnifood.omnifoodorder.dto.PurchaseRequest;
import com.omnifood.omnifoodorder.dto.PurchaseResponse;


public interface PurchaseServices {
    public PurchaseResponse addRequestOrder(PurchaseRequest purchaseRequest);
}
