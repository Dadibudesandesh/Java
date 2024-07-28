

 //    USE A MAIN METHOD IN SAME CLASS

/*class Static {                                         

    static int likes=0;

    static void display(){
        System.out.println("Static Method");
    }

    static
    {
        System.out.println("static Block");
        likes=10;
    }



    public static void main(String[] args) {

        System.out.println("Main Method");
        // System.out.println("static variable : "+(staticData.likes+10));
        // staticData.display();
    }
}*/



//   USING DIFFERENT CLASSES AND ACCESS THE STATIC VARIABLE / METHOD / BLOCK USING CLASS NAME

class staticData {

    static int likes=0;

    static void display(){
        System.out.println("Static Method");
    }

    static
    {
        System.out.println("static Block");
      
    }


}

public class Static {

    public static void main(String[] args) {
        System.out.println("Main Method");
        System.out.println("static variable : "+(staticData.likes));
        staticData.display();
    }
}