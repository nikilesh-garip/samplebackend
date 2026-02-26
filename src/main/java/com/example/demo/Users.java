package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String department;

    @Column
    private String section;

    
    // GETTERS
    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getSection(){
        return this.section;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getDepartment() {
        return this.department;
    }


    // SETTERS (should be public)
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String n) {
        this.username = n;
    }


    public void setEmail(String e) {
        this.email = e;
    }

    public void setPassword(String p) {
        this.password = p;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSection(String s) {
        this.section = s;
    }

}
