import java.util.Scanner;

public class FindVowels {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String For Find The Vowels : ");
        String string=sc.next();

        for (int i = 0; i <= string.length()-1 ; i++) {
            char ch=string.charAt(i);
            if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                System.out.println(ch);
            }
        }


    }
}
