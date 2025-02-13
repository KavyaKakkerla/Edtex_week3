package com.assignemnt.LMS.model;
import jakarta.persistence.*;

@Entity
@Table(name = "employeeinfo")
public class EmployeeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "personalemail")
    private String personalEmail;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "dateofjoining")
    private String dateOfJoining;

    @Column(name = "manager_id")
    private int managerId;

    
    public String getDateOfJoining() {
        return dateOfJoining;
    }
    public String getEmail() {
        return email;
    }
    public int getId() {
        return id;
    }
    public int getManagerId() {
        return managerId;
    }
    public String getMobile() {
        return mobile;
    }
    public String getName() {
        return name;
    }
    public String getPersonalEmail() {
        return personalEmail;
    }
    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }
}

