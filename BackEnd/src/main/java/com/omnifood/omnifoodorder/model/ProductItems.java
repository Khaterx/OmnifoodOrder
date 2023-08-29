package com.omnifood.omnifoodorder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_items")
public class ProductItems extends BaseEntity { /* BaseEntity => id */
    private String image;
    private int quantity;
    private int price;

    @ManyToOne
    @JoinColumn(name = "request_order_id")
    private RequestOrder requestOrder;
}
