package Array;

class OneD {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        int max=0;
        int min=arr[0];

        for (int i : arr) {
            if(i>max){
                max=i;
            }else if(min<i){
                min=i;
            }
        }
        System.out.println("Max is : "+max);
        System.out.println("Min is : "+min);
    }
}
