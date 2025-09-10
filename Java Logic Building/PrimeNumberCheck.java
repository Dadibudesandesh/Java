import java.util.Scanner;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter Number For Checking Number Is Prime : ");
        int num=sc.nextInt();
        boolean isPrime=true;

        for (int i = 2; i <=num/2 ; i++) {
            if (num%i==0){
                isPrime=false;
                break;
            }
        }
        System.out.println(isPrime ? "Number Is Prime" : " Number Is Not Prime Number");
    }
}
