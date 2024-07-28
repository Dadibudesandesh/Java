//Program to demonstrate constructor overloading
//Constructor overloading is an example of static polymorphism
class bclass {
    int a;

    // Default constructor
    bclass() {
        a = 10;
    }

    // Parametrized constructor
    bclass(int p) {
        a = p;
    }

    void incr() {
        a++;
        System.out.println(a);
    }
}

class CunstructorOverloading {
    public static void main(String args[]) {
        // The object is having choice to call any one of the constructors.
        // obj1 is calling default constructor.
        bclass obj1 = new bclass(10);
        obj1.incr();

        // obj2 is calling parametrized constructor.
        bclass obj2 = new bclass(20);
        obj2.incr();
    }
}