package com.assignemnt.LMS.repository;
import com.assignemnt.LMS.model.ManagerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ManagerInfoRepository extends JpaRepository<ManagerInfo, Integer> {


    
}
