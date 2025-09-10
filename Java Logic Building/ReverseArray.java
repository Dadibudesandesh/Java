public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
//        System.out.println("Reverse Array : "+java.util.Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
}
