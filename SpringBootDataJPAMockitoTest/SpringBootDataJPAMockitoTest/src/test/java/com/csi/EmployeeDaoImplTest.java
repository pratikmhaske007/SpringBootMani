package com.csi;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDaoImplTest {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    @MockBean
    EmployeeRepository employeeRepositoryImpl;

    @Test
    public void saveDataTest()
    {
        Employee employee=new Employee(121, "PRATIK", 70707.77,"PCMC");
        employeeDaoImpl.saveData(employee);

        verify(employeeRepositoryImpl, times(1)).save(employee);

    }

    @Test
    public void getAllDataTest()
    {
        when(employeeRepositoryImpl.findAll()).thenReturn(Stream.of(new Employee(100,"JAMES",788888.8,"LONDON"),new Employee(200,"DAVID",888778.8,"BIRMINGHAM")).collect(Collectors.toList()));

        Assert.assertEquals(2,employeeDaoImpl.getAllData().size());


    }

    @Test
    public void updateDataTest()
    {
        Employee employee=new Employee(11, "abcd", 77.77,"Garibwadi");
        employeeDaoImpl.updateData(employee);

        verify(employeeRepositoryImpl, times(1)).save(employee);

    }

    @Test
    public void deleteDataTest()
    {
        Employee employee=new Employee(121, "PRATIK", 70707.77,"PCMC");
        employeeDaoImpl.deleteData(employee.getEmpId());

        verify(employeeRepositoryImpl, times(1)).deleteById(employee.getEmpId());

    }
}
