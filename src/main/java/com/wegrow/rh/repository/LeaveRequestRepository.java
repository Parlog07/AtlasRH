package com.wegrow.rh.repository;
import com.wegrow.rh.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.*;
import java.time.*;
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Long> {  }
