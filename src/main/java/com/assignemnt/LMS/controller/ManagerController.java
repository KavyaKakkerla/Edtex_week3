package com.assignemnt.LMS.controller;

import com.assignemnt.LMS.dto.LeaveResponse;
import com.assignemnt.LMS.model.LeaveApplication;
import com.assignemnt.LMS.service.impl.ManagerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerInfoService managerInfoService;


    @GetMapping("/leave-applications")
    public List<LeaveApplication> getAllLeaveApplications() {
        return managerInfoService.getAllLeaveApplications();
    }


    @PostMapping("/approve-leave/{id}")
    public LeaveResponse approveLeave(@PathVariable Long id, @RequestParam(required = false) String comment) {
        return managerInfoService.approveLeaveApplication(id, comment);
    }


    @PostMapping("/reject-leave/{id}")
    public LeaveResponse rejectLeave(@PathVariable Long id, @RequestParam(required = false) String comment) {
        return managerInfoService.rejectLeaveApplication(id, comment);
    }

    


}
