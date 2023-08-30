package com.omnifood.omnifoodorder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request_order")

public class RequestOrder extends CategoryOrder {
    /* CategoryOrder => id, dateCreate, dateUpdate */
    private String code;
//    private String feedback;
    private int totalQuantity;
    private int totalPrice;

    @OneToMany(mappedBy = "requestOrder", cascade = CascadeType.ALL)
    private List<ProductItems> productItems = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "clients_id")
    private Clients clients = new Clients();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_address_id", referencedColumnName = "id")
    private OrderAddress toOrderAddress = new OrderAddress();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "from_address_id", referencedColumnName = "id")
    private OrderAddress fromOrderAddress = new OrderAddress();

    public void addProductItems(ProductItems productItem){
        productItems.add(productItem);
        productItem.setRequestOrder(this);
    }
}
