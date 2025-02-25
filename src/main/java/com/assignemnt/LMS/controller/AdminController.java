package com.assignemnt.LMS.controller;

import com.assignemnt.LMS.model.EmployeeInfo;
import com.assignemnt.LMS.model.LeaveSettings;
import com.assignemnt.LMS.model.ManagerInfo;
import com.assignemnt.LMS.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins= "http://localhost:4200")

public class AdminController {

    @Autowired
    private IAdminService adminService;
    
    @PostMapping("/addEmployee")
    public EmployeeInfo addEmployee(@RequestBody EmployeeInfo employeeInfo) {
        return adminService.addEmployee(employeeInfo);
    }

    @PostMapping("/addManager")
    public ManagerInfo addManager(@RequestBody ManagerInfo managerInfo) {
        return adminService.addManager(managerInfo);
    }

    @PostMapping("/updateSettings")
    public LeaveSettings updateSettings(@RequestBody LeaveSettings settings) {
        return adminService.updateSettings(settings);
    }
}