package com.assignemnt.LMS.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "leave_applications")
public class LeaveApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    //@Column(name = "leave_type", nullable = false)
    private String leaveType;

   // @Column(name = "start_date", nullable = false)
    //@Temporal(TemporalType.DATE)
    private Date startDate;

    //@Column(name = "end_date", nullable = false)
    //@Temporal(TemporalType.DATE)
    private Date endDate;

   // @Column(name = "reason", nullable = false)
    private String reason;

    //@Column(name = "status", nullable = false)
    private String status; // Pending, Approved, Rejected

    //@Column(name = "manager_comments")
    private String managerComments;

    //@Column(name = "application_date", nullable = false)
    //@Temporal(TemporalType.DATE)
    private Date applicationDate;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManagerComments() {
        return managerComments;
    }

    public void setManagerComments(String managerComments) {
        this.managerComments = managerComments;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String toString() {
        return this.leaveType;
    }
}

