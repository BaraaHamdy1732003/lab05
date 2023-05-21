//for counting sort
 import java.util.Arrays;
import java.util.Random;

public class CountingSort {

    public static void main(String[] args) {
        int a[]=new int [10];
        setRandomValues(a,0,10);

        System.out.println(Arrays.toString(a));

        countingSort_(a);
        System.out.println(Arrays.toString(a));

    }

    public static void setRandomValues(int []arr,int a, int b){
        Random rnd = new Random();
        for (int i = 0; i <arr.length ; i++) {
            arr[i]= rnd.nextInt(a,b);

        }

    }

    public static void countingSort_(int []arr){

        int max= arr[0];
        for (int i = 0; i <arr.length ; i++) {
            max=Math.max(arr[i],max);

        }

        int []count = new int[max+1];
        for (int a:arr){
            count[a]++;

        }

        int j =0;
        for (int a = 0;a<count.length;a++){
            for (int i = 0; i <count[a] ; i++) {
                arr[j++]=a;

            }
        }




    }
    public static void countingSort(int []arr){
        int max= arr[0];
        for (int i = 0; i <arr.length ; i++) {
            max= Math.max(arr[i],max);
        }
        int []c=new int [max+1];
        for (int a :arr){
            c[a]++;
        }
        for (int i = 0; i < c.length; i++) {
            c[i]+=c[i-1];
        }
        int []b = new int [arr.length];
        for (int i = arr.length-1;i>=0;i--) {
            b[c[arr[i]]-1]= arr[i];
            c[arr[i]]--;
        }
        System.arraycopy(b,0,arr,0,b.length);
    }

}
