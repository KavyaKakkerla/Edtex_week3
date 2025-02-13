package com.assignemnt.LMS.service.impl;

import com.assignemnt.LMS.model.EmployeeInfo;
import com.assignemnt.LMS.model.ManagerInfo;
import com.assignemnt.LMS.model.LeaveSettings;
import com.assignemnt.LMS.repository.EmployeeInfoRepository;
import com.assignemnt.LMS.repository.ManagerInfoRepository;
import com.assignemnt.LMS.repository.LeaveSettingsRepository;
import com.assignemnt.LMS.service.IAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private EmployeeInfoRepository employeeInfoRepository;

    @Autowired
    private ManagerInfoRepository managerInfoRepository;

    @Autowired
    private LeaveSettingsRepository LeaveSettingsRepository;

    @Override
    public EmployeeInfo addEmployee(EmployeeInfo employeeInfo) {
        return employeeInfoRepository.save(employeeInfo);
    }

    @Override
    public ManagerInfo addManager(ManagerInfo managerInfo) {
        return managerInfoRepository.save(managerInfo);
    }

    @Override
    public LeaveSettings updateSettings(LeaveSettings settings) {
        return LeaveSettingsRepository.save(settings);
    }
}