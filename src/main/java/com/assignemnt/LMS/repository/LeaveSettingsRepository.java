package com.assignemnt.LMS.repository;

import com.assignemnt.LMS.model.LeaveSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LeaveSettingsRepository extends JpaRepository<LeaveSettings, Integer> {
}