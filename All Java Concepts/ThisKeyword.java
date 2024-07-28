//Program to demonstrate this keyword
class bclass {
    int a;

    // Parametrized constructor
    bclass(int a) {
        this.a = a; // this keyword is referred as self reference.
    }

    void incr() {
        a++;
        System.out.println(a);
    }
}

class ThisKeyword {
    public static void main(String args[]) {
        // The object which is accessing the code is referred as this.
        bclass obj1 = new bclass(10);
        obj1.incr();

        bclass obj2 = new bclass(20);
        obj2.incr();
    }
}