package com.example.EventManagementSystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "Register")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Firstname")
    private String firstname;
    @Column(name = "Lastname")
    private String lastname;
    @Column(name = "Email")
    private String email;
    @Column(name = "phoneno")
    private String phoneno;

    @Column(name="Address")
    private String address;

    public Register() {
    }

    

    public Register(long id, String firstname, String lastname, String email, String phoneno, String address) {
        this.id = id;
       this. firstname = firstname;
       this. lastname = lastname;
       this.email = email;
        this.phoneno = phoneno;
        this.address = address;
    }



    public String getAddress() {
        return address;
    }



    public void setAddress(String address) {
        this.address = address;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
       this. lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
       this. email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }



    



    



    
     
}
