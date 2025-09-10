interface EmpData {
    int[] EmpId = new int[100];
    String[] EmpName = new String[100];
    long[] EmpSalary = new long[100];
    public void setEmpData(String name, long salary);
}
class Emp implements EmpData {
    int id = 1;
    public void setEmpData(String name, long salary) {
        EmpId[0] = id;
        EmpName[0] = name;
        EmpSalary[0] = salary;

        System.out.println("Data inserted successfully , Your Id is " + id);
        id++;
    }
    public void getData(int id){
        System.out.println("EmpId : "+id);
        System.out.println(EmpName[id-1]);
        System.out.println(EmpSalary[id-1]);
    }
}
public class Main {
    public static void main(String[] args) {
        Emp emp = new Emp();
        emp.setEmpData("sandesh",70000);
//        emp.setEmpData("Rushabh",80000);
        emp.getData(1);
    }
} 