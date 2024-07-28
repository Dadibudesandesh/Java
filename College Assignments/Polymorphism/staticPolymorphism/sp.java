package Polymorphism.staticPolymorphism;

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
    int a;

    bClass(){
        a=20;
    }

    void aDisplay(){
        System.out.println("B Class");
    }
}

public class sp {
    public static void main(String[] args) {
        aClass aobj=new aClass();
        aobj.aDisplay();
       bClass bobj=new bClass();
       bobj.aDisplay();

       aClass obj=new bClass();
       
    }

}
