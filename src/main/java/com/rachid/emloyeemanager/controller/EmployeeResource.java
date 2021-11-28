package com.rachid.emloyeemanager.controller;

import com.rachid.emloyeemanager.model.Employee;
import com.rachid.emloyeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLEngineResult;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
         ResponseEntity<List<Employee>> responseEntity =
                 new ResponseEntity(employeeService.findAllEmployee(), HttpStatus.OK );
         return responseEntity;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getAllEmployeeById(@PathVariable("id")Long id){
        ResponseEntity<Employee> responseEntity  =
                new ResponseEntity(employeeService.findEmployeeById(id), HttpStatus.OK );
        return responseEntity;
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        ResponseEntity<Employee> responseEntity  =
                new ResponseEntity(employeeService.addEmployee(employee), HttpStatus.CREATED );
        return responseEntity;
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        ResponseEntity<Employee> responseEntity  =
                new ResponseEntity(employeeService.updateEmployee(employee), HttpStatus.OK );
        return responseEntity;
    }

    @DeleteMapping("/find/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id")Long id){
        employeeService.deleteEmployeeById(id);
        return new  ResponseEntity( HttpStatus.OK );

    }

}
