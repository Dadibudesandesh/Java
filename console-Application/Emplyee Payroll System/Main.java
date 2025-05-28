import java.util.*;

abstract class Employee {
    private String name;
    private int eid;

    public Employee(String name, int eid) {
        this.name = name;
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public int getEid() {
        return eid;
    }

    abstract public double calculateSalery();

    @Override
    public String toString() {
        return "Employee[name=" + name + ", id=" + eid + ", salary=" + calculateSalery() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int eid, double monthlySalary) {
        super(name, eid);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalery() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int eid, int hoursWorked, double hourlyRate) {
        super(name, eid);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public double calculateSalery() {
        return hourlyRate * hoursWorked;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee); 
    }

    public void removeEmployee(int eid){
        Employee employeeToRemove=null;
        for (Employee employee : employeeList) {
            if(employee.getEid() == eid){
                employeeToRemove=employee;
                break;
            }
        }

        if (employeeToRemove!=null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

}
public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem =new PayrollSystem();
        FullTimeEmployee fullTimeEmployee=new FullTimeEmployee("sandesh", 01, 50000);
        PartTimeEmployee partTimeEmployee=new PartTimeEmployee("Rushabh", 02, 5, 100);

        payrollSystem.addEmployee(fullTimeEmployee);
        payrollSystem.addEmployee(partTimeEmployee);
        payrollSystem.displayEmployees();
        payrollSystem.removeEmployee(01);
        payrollSystem.displayEmployees();
    }

}