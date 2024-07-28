package inheritance.hierarchical;

class shapColor {                                   // Base class
    public void area() {
        System.out.println("Display Area");
    }
}

class Triangle extends shapColor {                  // Derived class 1
    public void area(int h, int l) {
        System.out.println("Triangle");
        System.out.println(0.5 * h * l);
    }
}

class circle extends shapColor {         // Derived class 2
    public void area(double r) {
        System.out.println("Circle");
        System.out.println(3.14*r*r);
    }
}

public class hierarchical {

    public static void main(String[] args) {
        Triangle tr = new Triangle();
        tr.area();
        tr.area(12,10);
        circle cr=new circle();
        cr.area(12.00);

    }
}