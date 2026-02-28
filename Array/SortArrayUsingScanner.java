import java.util.Scanner;

public class SortArrayUsingScanner {
    public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
        int arr[]=new int[10];
	for (int i=0;i<arr.length;i++){
	arr[i]=sc.nextInt();
}


System.out.print("Before Sorting : ");
	for (int i=0;i<arr.length;i++){
System.out.print(arr[i] +" ");
}
System.out.println();


           for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {

			if(arr[i]>arr[j]){

			arr[i]=arr[i]+arr[j];
			arr[j]=arr[i]-arr[j];
			arr[i]=arr[i]-arr[j];

			}
	    }
         }
System.out.print("After Sorting : ");
	for (int i=0;i<arr.length;i++){
System.out.print(arr[i] +" ");
}
     }
}
