package com.omnifood.omnifoodorder.model;


public class RequestOrder extends CategoryOrder {
    /* CategoryOrder => id, dateCreate, dateUpdate */
    private String code;
    private String feedback;
    private int totalQuantity;
    private int totalPrice;

}
