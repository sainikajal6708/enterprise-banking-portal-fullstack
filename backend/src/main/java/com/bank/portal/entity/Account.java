package com.bank.portal.entity;
import jakarta.persistence.*;
import lombok.Data;
@Entity @Data
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private Double balance = 10000.0;
    private String ownerUsername;
}
