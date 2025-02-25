package com.assignemnt.LMS.controller;

import com.assignemnt.LMS.dto.LeaveResponse;
import com.assignemnt.LMS.model.LeaveApplication;
import com.assignemnt.LMS.service.impl.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RestController
@RequestMapping("/employee")
@CrossOrigin(origins= "http://localhost:4200")

public class EmployeeController {

    @Autowired
    private EmployeeInfoService employeeInfoService;

    @GetMapping("/")
    public String print() {
        return "Hello";
    }


    @PostMapping("/apply-leave/{employeeId}")
    public LeaveResponse applyLeave(@PathVariable Long employeeId,@RequestBody LeaveApplication leaveApplication) {
        System.out.println(employeeId);
        System.out.println(leaveApplication.toString());
        return employeeInfoService.applyLeave(employeeId,leaveApplication);
    }
    @PostMapping("/delete-leave/{employeeId}")
    public LeaveResponse deleteLeave(@PathVariable Long employeeId,@RequestBody LeaveApplication leaveApplication) {
        System.out.println(employeeId);
        System.out.println(leaveApplication.toString());
        return employeeInfoService.deleteLeave(employeeId,leaveApplication);
    }


    @GetMapping("/track-leaves/{employeeId}")
    public List<LeaveApplication> trackLeaveApplications(@PathVariable Long employeeId) {
        return employeeInfoService.getLeaveApplicationsByEmployee(employeeId);
    }


    @GetMapping("/leave-history/{employeeId}")
    public List<LeaveApplication> getLeaveHistory(@PathVariable Long employeeId) {
        return employeeInfoService.getLeaveHistory(employeeId);
    }
    @PutMapping("/update-leave/{employeeId}")
    public LeaveResponse updateLeave(@PathVariable Long employeeId, @RequestBody LeaveApplication leaveApplication) {
        // Log the employee ID and leave application for debugging
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Leave Application: " + leaveApplication);

        // Call the service method to process the update
        return employeeInfoService.updateLeave(employeeId, leaveApplication);
    }



}
