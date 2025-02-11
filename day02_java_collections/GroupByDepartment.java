package day02_java_collections;
import java.util.*;
import java.util.stream.Collectors;

// Employee class with name and department properties
class Employee {
    private String name;
    private String department;

    // Constructor
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    // For readable output
    @Override
    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {
        // List of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"),
                new Employee("David", "Finance"),
                new Employee("Eve", "IT")
        );

        // Grouping employees by department
        Map<String, List<Employee>> groupedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // Displaying grouped employees
        groupedByDepartment.forEach((department, empList) ->
                System.out.println(department + ": " + empList)
        );
    }
}
