//Program to demonstrate parametrized constructor
class bclass {
    int a;

    // Parametrized constructor
    bclass(int p) {
        a = p;
    }

    void incr() {
        a++;
        System.out.println(a);
    }
}

class ParaCunstructor {
    public static void main(String args[]) {
        // Parametrized constructor is accessed by passing required parameter while
        // creating an object
        bclass obj1 = new bclass(10);
        obj1.incr();

        // Different objects can send different values to initialized their own data
        // members
        bclass obj2 = new bclass(20);
        obj2.incr();
    }
}