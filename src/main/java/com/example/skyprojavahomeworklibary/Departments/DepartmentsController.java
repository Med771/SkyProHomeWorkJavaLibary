package com.example.skyprojavahomeworklibary.Departments;

import objects.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentsController {
    // Init Controller Service
    private final DepartmentsService departmentsService;

    public DepartmentsController(final DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping(path = "/all")
    public Employee[] getAllEmployees(@RequestParam(value = "departmentId", required = false) Integer departmentId) {
        return departmentsService.getAllEmployees(departmentId);
    }

    @GetMapping(path = "/max-salary")
    public Employee getMaxSalary(@RequestParam(value = "departmentId") int departmentId) {
        return departmentsService.getMaxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee getMinSalary(@RequestParam(value = "departmentId") int departmentId) {
        return departmentsService.getMinSalary(departmentId);
    }
}
