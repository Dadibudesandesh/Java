package Polymorphism.dynamicPolymorphism;
class aClass{
    int a;

    aClass(){
        a=10;
    }
    void aDisplay(){
        System.out.println("A Class");
    }
}

class bClass extends aClass{
    int b;

    bClass(){
        b=20;
    }

    void bDisplay(){
        System.out.println("B Class");
    }
}

public class dp {
    public static void main(String[] args) {
       bClass bobj=new bClass();
       bobj.bDisplay();
       bobj.aDisplay(); 
    }
}
