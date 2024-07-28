
 class sum {
    int a, b;

    public sum() {
        a = 10;
        b = 20;
        System.out.println("default cunstructor");
        System.out.println("Addition is : "+(a+b));
    }
    
    public sum(int x, int y) {
        a=x;
        b=y;
        System.out.println("parameterized cunstructor");
        System.out.println("Addition is : "+ (a+b));

    }

    public sum(sum sum) {
        System.out.println("copy cunstructor");
        System.out.println(sum.a+sum.b);
    }

}

public class prog1 {
    public static void main(String[] args) {
        sum obj = new sum();
        sum obj1 = new sum(50, 60);
        sum obj2=new sum(obj1);
    }
}
