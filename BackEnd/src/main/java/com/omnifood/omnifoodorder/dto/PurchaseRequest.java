package com.omnifood.omnifoodorder.dto;

import com.omnifood.omnifoodorder.model.Clients;
import com.omnifood.omnifoodorder.model.OrderAddress;
import com.omnifood.omnifoodorder.model.ProductItems;
import com.omnifood.omnifoodorder.model.RequestOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequest {
    /* for Receive request data form shopping-cart (DB) in All one request */

    private Clients clients;
    private RequestOrder requestOrder;
    private List<ProductItems> productItems;
    private OrderAddress fromOrderAddress;
    private OrderAddress toOrderAddress;
}
