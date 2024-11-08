package com.example.skyprojavahomeworklibary.Departments;

import objects.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.Stream;

@Service
public class DepartmentsService {
    // Init
    private final Employee[] employees = {
            new Employee("1", "1", 1, 5),
            new Employee("2", "2", 2, 2),
            new Employee("3", "3", 3, 5),
            new Employee("4", "4", 4, 4),
            new Employee("5", "5", 5, 5),
    };

    // Methods
    public Employee[] getAllEmployees(Integer departmentId) {
        if (departmentId == null) {
            return Stream.of(employees).sorted(Comparator.comparingInt(Employee::getDepartmentId)).toArray(Employee[]::new);
        }

        return Stream.of(employees).filter(emp -> departmentId == emp.getDepartmentId()).toArray(Employee[]::new);
    }

    public Employee getMaxSalary(int departmentId) {
        return Stream.of(employees)
                .filter(emp -> departmentId == emp.getDepartmentId())
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    public Employee getMinSalary(int departmentId) {
        return Stream.of(employees)
                .filter(emp -> departmentId == emp.getDepartmentId())
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }
}

