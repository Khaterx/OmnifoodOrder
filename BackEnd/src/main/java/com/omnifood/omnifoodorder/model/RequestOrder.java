package com.omnifood.omnifoodorder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request_order")
public class RequestOrder extends CategoryOrder {
    /* CategoryOrder => id, dateCreate, dateUpdate */
    private String code;
    @Lob()
    private String feedback;
    private int totalQuantity;
    private int totalPrice;

    @OneToMany(mappedBy = "requestOrder",cascade = CascadeType.ALL)
    private Set<ProductItems> productItems;

    @ManyToOne()
    @JoinColumn(name = "clients_id")
    private Clients clients;

    @OneToOne
    @JoinColumn(name = "to_address_id",referencedColumnName = "id")
    private OrderAddress toOrderAddress;

    @OneToOne
    @JoinColumn(name = "from_address_id",referencedColumnName = "id")
    private OrderAddress fromOrderAddress;
}
