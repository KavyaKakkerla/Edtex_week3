package com.assignemnt.LMS.service;

import com.assignemnt.LMS.dto.LeaveResponse;
import com.assignemnt.LMS.model.LeaveApplication;

import java.util.List;

public interface IManagerInfoService {
    List<LeaveApplication> getAllLeaveApplications();
    LeaveResponse approveLeaveApplication(Long leaveId, String managerComments);
    LeaveResponse rejectLeaveApplication(Long leaveId, String managerComments);

}