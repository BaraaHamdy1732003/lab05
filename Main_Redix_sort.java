import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_Redix_sort {
    public static void main(String[] args) {
        int[] a= {387,468,134,123,68,221,769,37,7};
        redixSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void redixSort(int []arr){
        int maxLength= getMaxNumberOfDigits(arr);
        int d= 1;
        while (maxLength>0){
            d*=10;
            maxLength--;
        }
    }
    private static int getMaxNumberOfDigits(int []arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);

        }
        return (int) Math.log10(max) + 1;
    }



    public static void redixSort_(int []arr){
        List<Integer>[]buckets= new ArrayList[10];
        for (int i = 0; i <buckets.length ; i++) {
            buckets[i]= new ArrayList<Integer>();
        }
        boolean flag= true;
        int tmp , d= 1;
        while (flag){
            for (int item:arr){
                tmp = item/d;
                buckets[tmp% 10].add(item);
                if (tmp>0){
                    flag= true;
                }
            }
            int j = 0;
            for (int i = 0; i <10 ; i++) {
                for (int item : buckets[i]){
                    arr[j++]= item;
                }
                buckets[i].clear();

            }
            d*=10;
        }
    }
}
