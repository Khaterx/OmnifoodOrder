package com.omnifood.omnifoodorder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Clients extends SharedRowData {
    /* SharedRowData => id, name, dateCreate, dateUpdate */
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "clients",cascade = CascadeType.ALL)
    private List<RequestOrder> requestOrders = new ArrayList<>(); // null point exception

    public void addRequestOrder(RequestOrder requestOrder){
        requestOrders.add(requestOrder);
        requestOrder.setClients(this);
    }
}
