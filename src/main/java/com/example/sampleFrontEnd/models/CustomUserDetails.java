package com.example.sampleFrontEnd.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class CustomUserDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String middleName;
    private String  lastName;
    private String  email;
    private String  passWord;
    private String  userName;
    private String  gender;
    private String userType;
    private Date birthDate;
    private Long mobileNo;
    private Long addressId;
    private Date dateCreated;
    private Date dateUpdated;
}
