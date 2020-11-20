package source.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob10814 {
    static pair[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        pair[] arr = new pair[num];
        temp = new pair[num];
        for(int i = 0; i < num; i++){
            String temp = br.readLine();
            arr[i] = new pair(Integer.parseInt(temp.split(" ")[0]), temp.split(" ")[1]);
        }

        sort(arr, 0, arr.length-1);
        print(arr);
    }

    static void sort(pair[] arr, int l, int r){
        int i, j, k, mid = (l+r)/2;
        if(l == r) return;
        sort(arr, l, mid);
        sort(arr, mid+1, r);
        for(i=l ; i<=r; i++)
            temp[i] = arr[i];
        int l1= l; int l2 = mid+1;
        for(int curr = l; curr<=r ; curr++){
            if(l1 == mid+1)
                arr[curr] = temp[l2++];
            else if(l2 > r)
                arr[curr] = temp[l1++];
            else if(temp[l1].age <= temp[l2].age)
                arr[curr] = temp[l1++];
            else
                arr[curr] = temp[l2++];
        }

    }
    static void print(pair[] arr){
        for(int i = 0; i < arr.length; i++)
            System.out.printf("%d %s\n", arr[i].age, arr[i].name);

    }

    static class pair {
        int age;
        String name;

        pair(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
}
