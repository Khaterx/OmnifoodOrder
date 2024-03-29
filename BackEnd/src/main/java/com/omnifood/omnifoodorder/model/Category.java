package com.omnifood.omnifoodorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category extends SharedRowData { /* SharedRowData => id, name, dateCreate, dateUpdate */

    private String icons;
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<Order> orders;
}
