package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDao;

    public Employee employeeSignUp(Employee employee) {
        return employeeDao.employeeSignUp(employee);
    }

    public List<Employee> getAllData() {
        return employeeDao.getAllData();
    }

    public boolean employeeSignIn(String employeeEmailId, String employeePassword) {
        return employeeDao.employeeSignIn(employeeEmailId,employeePassword);
    }

    public RestTemplateVO restTemplateVO(int employeeId) {
        return employeeDao.restTemplateVO(employeeId);
    }

    public Employee getDataByName(String employeeName) {
        return employeeDao.getDataByName(employeeName);
    }

    public Employee updateData(Employee employee) {
        return employeeDao.updateData(employee);
    }

    public void deleteData(int employeeId) {
        employeeDao.deleteData(employeeId);
    }
}
