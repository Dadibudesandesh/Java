public class SwapNumbers {
    public static void main(String args[]){
        
        // using three variables

        int temp,a=10,b=20;
        System.out.println("Before Swapping A: "+a+" B: "+b);
        temp=a;
        a=b;
        b=temp;
        System.out.println("After Swapping A: "+a+" B: "+b);
        
        
        
        // Using Two Variables
        
        int c=10,d=20;
        System.out.println("Before Swapping C: "+c+" D: "+d);
        c=c+d;
        d=c-d;
        c=c-d;
        System.out.println("Before Swapping C: "+c+" D: "+d);
        
        
        
        // using Betwise operator
        
        int e=10,f=20;
        System.out.println("Before Swapping E: "+e+" F: "+f);
        e=e^f;
        f=e^f;
        e=e^f;
        System.out.println("After Swapping E: "+e+" F: "+f);
        
        
        // Swapping in one statement
        
        int x=10,y=20;
        
        System.out.println("Before Swapping X: "+x+" : "+y);
        x=(x+y)-(y=x);
        System.out.println("After Swapping X: "+x+" : "+y);


    }
}
