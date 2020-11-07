import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prob10814 {

    static class Person {
        int age;
        String name;
        int order;

        public Person(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int memberCount = Integer.parseInt(br.readLine());

        Person[] personList = new Person[memberCount];

        for (int i = 0; i < memberCount; i++) {
            String[] person = br.readLine().split(" ");
            int age = Integer.parseInt(person[0]);
            String name = person[1];
            personList[i] = new Person(age, name, i);
        }

        Arrays.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.age > o2.age) {
                    return 1;
                } else if (o1.age == o2.age) {
                    if (o1.order > o2.order) {
                        return 1;
                    }
                    else {
                        return 0;
                    }
                } else {
                    return -1;
                }
            }
        });

        for (Person p : personList) {
            System.out.println(p.age + " " + p.name);
        }
    }
}
