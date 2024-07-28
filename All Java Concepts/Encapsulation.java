//Program to demonstrate class, object and encapsulation.
//Class is a collection of Data members and member functions.

class bclass {
    private int a;

    public bclass() {
        a = 10;
    }

    // Encapsulation means Private data members are accessed through public member
    // functions.
    public void incr() {
        a++;
        System.out.println(a);
    }
}

class Encapsulation {
    public static void main(String args[]) {
        // Object is an instance of class where name of object is called as reference
        // Instance is dynamic memory allocated to object using new keyword

        bclass obj = new bclass();
        obj.incr();

        // Private data members can not be accessed through object while other access
        // specifiers can
        // Change access specifier of int a to public, protected and check the result of
        // following statement.

        // System.out.println(obj.a);
    }
}
