package com.wegrow.rh.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.wegrow.rh.enums.*;
@Entity @Table(name="contracts")
public class Contract {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private ContractType type;
 @Column(nullable=false) private LocalDate startDate;
 private LocalDate endDate;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal grossSalary;
 @Column(nullable=false) private boolean terminated;
 @ManyToOne(optional=false) @JoinColumn(name="employee_id") private Employee employee;
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public ContractType getType(){return type;} public void setType(ContractType v){type=v;}
 public LocalDate getStartDate(){return startDate;} public void setStartDate(LocalDate v){startDate=v;}
 public LocalDate getEndDate(){return endDate;} public void setEndDate(LocalDate v){endDate=v;}
 public BigDecimal getGrossSalary(){return grossSalary;} public void setGrossSalary(BigDecimal v){grossSalary=v;}
 public boolean isTerminated(){return terminated;} public void setTerminated(boolean v){terminated=v;}
 public Employee getEmployee(){return employee;} public void setEmployee(Employee v){employee=v;}
}
