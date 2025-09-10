import java.util.Scanner;

public class FibonacciUsingRecursion {

    public static int fibonacci( int no){
        if (no<=1) return no;
        return fibonacci(no-1) + fibonacci(no-2);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Number For Generate Fibonacci Series : ");
        int no = sc.nextInt();
        System.out.println(fibonacci(no));
    }
}
