package source.backjoon;


import java.util.LinkedList;
import java.util.Scanner;

public class Prob3190 {
    static class snake{
        int x;
        int y;

        snake(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int xpos;
    static int ypos;
    static int size;
    static int dir=1;

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        size = stdIn.nextInt();
        int[][] map = new int[size][size];


        int count = 0;
        boolean status = true;

        int numa = stdIn.nextInt();
        for(int i = 0; i<numa; i++){
            int y = stdIn.nextInt();
            int x = stdIn.nextInt();
            map[y-1][x-1] = 1;
        }

        map[0][0] = 2;

        xpos = ypos = 0;
        LinkedList<snake> S = new LinkedList<>();
        S.add(new snake(0,0));

        int numb = stdIn.nextInt();
        for(int i = 0; i < numb; i++){
            int time = stdIn.nextInt();
            char cmd = stdIn.next().charAt(0);
            for(; count < time; count++){
                System.out.println("count: " + count);
                print(map);
                if(move()){
                    if(map[ypos][xpos] == 2) {
                        System.out.println(count+1);
                        return;
                    }
                    S.addLast(new snake(xpos, ypos));
                    if(map[ypos][xpos] == 1) {
                        map[ypos][xpos] = 2;
                    } else{
                        map[ypos][xpos] = 2;
                        snake tail = S.removeFirst();
                        map[tail.y][tail.x] = 0;
                    }
                } else {
                    System.out.println(count+1);
                    return;
                }
            }
            changeDir(cmd);
        }

        while(true){
            if(move()){
                count++;
                if(map[ypos][xpos] == 2){
                    System.out.println(count);
                    return;
                }
            } else{
                System.out.println(count+1);
                return;
            }
        }
    }

    public static boolean move(){
        if(dir == 0){
            ypos--;
        } else if(dir == 1){
            xpos++;
        } else if(dir == 2){
            ypos++;
        } else
            xpos--;
        return xpos >= 0 && ypos >= 0 && xpos < size && ypos < size;
    }

    public static void changeDir(char cmd){
        if(cmd == 'D'){
            dir = (dir+1)%4;
        } else{
            if(dir == 0)
                dir = 3;
            else
                dir = (dir-1)%4;
        }
    }

    public static void print(int[][] map){
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }

}
