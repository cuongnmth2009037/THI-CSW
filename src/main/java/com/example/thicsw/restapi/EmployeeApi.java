package com.example.thicsw.restapi;

import com.example.thicsw.entity.Employee;
import com.example.thicsw.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin("*")
public class EmployeeApi {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Employee> employeeOptional = employeeService.findById(id);
        if (employeeOptional.isPresent()){
            return ResponseEntity.ok(employeeOptional.get());
        }
        return ResponseEntity.badRequest().body("Employee not found!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Employee employeeUpdate){
        Employee employee = employeeService.update(id, employeeUpdate);
        if (employee != null){
            return ResponseEntity.ok(employee);
        }
        return  ResponseEntity.badRequest().body("Employee not found!");
    }






}
