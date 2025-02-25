package com.assignemnt.LMS.controller;
import com.assignemnt.LMS.model.EmployeeInfo;
import com.assignemnt.LMS.model.ManagerInfo;
import com.assignemnt.LMS.repository.EmployeeInfoRepository;
import com.assignemnt.LMS.repository.ManagerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    private EmployeeInfoRepository employeeInfoRepository;

    @Autowired
    private ManagerInfoRepository managerInfoRepository;

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest request) {
        if ("employee".equals(request.getRole())) {
            EmployeeInfo employee = employeeInfoRepository.findByEmailAndId(request.getEmail(), Integer.parseInt(request.getId()));
            return employee != null;
        } else if ("manager".equals(request.getRole())) {
            ManagerInfo manager = managerInfoRepository.findByEmailAndId(request.getEmail(), Integer.parseInt(request.getId()));
            return manager != null;
        }
        return false;
    }
}
class LoginRequest {
    private String email;
    private String id;
    private String role;

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}