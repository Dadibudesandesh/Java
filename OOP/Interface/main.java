package Interface;

interface Animal{
    public void walk();        // in interface you do not create or define function and cunstructors 
                               // you can only declare the methods
}

class Hourse implements Animal{
    public void walk(){
        System.out.println("Hourse is walking");
    }
}

public class main {
    public static void main(String[] args) {
        Hourse hourse=new Hourse();
        hourse.walk();
    }
}
