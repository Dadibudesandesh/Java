import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringOperations {
    public static void main(String[] args) {
        String name="sandesh";
        name="mahesh";
        StringBuffer string;

        System.out.println(name);
        System.out.println(name.toUpperCase());
        System.out.println(name.length());
        System.out.println(Arrays.toString(name.getBytes(StandardCharsets.UTF_8)));
        System.out.println(name.toLowerCase());
        System.out.println(name.charAt(1));
        System.out.println(name.substring(3));
        System.out.println(name.concat(" Syryawanshi"));


        string=new StringBuffer("this is a string buffere");

        System.out.println(string);
//        System.out.println(string.reverse());
        System.out.println(string.append(" object"));
        System.out.println(string.length());
        System.out.println(string.insert(31,"/class"));

        System.out.println(string.delete(8,9));



























    }
}
