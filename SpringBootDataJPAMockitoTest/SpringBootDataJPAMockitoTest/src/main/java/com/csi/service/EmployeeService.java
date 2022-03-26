package com.csi.service;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeService {

    void saveData(Employee employee);

    List<Employee> getAllData();

    void updateData(Employee employee);

    void deleteData(int empId);
}
