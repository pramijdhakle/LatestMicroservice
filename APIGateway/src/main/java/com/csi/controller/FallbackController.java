package com.csi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/employeefallback")
    public ResponseEntity<String> employeeFallBack(){
        return ResponseEntity.ok("Employee Service is Not working please wait !!!!!!!!");
    }

    @GetMapping("/departmentfallback")
    public ResponseEntity<String> departmentFallBack(){
        return ResponseEntity.ok("Department Service is Not Working please wait !!!!");
    }
}
