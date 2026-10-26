package com.wegrow.rh.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.wegrow.rh.enums.*;
@Entity @Table(name="leave_requests")
public class LeaveRequest {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) @JoinColumn(name="employee_id") private Employee employee;
 @ManyToOne(optional=false) @JoinColumn(name="leave_type_id") private LeaveType leaveType;
 @Column(nullable=false) private LocalDate startDate;
 @Column(nullable=false) private LocalDate endDate;
 private String reason;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private RequestStatus status;
 private String comment;
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public Employee getEmployee(){return employee;} public void setEmployee(Employee v){employee=v;}
 public LeaveType getLeaveType(){return leaveType;} public void setLeaveType(LeaveType v){leaveType=v;}
 public LocalDate getStartDate(){return startDate;} public void setStartDate(LocalDate v){startDate=v;}
 public LocalDate getEndDate(){return endDate;} public void setEndDate(LocalDate v){endDate=v;}
 public String getReason(){return reason;} public void setReason(String v){reason=v;}
 public RequestStatus getStatus(){return status;} public void setStatus(RequestStatus v){status=v;}
 public String getComment(){return comment;} public void setComment(String v){comment=v;}
}
