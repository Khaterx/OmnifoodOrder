package com.omnifood.omnifoodorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "country")
public class Country extends SharedRowData {

    private String code; // EGY

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    Set<State> states;
}
