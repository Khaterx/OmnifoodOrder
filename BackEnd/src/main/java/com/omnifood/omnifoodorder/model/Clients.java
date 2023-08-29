package com.omnifood.omnifoodorder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Clients extends SharedRowData {
    /* SharedRowData => id, name, dateCreate, dateUpdate */
    private String email;
    private int phoneNumber;

    @OneToMany(mappedBy = "clients",cascade = CascadeType.ALL)
    private Set<RequestOrder> requestOrders;
}
