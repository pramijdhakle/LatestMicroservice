package com.csi.service;

import com.csi.dao.DepartmentDaoImpl;
import com.csi.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl {

    @Autowired
    DepartmentDaoImpl departmentDao;

    public Department saveData(Department department) {
        return departmentDao.saveData(department);
    }

    public List<Department> getAllData() {
        return departmentDao.getAllData();
    }

    public Optional<Department> getDataByDepartmentId(int departmentId) {
        return departmentDao.getDataByDepartmentId(departmentId);
    }

    public Department getDataByDepartmentName(String departmentName) {
        return departmentDao.getDataByDepartmentName(departmentName);
    }

    public Department updateDepartmentData(Department department) {
        return departmentDao.updateDepartmentData(department);
    }

    public void deleteDataById(int departmentId) {
        departmentDao.deleteDataById(departmentId);
    }
}
