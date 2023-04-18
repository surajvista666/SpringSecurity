package com.spring.Security.springSecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {
    @GetMapping("/employee")
    public ResponseEntity<String> employeeUser(){
        return ResponseEntity.ok("<h1>Employee Page</h1>");
    }
    @GetMapping("/manager")
    public ResponseEntity<String> managerUser(){
        return ResponseEntity.ok("<h1>Manager Pages</h1>");
    }
    @GetMapping("/admin")
    public ResponseEntity<String> adminUser(){
        return ResponseEntity.ok("<h1>Administrator Pages</h1>");
    }

}