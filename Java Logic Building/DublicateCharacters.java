public class DublicateCharacters {

    public static void main(String[] args) {
        String str = "programming";
        int[] fre = new int[26];

        for (char ch : str.toCharArray()) {
            fre[ch - 'a']++;
        }

        System.out.println("Dublicate Characters : ");
        for (int i = 0; i < 26; i++) {
            if (fre[i] > 1) {
                System.out.println((char) (i + 'a') + " -> " + fre[i] + " times");
            }
        }


                    // I notice this logic applies only lowercase string 

    }
}