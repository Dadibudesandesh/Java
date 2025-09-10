import java.util.Arrays;

public class LogicBuilding {


    // display the array/numbers
    public static void display(int[] numbers) {
        for (int k = 0; k < numbers.length; k++) {
            System.out.print(numbers[k] + " ");
        }
    }

    // sort array/numbers
    public static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        System.out.println("Sorted Numbers : ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        System.out.println("Second Minimum Number is : "+numbers[1]);
        System.out.println("Second Maximum Number  is : "+numbers[numbers.length-2]);
    }

    // find the minimum numbers in the array
    public static void min(int[] numbers) {
        int min = 0;
        for (int i = 0; i < numbers.length; i++) {
            min = numbers[0];
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        System.out.println("Minimum Number is : " + min);
    }

    // find the second minimum number       
    public static void secMin(int[] numbers){
        int min=numbers[0];
        int secMin=0;
        for (int i = 0; i < numbers.length; i++) {
            if (min>numbers[i]){
                int temp=min;
                min=numbers[i];
                secMin=temp;
            }
        }
        System.out.println("Second minimum numbers is : "+secMin);
    }

    // find the maximum number in the array
    public static void max(int[] numbers) {
        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            max = numbers[0];
            if (max < numbers[i]) {
                max = numbers[i];
            }
        }
        System.out.println("Maximum Number is : " + max);
    }

    // find the second maximum number
    public static void secMax(int[] numbers) {
        int max=numbers[0];
        int secMax=0;
        for (int i = 0; i < numbers.length; i++) {
            if (max<numbers[i]){
                int temp=max;
                max=numbers[i];
                secMax=temp;
            }
        }
        System.out.println("Second Max : "+ secMax);
    }

    public static void main(String[] args) {

        int[] numbers = {1, 200, 300, 4, 50, 6, 778, 8, 998, 1087};  // declaration of the array
//        max(numbers); // calling max function/method
//        secMax(numbers); // calling secMax numbers
//        min(numbers); // calling min function
//        secMin(numbers);
        sort(numbers);  // calling sort method

//        display(numbers); // calling display method

    }
}
