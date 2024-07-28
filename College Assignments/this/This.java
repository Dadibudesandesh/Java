

class Student {
    String name;
    int roll;

    public void display(){
        System.out.println(this.name);
        System.out.println(this.roll);
    }
}

public class This {

    public static void main(String args[]){
        Student s1=new Student();
        s1.name="sandesh";
        s1.roll=47;
        s1.display();
        Student s2=new Student();
        s2.name="rushabh";
        s2.roll=48;
        s2.display();
    }
}