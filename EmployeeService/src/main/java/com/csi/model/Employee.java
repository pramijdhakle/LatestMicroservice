package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private int employeeId;

    private String employeeName;
    private String employeeAddress;
    private long employeeContactNumber;
    private String employeeCode;
    private String employeeEmailId;
    private String employeePassword;
    private String employeeBankName;
    private String employeePANNumber;
    private long employeeAadharCardNumber;
    private long employeeUANNumber;
    private long employeeSalaryAccountNumber;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    private Date employeeDOB;

    private int departmentId;


}
