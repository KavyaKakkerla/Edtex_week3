package com.assignemnt.LMS.service;

import com.assignemnt.LMS.model.LeaveApplication;
import com.assignemnt.LMS.dto.LeaveResponse;

import java.util.List;

public interface IEmployeeInfoService {

    // Method to apply for leave
    LeaveResponse applyLeave(Long employeeId, LeaveApplication leaveApplication);

    // Method to track leave applications by employee ID
    List<LeaveApplication> getLeaveApplicationsByEmployee(Long employeeId);

    // Method to retrieve leave history for an employee
    List<LeaveApplication> getLeaveHistory(Long employeeId);


}