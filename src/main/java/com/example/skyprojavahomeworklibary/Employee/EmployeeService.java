package com.example.skyprojavahomeworklibary.Employee;

import objects.Employee;

import exceptions.EmployeeNotFoundException;
import exceptions.EmployeeAlreadyAddedException;
import exceptions.EmployeeStorageIsFullException;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public final class EmployeeService {
    private final int lengthOfEmployee = 1000;
    private final Map<String, Employee> employees = new HashMap<>(lengthOfEmployee);

    // Add method
    public Employee addEmployee(String firstName, String lastName)
            throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName, lastName);

        if (employees.size() == lengthOfEmployee) {
            throw new EmployeeStorageIsFullException("Employee Storage is Full");
        }

        if (employees.get(firstName+lastName) != null) {
            throw new EmployeeAlreadyAddedException("Employee already added");
        }

        employees.put(firstName+lastName, employee);

        return employee;
    }

    // Remove method
    public Employee removeEmployee(String firstName, String lastName)
            throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);

        if (employees.get(firstName+lastName) == null) {
            throw new EmployeeNotFoundException("Employee not found");
        }

        employees.remove(firstName+lastName);

        return employee;
    }

    // Find method
    public Employee findEmployee(String firstName, String lastName)
            throws EmployeeNotFoundException {
        Employee employee = employees.get(firstName+lastName);

        if (employee == null) {
            throw new EmployeeNotFoundException("Employee not found");
        }

        return employee;
    }

    // Get methods
    public int getLengthOfEmployee() {
        return lengthOfEmployee;
    }

    public Map<String, Employee> getEmployees() {
        return employees;
    }
}
