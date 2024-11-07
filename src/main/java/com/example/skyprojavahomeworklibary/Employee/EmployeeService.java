package com.example.skyprojavahomeworklibary.Employee;

import objects.Employee;

import exceptions.EmployeeNotFoundException;
import exceptions.EmployeeAlreadyAddedException;
import exceptions.EmployeeStorageIsFullException;

import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public final class EmployeeService {
    private final int lengthOfEmployee = 1000;
    private final HashSet<Employee> employees = new HashSet<Employee>();

    // Add method
    public Employee addEmployee(String firstName, String lastName)
            throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        Employee employee = new Employee(firstName, lastName);

        if (employees.size() == lengthOfEmployee) {
            throw new EmployeeStorageIsFullException("Employee Storage is Full");
        }

        boolean isAdded = employees.add(employee);

        if (!isAdded) {
            throw new EmployeeAlreadyAddedException("Employee already added");
        }

        return employee;
    }

    // Remove method
    public Employee removeEmployee(String firstName, String lastName)
            throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);

        boolean isRemoved = employees.remove(employee);

        if (!isRemoved) {
            throw new EmployeeNotFoundException("Employee not found");
        }

        return employee;
    }

    // Find method
    public Employee findEmployee(String firstName, String lastName)
            throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);

        for (Employee e : employees) {
            if (e.equals(employee)) {
                return employee;
            }
        }

        throw new EmployeeNotFoundException("Employee not found");
    }

    // Display method
    public HashSet<Employee> getAllEmployees() {
        return employees;
    }

    // Get methods
    public int getLengthOfEmployee() {
        return lengthOfEmployee;
    }

    public HashSet<Employee> getEmployees() {
        return employees;
    }
}
