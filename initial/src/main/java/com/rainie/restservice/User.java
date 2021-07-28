package com.rainie.restservice;

import lombok.*;
import javax.persistence.*;


@Getter
@Setter
@Entity // This tells Hibernate to make a table out of this class
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
public class User {
    @Id
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;

    private int age;                 //https://agify.io/
    private String gender;           //https://genderize.io/
    private String nationality;      //https://nationalize.io/

    private String tags;
    private String status;


    @EqualsAndHashCode.Exclude private String created;
    @EqualsAndHashCode.Exclude private String updated;
    }
