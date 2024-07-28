//Program to demonstrate simple inheritance
//Declaration of base class
class aclass {
    int a; // Private data members are not allowed to be accessed by derived class

    aclass() // constructor of base class
    {
        a = 10;
    }

    void adisplay() // Private member functions are not allowed to be accessed by derived class
    {
        System.out.println(a);
    }
}

// Declaration of derived class using extends keyword.
class bclass extends aclass {
    int b;

    bclass() // constructor of derived class
    {
        // default constructor of base class gets implicitly accessed first
        b = 20;
    }

    void bdisplay() // method of derived class
    {
        System.out.println(a); // data member of base class is accessed through own member function
        System.out.println(b);
    }
}

class SimpleInheritance {
    public static void main(String args[]) {
        aclass aobj = new aclass();
        aobj.adisplay();

        bclass bobj = new bclass();
        bobj.adisplay(); // member function of base class is accessed through own object
        bobj.bdisplay();
    }
}