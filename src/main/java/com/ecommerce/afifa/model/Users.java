package com.ecommerce.afifa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@Component
@Table
@Entity
@NoArgsConstructor
@EntityScan(basePackages = "com.ecommerce.afifa.model")


public class Users {
    @Id
    @GeneratedValue
    private Integer user_id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String loginName;

    @Column
    private String password;
}
