package sorting;

import java.util.Scanner;

public class No10814 {
    static class Person {
        private int age;
        private String name;
        private int firstIdx;

        Person (int age, String name, int firstIdx) {
            this.age = age;
            this.name = name;
            this.firstIdx = firstIdx;
        }

        int getAge() {return this.age;}
        String getName() {return this.name;}
        int getIdx() {return this.firstIdx;}

        int comp(Person o) {
            if (this.age >= o.getAge()) {
                if (this.age > o.getAge()) return 1;
                else return this.compIdx(o);
            } else return -1;
        }

        int compIdx(Person o) {
            if (this.firstIdx >= o.getIdx()) {
                if (this.firstIdx > o.getIdx()) return 1;
                else return 0;
            } else return -1;
        }
    }

    static void swap(Person[] arr, int id1, int id2) {
        Person temp = arr[id1];
        arr[id1] = arr[id2];
        arr[id2] = temp;
    }

    static void quick(Person[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        Person m = arr[(pl+pr)/2];
        do {
            while (arr[pl].comp(m) < 0) pl++;
            while (arr[pr].comp(m) > 0) pr--;
            if (pl <= pr) {
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) quick(arr, left, pr);
        if (right > pl) quick(arr, pl, right);
    }


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        Person[] persons = new Person[n];

        for (int i = 0; i < n; i++) {
            String line0 = stdIn.next();
            String line1 = stdIn.next();
            persons[i] = new Person(Integer.parseInt(line0), line1, i);
        }
        quick(persons, 0, n-1);
        for (int i = 0; i < n; i++)
            System.out.println(persons[i].getAge() + " " + persons[i].getName());
    }
}
