package com.csi.dao;

import com.csi.model.Department;
import com.csi.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class DepartmentDaoImpl {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department saveData(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAllData() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDataByDepartmentId(int departmentId) {
        return departmentRepository.findById(departmentId);

    }

    public Department getDataByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    public Department updateDepartmentData(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDataById(int departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
