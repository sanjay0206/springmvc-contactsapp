package com.spring.contacts.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String country;

    public Contact(String name, String email, String country) {
        this.name = name;
        this.email = email;
        this.country = country;
    }
}
