package com.example.jwt.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employnumber", unique = true)
    private String employNumber;

    @Column(name = "employname", unique = true)
    private String employName;

    @Column(name = "phonenumber", unique = true)
    private String phoneNumber;

    private String password;

    @Column(name = "adminkey")
    private String adminKey;

}
