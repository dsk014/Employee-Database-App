import java.util.List;
import java.util.Scanner;

public class EmployeeApp  {
    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Employee Database Menu ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter designation: ");
                    String desig = sc.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = sc.nextDouble();
                    dao.addEmployee(new Employee(name, desig, salary));
                    break;

                case 2:
                    List<Employee> employees = dao.getAllEmployees();
                    employees.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter employee ID to update: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter new salary: ");
                    double newSal = sc.nextDouble();
                    dao.updateEmployee(uid, newSal);
                    break;

                case 4:
                    System.out.print("Enter employee ID to delete: ");
                    int did = sc.nextInt();
                    dao.deleteEmployee(did);
                    break;

                case 5:
                    System.out.println(" Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid choice!");
            }
        }
        }
    }
