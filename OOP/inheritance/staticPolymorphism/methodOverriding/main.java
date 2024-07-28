package inheritance.staticPolymorphism.methodOverriding;

class AClass{
    int a;
    AClass(){
        a=10;
    }

    public void ADisplay(){
        System.out.println("A Method");
    }
}

class BClass extends AClass{
    int b;
    BClass(){
        b=20;
    }
    public void ADisplay(){
        System.out.println("B Method");
    }
}

public class main {
    public static void main(String[] args) {
        BClass bobj=new BClass();
        System.out.println("A : "+bobj.a);
        System.out.println("B : "+bobj.b);
        bobj.ADisplay();
    }
}
