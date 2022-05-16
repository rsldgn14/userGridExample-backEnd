package com.userData.entity;
import lombok.Data;
import javax.persistence.*;
@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
