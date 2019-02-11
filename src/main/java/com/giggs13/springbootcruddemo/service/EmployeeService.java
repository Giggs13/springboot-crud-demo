package com.giggs13.springbootcruddemo.service;

import com.giggs13.springbootcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getById(int id);

    void save(Employee employee);

    void delete(int id);
}
