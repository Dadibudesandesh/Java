import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String For Revers : ");
        String string=sc.next();
        String rev="";

        for (int i = string.length()-1 ; i >=0 ; i--) {
            rev+= string.charAt(i);
        }
        System.out.println("Reverse String Is : "+rev);
    }
}
