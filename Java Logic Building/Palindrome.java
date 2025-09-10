import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number For Check Palindrome : ");
        int num = sc.nextInt();
        int rev = 0, temp = num;

        while (temp != 0) {
            int digit = temp % 10;
            System.out.println("digit : "+digit);
            rev=rev*10+digit;
            System.out.println("rev : "+rev);
            temp/=10;
            System.out.println("temp : "+temp);
        }

        if (num==rev) System.out.println("Number Is Palindrome...!");
        else System.out.println("Number Is Not Palindrome");
    }
}
