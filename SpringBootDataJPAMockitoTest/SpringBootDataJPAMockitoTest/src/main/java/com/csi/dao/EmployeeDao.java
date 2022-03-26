package com.csi.dao;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void saveData(Employee employee);

    List<Employee> getAllData();

    void updateData(Employee employee);

    void deleteData(int empId);
}
