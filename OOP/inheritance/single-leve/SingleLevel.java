
class shapColor { // Base class
    public void area() {
        System.out.println("Display Area");
    }
}

class Triangle extends shapColor { // Derived class 1
    public void area(int h, int l) {
        System.out.println(0.5 * h * l);
    }
}


public class SingleLevel {

    public static void main(String[] args) {
        Triangle tr = new Triangle();

    }
}