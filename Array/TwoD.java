import java.util.Scanner;


class TwoD {
    public static void main(String[] args) {
 
	Scanner sc=new Scanner(System.in);

	int row,col;
	System.out.print("Enter Row Size : ");
	row=sc.nextInt();
	System.out.print("Enter Column Size : ");
	col=sc.nextInt();

  	int arr[][]=new int[row][col];


System.out.print("Enter Elements : ");
	for(int i=0;i<arr[0].length;i++){
		for(int j=0;j<arr[0].length;j++){
			arr[i][j]=sc.nextInt();
		}
		System.out.println();
		if(i==0){
			System.out.println(i+1+"st Row Compeleted...!");
		}else if(i==1){
			System.out.println(i+1+"nd Row Compeleted...!");
		}else if(i==2){
			System.out.println(i+1+"rd Row Compeleted...!");
		}
	}

for(int i=0;i<arr[0].length;i++){
		for(int j=0;j<arr[0].length;j++){
			System.out.print(arr[i][j]+" ");
		}
		System.out.println();
	}

    }
}
