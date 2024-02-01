
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Employee {

    private String empName;
    private String empId;
    private int empSalary;

    public Employee() {
    }

    public Employee(String empNeme, String empId, int empSalary) {
        this.empName = empNeme;
        this.empId = empId;
        this.empSalary = empSalary;
    }

    public void setEmpName(String empNeme) {
        this.empName = empNeme;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setEmpSalary(int empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpId() {
        return empId;
    }

    public int getEmpSalary() {
        return empSalary;
    }

    @Override
    public String toString() {
        return "Employee [empName=" + empName + ", empId=" + empId + ", empSalary=" + empSalary + "]";
    }

}

class EmployeeDetail extends Employee {

    Scanner sc = new Scanner(System.in);
    Map<String, Employee> map = new HashMap<>();

    void addEmployee() {

        System.out.println("\nEnter Name");
        sc.skip("\\R?");
        String name = sc.nextLine();

        System.out.println("\nEnter Id");
        String id = sc.nextLine();

        System.out.println("\nEnter Salary");
        int salary = sc.nextInt();

        Employee employee = new Employee(name, id, salary);
        map.put(id, employee);

        System.out.println("\nPress ~ to open menu again");
        sc.nextLine();

    }

    void getSingleEmployeeDetail() {
        if (map.isEmpty()) {
            System.out.println("\nEmployee list is empty 'Please add some details first!'");
        } else {
            System.out.println("\n\nEnter Employee Id whose detail you want : ");
            String id = sc.nextLine();
            if (map.containsKey(id)) {
                Employee e = map.get(id);
                System.out.println("Employee [Employee-Name=" + e.getEmpName() + ", Employee-Id=" + e.getEmpId() + ", Employee-Salary="+ e.getEmpSalary() + "]");
            } else {
                System.out.println("\nNo such employee exist ");
            }
        }

        System.out.println("\nPress ~ to open menu again");
        sc.nextLine();
    }

    void getAllemployee() {

        if (map.isEmpty()) {
            System.out.println("\n\nEmployee list is empty 'Please add some details first!'");
        } else {
            for (Map.Entry<String, Employee> entry : map.entrySet()) {
                Employee e = entry.getValue();
                System.out.println("Employee [Employee-Name=" + e.getEmpName() + ", Employee-Id=" + e.getEmpId() + ", Employee-Salary="+ e.getEmpSalary() + "]");
            }
        }

        System.out.println("\nPress ~ to open menu again");
        sc.nextLine();
    }

    public static void main(String[] args) {

        String input;
        Scanner sc = new Scanner(System.in);
        EmployeeDetail employeeDetail = new EmployeeDetail();

        do {

            System.out.println("\nChoose any one ");
            System.out.println("1. Add Enployee Details");
            System.out.println("2. Get an Employee Details");
            System.out.println("3. Get all Employee Details");
            System.out.println("4. To Quit");

            System.out.println("\nPlease Enter any one : ");
            input = sc.nextLine();

            switch (input) {
                case "1":
                    employeeDetail.addEmployee();
                    break;
                case "2":
                    employeeDetail.getSingleEmployeeDetail();
                    break;
                case "3":
                    employeeDetail.getAllemployee();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Please Enter Valid option out of 1 to 4 ");
                    System.out.println("\nPress ~ to open menu again");
                    sc.nextLine();
                    break;
            }
        } while (!input.equals("4"));

        sc.close();
    }

}
