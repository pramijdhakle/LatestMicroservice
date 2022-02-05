package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/signup")
    public ResponseEntity<Employee> employeeSignUp(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.employeeSignUp(employee));
    }
    @GetMapping("/getalldata")
    public List<Employee> getAllData(){
        return employeeService.getAllData();
    }
    @GetMapping("/employeesignin/{employeeEmailId}/{employeePassword}")
    public boolean employeeSignIn(@PathVariable String employeeEmailId,@PathVariable String employeePassword){
        return employeeService.employeeSignIn(employeeEmailId,employeePassword);
    }
    @GetMapping("/getdatabyid/{employeeId}")
    public RestTemplateVO restTemplateVO(@PathVariable int employeeId){
        return employeeService.restTemplateVO(employeeId);
    }
    @GetMapping("/getdatabyname/{employeeName}")
    public ResponseEntity<Employee> getDataByName(@PathVariable String employeeName){
        return ResponseEntity.ok(employeeService.getDataByName(employeeName));
    }
    @PutMapping("/updatedata/{employeeId}")
    public ResponseEntity<Employee> updateData(@PathVariable int employeeId,@RequestBody Employee employee ){
        return ResponseEntity.ok(employeeService.updateData(employee));
    }
    @DeleteMapping("/deletedata/{employeeId}")
    public ResponseEntity<String> deleteData(@PathVariable int employeeId ){
        employeeService.deleteData(employeeId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }
}
