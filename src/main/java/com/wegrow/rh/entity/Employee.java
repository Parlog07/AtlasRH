package com.wegrow.rh.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import com.wegrow.rh.enums.*;
@Entity @Table(name="employees")
public class Employee {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String matricule;
 @Column(nullable=false) private String firstName;
 @Column(nullable=false) private String lastName;
 @Column(nullable=false,unique=true) private String email;
 @Column(nullable=false) private String position;
 @Column(nullable=false) private LocalDate hireDate;
 @ManyToOne(optional=false) @JoinColumn(name="department_id") private Department department;
 @ManyToOne @JoinColumn(name="manager_id") private Employee manager;
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getMatricule(){return matricule;} public void setMatricule(String v){matricule=v;}
 public String getFirstName(){return firstName;} public void setFirstName(String v){firstName=v;}
 public String getLastName(){return lastName;} public void setLastName(String v){lastName=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPosition(){return position;} public void setPosition(String v){position=v;}
 public LocalDate getHireDate(){return hireDate;} public void setHireDate(LocalDate v){hireDate=v;}
 public Department getDepartment(){return department;} public void setDepartment(Department v){department=v;}
 public Employee getManager(){return manager;} public void setManager(Employee v){manager=v;}
}
