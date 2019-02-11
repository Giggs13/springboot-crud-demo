package com.giggs13.springbootcruddemo.dao;

import com.giggs13.springbootcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void delete(int id);
}
