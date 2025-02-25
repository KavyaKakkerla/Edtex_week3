package com.assignemnt.LMS.repository;

import com.assignemnt.LMS.model.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, Integer> {
    EmployeeInfo findByEmailAndId(String email, int id);

}