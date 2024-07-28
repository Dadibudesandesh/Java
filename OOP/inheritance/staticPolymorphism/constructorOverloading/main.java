package inheritance.staticPolymorphism.constructorOverloading;

class Sum {
    public int a, b, c = 0;

    public Sum() {
        a = 10;
        b = 20;
    }

    public Sum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Sum(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void display() {
        System.out.println("A : "+(this.a) + " B : "+(this.b)+" C : "+(this.c));
        System.out.println("Addition is : "+(a+b+c));
    }

}

public class main {
    public static void main(String[] args) {
        Sum obj = new Sum();
        obj.display();
        Sum obj1 = new Sum(40, 20);
        obj1.display();
        Sum obj2 = new Sum(40, 29, 40);
        obj2.display();
    }
}
