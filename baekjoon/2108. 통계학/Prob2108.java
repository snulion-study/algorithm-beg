package source.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prob2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] array = new int[num];
        for(int i = 0; i <num; i++)
            array[i] = Integer.parseInt(br.readLine());
//        sort(array, 0, array.length-1);
        Arrays.sort(array);
        System.out.println(average(array));
        System.out.println(array[array.length/2]);
        System.out.println(many(array));
        System.out.println(array[array.length-1]-array[0]);

    }
    static int average(int[] a){
        int sum = 0;
        for(int i=0; i < a.length; i++)
            sum+=a[i];
        return (int)Math.round((double)sum/a.length);
    }

    static void sort(int[] a, int l, int r){
        int mid = l+r/2;
        swap(a, mid, r);
        int k = partition(a, l-1, r+1, a[r]);
        swap(a, k, r);
        if((k-l)>1) sort(a, l, k-1);
        if((r-k)>1) sort(a, k+1, r);
    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int partition(int[] arr, int l, int r, int target){
        do{
            while(arr[++l] < target);
            while(arr[--r] > target);
            swap(arr, l ,r);
        }while(l < r);
        swap(arr, l, r);
        return l;
    }

    static int many(int[] arr){
        if(arr.length == 1)
            return arr[0];
        int[] res = new int[arr[arr.length-1] - arr[0]+1];
        for(int i = 0; i< arr.length; i++){
            res[arr[i]-arr[0]]++;
        }
        int max = 0;
        for(int i = 0; i < res.length; i++){
            if(res[i] > max)
                max = res[i];
        }

        int count = 0;
        for(int i = 0; i< res.length; i++){
            if(res[i]==max){
                count++;
                if(count==2)
                    return i+arr[0];
            }
        }

        for(int i = 0; i<res.length; i++)
            if(res[i] == max)
                return i+arr[0];
        return arr[0];
    }
}
