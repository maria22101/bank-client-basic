package com.example.bankclientbasic.model;

import lombok.*;

import javax.persistence.*;

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

    public Employer(String name, String address) {
        this.name = name;
        this.address = address;
    }
}


