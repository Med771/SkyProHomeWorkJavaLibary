package objects;

import java.util.Objects;

public final class Employee {
    // Init
    private final String firstName;
    private final String lastName;
    private final int departmentId;
    private final double salary;

    // Constructor
    public Employee(String firstName, String lastName, int departmentId, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    // Get
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public double getSalary() {
        return salary;
    }

    // Base methods
    @Override
    public String toString() {
        if (firstName != null && lastName != null) {
            return firstName + " " + lastName +
                    "\ndepartment: " + departmentId +
                    "\nsalary: " + salary;
        }

        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return departmentId == employee.departmentId && Double.compare(salary, employee.salary) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentId, salary);
    }
}
