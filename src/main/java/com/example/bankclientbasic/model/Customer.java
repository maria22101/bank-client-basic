package com.example.bankclientbasic.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString

@Entity
@Table(name = "customers")
public class Customer extends AbstractEntity {

    @EqualsAndHashCode.Include
    private String name;

    @EqualsAndHashCode.Include
    private String email;

    private Integer age;

    private String password;

    private String phoneNumber;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "customers_employers",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "employer_id")
    )
    private Set<Employer> employers;

    public Customer(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;

        accounts = new ArrayList<>();
        employers = new HashSet<>();
    }
}


