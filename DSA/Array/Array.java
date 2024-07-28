import java.util.Scanner;

public class Array {
    public static int[] accessArray(int[] numbers, Scanner sc,int range) {
        System.out.print("Enter "+ range+"  numbers : ");
        for (int i = 0; i < range; i++) {
            numbers[i] = sc.nextInt();
        }
        return numbers;
    }

    public static void printArray(int[] numbers) {
        System.out.print("\nArray is :  ");
        for (int i = 0; i < 5; i++) {
            System.out.print(" " + numbers[i]);
        }
    }

    public static int[] findOdd(int[] numbers) {

        int oddCount = 0;
        // this for loop calculate the number of odd numbers in array
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                oddCount++;
            }
        }
        // this for loop store the odd number from numbers array to result array.
        int[] result = new int[oddCount];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                result[index] = numbers[i];
                index++;
            }
        }

        return result;
    }

    public static void reverseArray(int[] numbers, int start, int end) {

        while (start < end) {
            numbers[start] = numbers[start] ^ numbers[end];
            numbers[end] = numbers[start] ^ numbers[end];
            numbers[start] = numbers[start] ^ numbers[end];
            start++;
            end--;
        }
    }

    public static int findMin(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int findSecMax(int[] numbers) {
        int max = 0;
        int secMax = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                secMax = max;
                max = numbers[i];
            } else if (numbers[i] > secMax && numbers[i] != max) {
                secMax = numbers[i];
            }
        }

        return secMax;
    }

    public static void moveZero(int[] numbers) {
        int j = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0 && numbers[j] == 0) {

                numbers[i] = numbers[i] ^ numbers[j];
                numbers[j] = numbers[i] ^ numbers[j];
                numbers[i] = numbers[i] ^ numbers[j];
            }
            if (numbers[j] != 0) {
                j++;
            }
        }
    }

    public static int[] reSize(int[] arr, int capacity) {
        int[] temp = new int[capacity];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }

    public static void findMissValue(){
        int sum=0;
        int[] arr=new int[] {1,3,4,5,6,7,8};
        int range=arr.length+1;
        for (int i : arr) {
            sum+=i;
        }
        // for(int i=0;i<arr.length;i++){
        //     range=arr[i];
        //     if(range<arr[i]){
        //         range=range^arr[i];
        //         arr[i]=range^arr[i];
        //         range=range^arr[i];
        //     }
        // }
        int total=range*(range+1)/2;
       System.out.println("Misiing value is : "+ (total-sum));
       
    }

    public static boolean isPalindrome(String word){
        char[] charArray=word.toCharArray();
        int start=0;
        int end=word.length()-1;
        while (start<end) {
            if (charArray[start]!=charArray[end]) {
                return false;
            }
            start++;
            end--;

        }
        return true;
    }

    public static void main(String[] args) {

        // String[] numbers;
        // numbers = new String[5];

        // O R

        // String[] numbers = {"sandesh","shubham","rushikesh","rakesh"};

        // O R
        // int range=0;
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter Lenght of array : ");
        // range=sc.nextInt();
        // int[] numbers = new int[range];

        // Access the input from user using accessArray() method passing two parameters
        // array name and scanner object
        // accessArray(numbers, sc,range);

        // Dispay the input data using printArray() method passing parameter numbers[]
        // array.
        // printArray(numbers);

        // returns odd numbers in numbers[] array.
        // System.out.print("ODD numers : ");;
        // System.out.print(findOdd(numbers)[0]);;
        // System.out.print(findOdd(numbers)[1]);;
        // System.out.print(findOdd(numbers)[2]);;

        // reverse the array.
        // reverseArray(numbers,0,numbers.length-1);
        // printArray(numbers);

        // finding minimum number in array
        // System.out.println("\nMinimum number is : "+ findMin(null)); // when you pass
        // the null argument
        // System.out.println("\nMinimum number is : "+ findMin(numbers));

        // findiing second maximum value in array
        // System.out.println("\n Second max number is : " + findSecMax(numbers));

        // Move all zeros on last position
        // moveZero(numbers);
        // printArray(numbers);

        // resize array
        // int[] arr = new int[5];
        // System.out.println("size of array  : "+arr.length);
        // arr = reSize(arr, arr.length * 2);
        // System.out.println("size of array after resize : "+arr.length);


        // find the missing number in array
        // findMissValue();


        // find given sting is palindrome or not
        // System.out.println(isPalindrome("madam"));
        // if (isPalindrome("mahesh")) {
        //     System.out.println("Is Palindrome");
        // }else{
        //     System.out.println("Not Palindrome");
        // }
    }
}