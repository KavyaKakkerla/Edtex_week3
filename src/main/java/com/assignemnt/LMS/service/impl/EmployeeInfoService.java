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

    public LeaveResponse deleteLeave(Long employeeId, LeaveApplication leaveApplication) {
        // Fetch the leave application by employeeId and id
        LeaveApplication existingApplication = leaveApplicationRepository.findByEmployeeIdAndId(employeeId, leaveApplication.getId());

        if (existingApplication == null) {
            throw new IllegalArgumentException("Leave application not found for the given employee ID and leave ID.");
        }

        // Delete the leave application
        leaveApplicationRepository.deleteById(existingApplication.getId());

        // Prepare the response
        LeaveResponse response = new LeaveResponse();
        response.setLeaveId(existingApplication.getId());
        response.setLeaveType(existingApplication.getLeaveType());
        response.setStartDate(existingApplication.getStartDate());
        response.setEndDate(existingApplication.getEndDate());
        response.setStatus("Deleted");
        response.setReason(existingApplication.getReason());
        response.setManagerComments("Leave application has been successfully deleted.");
        return response;
    }

    public List<LeaveApplication> getLeaveApplicationsByEmployee(Long employeeId) {
        return leaveApplicationRepository.findByEmployeeId(employeeId);
    }


    public List<LeaveApplication> getLeaveHistory(Long employeeId) {
        return leaveApplicationRepository.findByEmployeeIdAndStatus(employeeId, "Approved");
    }
    public LeaveResponse updateLeave(Long employeeId, LeaveApplication leaveApplication) {
        // Fetch the existing leave application by employeeId and leaveId
        LeaveApplication existingApplication = leaveApplicationRepository.findByEmployeeIdAndId(employeeId, leaveApplication.getId());

        if (existingApplication == null) {
            throw new IllegalArgumentException("Leave application not found for the given employee ID and leave ID.");
        }

        // Update the fields of the existing leave application
        existingApplication.setLeaveType(leaveApplication.getLeaveType());
        existingApplication.setStartDate(leaveApplication.getStartDate());
        existingApplication.setEndDate(leaveApplication.getEndDate());
        existingApplication.setReason(leaveApplication.getReason());
        existingApplication.setStatus("Pending"); // Reset status to pending for updated leave

        // Save the updated leave application to the database
        LeaveApplication updatedApplication = leaveApplicationRepository.save(existingApplication);

        // Prepare the response
        LeaveResponse response = new LeaveResponse();
        response.setLeaveId(updatedApplication.getId());
        response.setLeaveType(updatedApplication.getLeaveType());
        response.setStartDate(updatedApplication.getStartDate());
        response.setEndDate(updatedApplication.getEndDate());
        response.setStatus(updatedApplication.getStatus());
        response.setReason(updatedApplication.getReason());
        response.setManagerComments("Leave application has been successfully updated and is pending approval.");

        return response;
    }



}