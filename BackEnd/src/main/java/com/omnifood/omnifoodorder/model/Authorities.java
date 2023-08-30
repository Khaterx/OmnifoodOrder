package com.omnifood.omnifoodorder.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authorities")
public class Authorities extends BaseEntity {
    private String roleName;

    @ManyToMany(mappedBy = "authorities")
    private Set<UserInfo> usersInfo= new HashSet<>();
}
