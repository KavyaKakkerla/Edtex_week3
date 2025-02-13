package com.assignemnt.LMS.model;

import jakarta.persistence.*;


@Entity
@Table(name = "managerinfo")
public class ManagerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "name")
    private String ename;

    @Column(name = "email")
    private String email;


    @Column(name = "personalemail")
    private String personalemail;

    @Column(name = "mobile")
    private int mobile;

    @Column(name = "dateofjoining")
    private String dateofjoining;

    public String getDateofjoining() {
        return dateofjoining;
    }
    public String getEmail() {
        return email;
    }
    public int getId() {
        return id;
    }
    public int getMobile() {
        return mobile;
    }
    public String getName() {
        return ename;
    }
    public String getPersonalemail() {
        return personalemail;
    }
    public void setDateofjoining(String dateofjoining) {
        this.dateofjoining = dateofjoining;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
    public void setName(String name) {
        ename = name;
    }
    public void setPersonalemail(String personalemail) {
        this.personalemail = personalemail;
    }
}
