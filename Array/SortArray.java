

public class SortArray {
    public static void main(String[] args) {
        int arr[]={11,12,13,17,16,15,14,18,19,20};

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
