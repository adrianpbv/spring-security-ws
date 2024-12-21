package com.adrianj.springsec11.db.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @JsonIgnore // to make sure this data is not returned on error messages on the response
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<AuthorityEntity> authorityEntities;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "mobile_number", nullable = false, length = 20)
    private String mobileNumber;

    @Column(name = "pwd", nullable = false, length = 500)
    private String pwd;

    @Column(name = "role", nullable = false, length = 100)
    private String role;

    @Column(name = "create_dt")
    private LocalDate createDt;

}