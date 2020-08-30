package com.example.bankclientbasic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Include
    private String number;

    @EqualsAndHashCode.Include
    @Enumerated(EnumType.STRING)
    private Currency currency;

    private Double balance;

    @ManyToOne(optional = false, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Account(Currency currency, Customer customer, Double balance) {
        this.currency = currency;
        this.customer = customer;
        this.balance = balance;
        number = UUID.randomUUID().toString();
    }
}


