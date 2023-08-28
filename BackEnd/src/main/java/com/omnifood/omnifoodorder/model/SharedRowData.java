package com.omnifood.omnifoodorder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass  /* you must put this annotation, For Know Hibernate inheritance class */
public class SharedRowData extends CategoryOrder {
    /* CategoryOrder => id, dateCreate, dateUpdate */
    private String name;
}
