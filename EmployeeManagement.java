package Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagement {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                addEmployee();
                break;

            case 2:
                viewEmployees();
                break;

            case 3:
                searchEmployee();
                break;

            case 4:
                updateEmployee();
                break;

            case 5:
                deleteEmployee();
                break;

            case 6:
                System.out.println("Thank you!");
                break;

            default:
                System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    // Add Employee
    static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, department, salary);

        employees.add(emp);

        System.out.println("Employee added successfully!");
    }

    // View Employees
    static void viewEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }

    // Search Employee
    static void searchEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee emp : employees) {

            if (emp.getId() == id) {
                emp.displayEmployee();
                return;
            }
        }

        System.out.println("Employee not found!");
    }

    // Update Employee
    static void updateEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee emp : employees) {

            if (emp.getId() == id) {

                sc.nextLine();

                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Department: ");
                String department = sc.nextLine();

                System.out.print("Enter New Salary: ");
                double salary = sc.nextDouble();

                emp.setName(name);
                emp.setDepartment(department);
                emp.setSalary(salary);

                System.out.println("Employee updated successfully!");
                return;
            }
        }

        System.out.println("Employee not found!");
    }

    // Delete Employee
    static void deleteEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee emp : employees) {

            if (emp.getId() == id) {

                employees.remove(emp);

                System.out.println("Employee deleted successfully!");
                return;
            }
        }

        System.out.println("Employee not found!");
    }
}