package com.csi.controller;


import com.csi.exception.RecordNotFoundException;
import com.csi.model.Department;
import com.csi.repo.DepartmentRepository;
import com.csi.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    DepartmentServiceImpl departmentService;

    @Autowired
    DepartmentRepository departmentRepository;

    @PostMapping("/savedepartmentdata")
    public ResponseEntity<Department> saveData(@RequestBody Department department){
        return ResponseEntity.ok(departmentService.saveData(department));
    }
    @GetMapping("/getalldata")
    public List<Department> getAllData(){
        return departmentService.getAllData();
    }
    @GetMapping("/getdatabyid/{departmentId}")
    public ResponseEntity<Optional<Department>> getDataByDepartmentId(@PathVariable int departmentId ){
        return ResponseEntity.ok(departmentService.getDataByDepartmentId(departmentId));
    }
    @GetMapping("/getdatabyname/{departmentName}")
    public ResponseEntity<Department> getDataByDepartmentName(@PathVariable String departmentName){
        return ResponseEntity.ok(departmentService.getDataByDepartmentName(departmentName));
    }
    @PutMapping("/updatedata/{departmentId}")
    public Department updateDepartmentData(@PathVariable int departmentId, @RequestBody Department department) throws RecordNotFoundException{
        Department department1= departmentRepository.findById(departmentId).orElseThrow(()->new RecordNotFoundException("Department Id is Not Available"));
        return departmentService.updateDepartmentData(department);
    }
    @DeleteMapping("/deletedata/{departmentId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int departmentId){
        departmentService.deleteDataById(departmentId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

}
