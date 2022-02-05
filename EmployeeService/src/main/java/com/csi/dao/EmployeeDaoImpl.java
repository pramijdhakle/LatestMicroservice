package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepository;
import com.csi.vo.Department;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RestTemplate restTemplate;

    public Employee employeeSignUp(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllData() {
        return employeeRepository.findAll();
    }

    public boolean employeeSignIn(String employeeEmailId, String employeePassword) {
        boolean flag= false;
        List<Employee> employeeList= employeeRepository.findAll();

        for (Employee employee : employeeList){
            if (employee.getEmployeeEmailId().equals(employeeEmailId) && employee.getEmployeePassword().equals(employeePassword)){
                flag=true;
            }
        }  return flag;

    }

    public RestTemplateVO restTemplateVO(int employeeId) {

        RestTemplateVO restTemplateVO= new RestTemplateVO();
        Employee employee= employeeRepository.findByEmployeeId(employeeId);

        Department department= restTemplate.getForObject("http://DepartmentService/departments/"+ employee.getDepartmentId(),Department.class);
        restTemplateVO.setEmployee(employee);
        restTemplateVO.setDepartment(department);
        return restTemplateVO;
    }

    public Employee getDataByName(String employeeName) {
        return employeeRepository.findByEmployeeName(employeeName);
    }

    public Employee updateData(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteData(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
