package com.assignemnt.LMS.dto;

import java.util.Date;

public class LeaveResponse {
    private Long leaveId;
    private String leaveType;
    private Date startDate;
    private Date endDate;
    private String reason;
    private String status;
    private String managerComments;
    private int leaveBalance;

    // Getters and Setters
    public Long getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Long leaveId) {
        this.leaveId = leaveId;
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
    public int getLeaveBalance() {
        return leaveBalance;
    }
    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

   

    
}
