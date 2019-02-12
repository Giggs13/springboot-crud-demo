package com.giggs13.springbootcruddemo.service.impl;

import com.giggs13.springbootcruddemo.dao.EmployeeRepository;
import com.giggs13.springbootcruddemo.entity.Employee;
import com.giggs13.springbootcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employeeSpringDataJpaService")
public class EmployeeSpringDataJpaServiceImpl
        implements EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeSpringDataJpaServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee getById(int id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
