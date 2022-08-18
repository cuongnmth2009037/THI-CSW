package com.example.thicsw.service;

import com.example.thicsw.entity.Employee;
import com.example.thicsw.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id){
        return employeeRepository.findById(id);

    }

    public Employee update(Long id, Employee employeeUpdate){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            employee.setName(employeeUpdate.getName());
            employee.setSalary(employeeUpdate.getSalary());
            employeeRepository.save(employee);
            return employee;
        }
        return null;
    }
}
