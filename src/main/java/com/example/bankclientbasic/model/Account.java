package com.example.bankclientbasic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "accounts")
@NamedQueries({
        @NamedQuery(name = "Account.getAll", query = "SELECT a from Account a")
})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @EqualsAndHashCode.Exclude
    private Double balance;

    @JsonBackReference
    @ManyToOne(optional = false, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Account(Currency currency, Customer customer) {
        this.currency = currency;
        this.customer = customer;
        balance = (double) 0;
        number = UUID.randomUUID().toString();
    }
}


