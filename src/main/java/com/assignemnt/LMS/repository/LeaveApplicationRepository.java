package com.assignemnt.LMS.repository;

import com.assignemnt.LMS.model.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Long> {


    @Query(value = "select * from leave_applications where employee_id=?1", nativeQuery = true)
    List<LeaveApplication> findByEmployeeId(Long employeeID);



    List<LeaveApplication> findByStatus(String status);

    @Query(value = "select * from leave_applications where employee_id=:employeeId and id=:id", nativeQuery = true)
    LeaveApplication findByEmployeeIdAndId(@Param("employeeId") Long employeeId, @Param("id") Long id);


    // Fetch leave applications for an employee filtered by status
    List<LeaveApplication> findByEmployeeIdAndStatus(Long employeeId, String status);


    int countByEmployeeIdAndStatus(Long employeeId, String status);
}
