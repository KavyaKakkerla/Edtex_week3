package com.assignemnt.LMS.service.impl;

import com.assignemnt.LMS.dto.LeaveResponse;

import com.assignemnt.LMS.model.LeaveApplication;

import com.assignemnt.LMS.repository.LeaveApplicationRepository;
import com.assignemnt.LMS.service.IEmployeeInfoService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeInfoService implements IEmployeeInfoService {

    @Autowired
    private LeaveApplicationRepository leaveApplicationRepository;



    public LeaveResponse applyLeave(Long employeeId,LeaveApplication leaveApplication) {
        leaveApplication.setStatus("Pending");
        leaveApplication.setApplicationDate(new Date());
        leaveApplication.setEmployeeId(employeeId);
        LeaveApplication savedApplication = leaveApplicationRepository.save(leaveApplication);

        LeaveResponse response = new LeaveResponse();
        response.setLeaveType(savedApplication.getLeaveType());
        response.setStartDate(savedApplication.getStartDate());
        response.setEndDate(savedApplication.getEndDate());
        response.setLeaveId(savedApplication.getId());
        response.setStatus(savedApplication.getStatus());
        response.setReason(savedApplication.getReason());
        response.setManagerComments("Leave application submitted successfully and is pending approval.");
        return response;
    }


    public List<LeaveApplication> getLeaveApplicationsByEmployee(Long employeeId) {
        return leaveApplicationRepository.findByEmployeeId(employeeId);
    }


    public List<LeaveApplication> getLeaveHistory(Long employeeId) {
        return leaveApplicationRepository.findByEmployeeIdAndStatus(employeeId, "Approved");
    }


}