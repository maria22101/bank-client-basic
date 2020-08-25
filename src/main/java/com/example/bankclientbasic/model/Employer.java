package com.example.bankclientbasic.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString

@Entity
@Table(name = "employers")
public class Employer extends AbstractEntity {

    @EqualsAndHashCode.Include
    private String name;

    private String address;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "employers_customers",
            joinColumns = @JoinColumn(name = "employer_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private Set<Customer> customers;

    public Employer(String name, String address) {
        this.name = name;
        this.address = address;
    }
}


