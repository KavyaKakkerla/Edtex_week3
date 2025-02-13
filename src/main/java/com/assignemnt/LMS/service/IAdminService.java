package com.assignemnt.LMS.service;

import com.assignemnt.LMS.model.EmployeeInfo;
import com.assignemnt.LMS.model.ManagerInfo;
import com.assignemnt.LMS.model.LeaveSettings;

public interface IAdminService {
    EmployeeInfo addEmployee(EmployeeInfo employeeInfo);
    ManagerInfo addManager(ManagerInfo managerInfo);
    LeaveSettings updateSettings(LeaveSettings settings);
}