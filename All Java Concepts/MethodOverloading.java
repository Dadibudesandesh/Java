//Program to demonstrate method overloading
//method overloading is an example of static polymorphism
class bclass {
    int a;

    // Default constructor
    bclass() {
        a = 10;
    }

    // method with zero arguments
    void incr() {
        a++;
        System.out.println(a);
    }

    // method with one argument
    void incr(int p) {
        a = a + p;
        System.out.println(a);
    }
}

class MethodOverloading {
    public static void main(String args[]) {
        // The object is having choice to call any one of the methods.
        // obj1 is calling method with zero argument.
        bclass obj1 = new bclass();
        obj1.incr();

        // obj2 is calling method with one argument.
        bclass obj2 = new bclass();
        obj2.incr(10);
    }
}