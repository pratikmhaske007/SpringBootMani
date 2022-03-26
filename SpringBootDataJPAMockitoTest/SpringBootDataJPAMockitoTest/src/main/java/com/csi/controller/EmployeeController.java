package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import com.csi.service.EmployeeService;
import com.csi.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {
//editedingithubbybabumoshay
    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    EmployeeRepository employeeRepositoryImpl;

    @PostMapping("/savedata")
    public ResponseEntity<String> saveData(@RequestBody Employee employee)
    {
        log.info("************Saving Data Of Employee : "+employee.getEmpName());
        employeeServiceImpl.saveData(employee);
        return ResponseEntity.ok("Employee Data Saved Successfully");
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData()
    {
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<String> updateData(@PathVariable int empId, @RequestBody Employee employee)
    {
        Employee employee1=employeeRepositoryImpl.findById(empId).orElseThrow(()-> new RecordNotFoundException("Employee Record Not Found"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpAddress(employee.getEmpAddress());

        employeeServiceImpl.updateData(employee1);

        return ResponseEntity.ok("Employee Data Updated Successfully");
    }

    @DeleteMapping("/deletedata/{empId}")
    public ResponseEntity<String> deleteData(@PathVariable int empId)
    {
        employeeServiceImpl.deleteData(empId);
        return ResponseEntity.ok("Employee Data Deleted Successfully");
    }


}
