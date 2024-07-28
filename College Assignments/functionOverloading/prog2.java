
class sum {

    private int a, b, c;

    public sum() {
        a = 10;
        b = 20;
    }

    public int add() {
        c = a + b;
        // System.out.println("");
        return c;
    }

    public int add(int a, int b) {
        c = a + b;
        return c;
    }

    public int add(int a, int b, int c) {
        return c=a+b;
    }

}

public class prog2 {

    public static void main(String args[]) {
        sum obj = new sum();
        System.out.println("First Method : " + obj.add());
        sum obj1 = new sum();
        System.out.println("Second Method : " + obj1.add(50, 60));
        sum obj2 = new sum();
        System.out.println("Third Method : " + obj2.add(20, 80, 0));
    }
}