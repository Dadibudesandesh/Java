

class shapColor { // Base class
    String color;

    shapColor(String color) {
        this.color = color;
    }
}

class Triangle extends shapColor { // Derived class 1
    String ShapName;
    Triangle(String color,String ShapName){
        super(color);
        this.ShapName=ShapName;
    }
    public void area(int h, int l) {
        System.out.println(0.5 * h * l);
    }
}


class EqualatralTriangle extends Triangle { // Derived class 2
    EqualatralTriangle(String color,String ShapName) {
        super(color,ShapName);        
    }
    public void area(int l, int h) {
        System.out.println(0.5 * l * h);
    }
}

public class MultiLevel {
    public static void main(String[] args) {
        Triangle tr = new Triangle("BLUE","triangle");
        System.out.println(tr.color);
    }
}
