package com.giggs13.springbootcruddemo.service.impl;

import com.giggs13.springbootcruddemo.dao.EmployeeDAO;
import com.giggs13.springbootcruddemo.entity.Employee;
import com.giggs13.springbootcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employeeJpaService")
public class EmployeeJpaServiceImpl
        implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeJpaServiceImpl(@Qualifier("employeeDAOJpa") EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDAO.delete(id);
    }
}
