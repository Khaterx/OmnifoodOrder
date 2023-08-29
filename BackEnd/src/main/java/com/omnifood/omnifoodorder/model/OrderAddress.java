package com.omnifood.omnifoodorder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order_address")
public class OrderAddress extends CategoryOrder {
    /* CategoryOrder => id, dateCreate, dateUpdate */
    private String country;
    private String state;
    private int zipCode;

    @OneToOne//(mappedBy = "orderAddress")
    @PrimaryKeyJoinColumn
    private RequestOrder requestOrder;
}
