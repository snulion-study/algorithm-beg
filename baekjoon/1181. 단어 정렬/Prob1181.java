package source.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1181{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int tnum = 0;
        String[] array = new String[num];
        for(int i = 0; i <num; i++){
            String temp = br.readLine();
            boolean check = false;
            for(int j = 0; j < i; j++){
                if(array[j] != null && array[j].compareTo(temp)==0){
                    check = true;
                    break;
                }
            }
            if(check == false){
                array[tnum++] = temp;
            }
        }

        String[] resarray = new String[tnum];
        for(int i = 0; i< tnum; i++)
            resarray[i] = array[i];

        qsort(resarray, 0, resarray.length-1);
        for(int i = 1; i < resarray.length; i++){
            for(int j = i; j>0 && resarray[j].length() < resarray[j-1].length(); j-- )
                swap(resarray, j-1, j);
        }

        print(resarray);
    }

    static void qsort(String[] arr, int l, int r){
        int mid = (l+r)/2;
        swap(arr, mid, r);
        int k = partition(arr, l-1, r, arr[r]);
        swap(arr, k, r);
        if((k-l) > 1) qsort(arr, l, k-1);
        if((r-k) > 1) qsort(arr,k+1, r);
    }

    static void swap(String[] arr, int a, int b){
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int partition(String[] arr, int l, int r, String tar){
        do{
            while(arr[++l].compareTo(tar) < 0);
            while((r!=0) && arr[--r].compareTo(tar) > 0);
            swap(arr, l, r);
        } while(l<r);
        swap(arr, l, r);
        return l;
    }

    static void print(String[] arr){
        for(int i = 0; i <arr.length; i++)
            System.out.println(arr[i]);
    }
}
