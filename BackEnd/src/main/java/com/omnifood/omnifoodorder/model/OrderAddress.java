package com.omnifood.omnifoodorder.model;

public class OrderAddress extends CategoryOrder {
    /* CategoryOrder => id, dateCreate, dateUpdate */
    private String country;
    private String state;
    private int zipCode;
}
