package com.omnifood.omnifoodorder.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
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
