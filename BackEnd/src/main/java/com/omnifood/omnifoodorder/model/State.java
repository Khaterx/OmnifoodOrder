package com.omnifood.omnifoodorder.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State extends SharedRowData{

    /* id => baseEntity & Name => sharedRow */

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
