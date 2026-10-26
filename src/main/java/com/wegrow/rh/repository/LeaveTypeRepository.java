package com.wegrow.rh.repository;
import com.wegrow.rh.entity.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.*;
import java.time.*;
public interface LeaveTypeRepository extends JpaRepository<LeaveType,Long> {  }
