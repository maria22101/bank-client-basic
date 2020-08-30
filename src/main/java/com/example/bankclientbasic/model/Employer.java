package com.example.bankclientbasic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString

@Entity
@Table(name = "employers")
public class Employer extends AbstractEntity {

    @EqualsAndHashCode.Include
    private String name;

    @EqualsAndHashCode.Include
    private String address;

    @ManyToMany(mappedBy = "employers", fetch = FetchType.LAZY)
    private Set<Customer> customers;

    @PreRemove
    private void removeEmployerFromCustomers() {
        customers.forEach(c -> c.getEmployers().remove(this));
    }
}


