package com.wegrow.rh.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.wegrow.rh.enums.*;
@Entity @Table(name="leave_types")
public class LeaveType {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String name;
 @Column(nullable=false) private Integer daysPerYear;
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public Integer getDaysPerYear(){return daysPerYear;} public void setDaysPerYear(Integer v){daysPerYear=v;}
}
