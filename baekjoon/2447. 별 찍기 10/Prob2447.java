package source.backjoon;

import java.util.Scanner;

public class Prob2447 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int num = stdIn.nextInt();
        System.out.println(print(num));

    }

    static String print(int num){
        String blank = "";
        for(int i = 0; i < num/3; i++){
            blank += " ";
        }

        if(num == 3)
            return "***" + "\n" + "* *" + "\n" + "***";
        else{
            StringBuilder sb = new StringBuilder();
            String temp = print(num/3).toString();
            for(int i = 0; i <num ; i++){
                if( i < num/3 || i >= num*2/3) {
                    sb.append(temp.split("\n")[i % (num / 3)]);
                    sb.append(temp.split("\n")[i % (num / 3)]);
                    sb.append(temp.split("\n")[i % (num / 3)]);
                }

                else{
                    sb.append(temp.split("\n")[i % (num/3)]);
                    sb.append(blank);
                    sb.append(temp.split("\n")[i % (num/3)]);

                }
                sb.append('\n');
            }
            return sb.toString();
        }
    }
}
