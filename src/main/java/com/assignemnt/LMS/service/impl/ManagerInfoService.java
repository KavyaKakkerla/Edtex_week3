package com.assignemnt.LMS.service.impl;

import com.assignemnt.LMS.dto.LeaveResponse;
import com.assignemnt.LMS.model.LeaveApplication;
import com.assignemnt.LMS.repository.LeaveApplicationRepository;
import com.assignemnt.LMS.service.IManagerInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerInfoService implements IManagerInfoService {

    @Autowired
    private LeaveApplicationRepository leaveApplicationRepository;

    @Override
    public List<LeaveApplication> getAllLeaveApplications() {
        return leaveApplicationRepository.findAll();
    }

    @Override
    public LeaveResponse approveLeaveApplication(Long leaveId, String managerComments) {
        Optional<LeaveApplication> optionalLeave = leaveApplicationRepository.findById(leaveId);
        if (optionalLeave.isPresent()) {
            LeaveApplication leaveApplication = optionalLeave.get();
            leaveApplication.setStatus("Approved");
            leaveApplication.setManagerComments(managerComments);
            leaveApplicationRepository.save(leaveApplication);

            LeaveResponse response = new LeaveResponse();
            response.setReason(leaveApplication.getReason());
            response.setLeaveType(leaveApplication.getLeaveType());
            response.setLeaveId(leaveApplication.getId());
            response.setStatus("Approved");
            response.setManagerComments("Leave application approved successfully.");
            response.setEndDate(leaveApplication.getEndDate());
            response.setStartDate(leaveApplication.getStartDate());
            return response;
        }
        throw new RuntimeException("Leave application not found with ID: " + leaveId);
    }

    @Override
    public LeaveResponse rejectLeaveApplication(Long leaveId, String managerComments) {
        Optional<LeaveApplication> optionalLeave = leaveApplicationRepository.findById(leaveId);
        if (optionalLeave.isPresent()) {
            LeaveApplication leaveApplication = optionalLeave.get();
            leaveApplication.setStatus("Rejected");
            leaveApplication.setManagerComments(managerComments);
            leaveApplicationRepository.save(leaveApplication);

            LeaveResponse response = new LeaveResponse();
            response.setReason(leaveApplication.getReason());
            response.setStartDate(leaveApplication.getStartDate());
            response.setEndDate(leaveApplication.getEndDate());
            response.setLeaveType(leaveApplication.getLeaveType());
            response.setLeaveId(leaveApplication.getId());
            response.setStatus("Rejected");
            response.setManagerComments("Leave application rejected successfully.");
            return response;
        }
        throw new RuntimeException("Leave application not found with ID: " + leaveId);
    }




}