import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

// Mutable Employee Class
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return String.format(" %d |  %s |  %s |  %.2f", id, name, department, salary);
    }
}

public class CSVReader {
    public static void main(String[] args) {
        String filePath = "employees.csv";

        List<Employee> employees = readEmployeesFromCSV(filePath);
        displayEmployees(employees);
    }

    // Read Employees from CSV File
    private static List<Employee> readEmployeesFromCSV(String filePath) {
        try (Stream<String> lines = Files.lines(Path.of(filePath))) {
            return lines.skip(1) // Skip header
                        .map(CSVReader::parseEmployee)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    // Convert CSV Line to Employee Object
    private static Employee parseEmployee(String line) {
        String[] parts = line.split(",");
        if (parts.length != 4) {
            System.out.println("Skipping invalid record: " + line);
            return null;
        }

        try {
            return new Employee(
                Integer.parseInt(parts[0].trim()),
                parts[1].trim(),
                parts[2].trim(),
                Double.parseDouble(parts[3].trim())
            );
        } catch (NumberFormatException e) {
            System.out.println("Skipping invalid data: " + line);
            return null;
        }
    }

    // Display Employee List
    private static void displayEmployees(List<Employee> employees) {
        System.out.println("""
                =====================================
                Employee List
                =====================================
                """);
        if (employees.isEmpty()) {
            System.out.println(" No employees found.");
        } else {
            employees.forEach(System.out::println);
        }
    }
}
