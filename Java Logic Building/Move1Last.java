import java.util.Arrays;

public class Move1Last {
    public static void main(String[] args) {
        int[] arr={0,1,2,1,3,1,4};

        int p=0;

        for(int i=0;i<arr.length;i++){
            if (arr[i]!=1) {
                arr[p]=arr[i];
                p++;
            }
        }

        while (p<arr.length) {
            arr[p]=1;
            p++;
        }

        System.out.println(Arrays.toString(arr));
    }
}
