package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    EmployeeRepository employeeRepositoryImpl;

    @Override
    public void saveData(Employee employee) {
        log.info("************** Trying to save data of Employee: "+employee.getEmpName());
        employeeRepositoryImpl.save(employee);
    }

    @Override
    public List<Employee> getAllData() {

        log.info("************** Total Employees: "+employeeRepositoryImpl.findAll().size());
        return employeeRepositoryImpl.findAll();
    }

    @Override
    public void updateData(Employee employee) {

        log.info("*********** Trying to update data of Employee: "+ employee.getEmpName());
        employeeRepositoryImpl.save(employee);
    }

    @Override
    public void deleteData(int empId) {
        log.info("*********** Trying to delete data of Employee ID: "+empId);
        employeeRepositoryImpl.deleteById(empId);
    }
}
