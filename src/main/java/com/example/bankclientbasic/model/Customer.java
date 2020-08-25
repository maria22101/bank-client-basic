package com.example.bankclientbasic.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString

@Entity
@Table(name = "customers")
@NamedQueries({
        @NamedQuery(name = "Customer.getAll", query = "SELECT c from Customer c")
})
public class Customer extends AbstractEntity {

    @EqualsAndHashCode.Include
    private String name;

    private String email;

    private Integer age;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts;

    @ManyToMany(mappedBy = "customers")
    private Set<Employer> employers;

    public Customer(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;

        accounts = new ArrayList<>();
    }
}


