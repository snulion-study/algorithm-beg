# 5장 재귀 알고리즘(2/2) (p178-p196)
  
  ## 목차 
  1. 하노이의 탑(178p)
      - 재귀를 이용한 풀이
      - 다른 방법을 이용한 풀이
  
  2. 8퀸 문제(183p)
      - 퀸 배치하기
      - 가지 뻗기
      - 분기 한정법
      - 8퀸 문제를 푸는 프로그램
      
  ### 하노이의 탑
  - 재귀를 이용한 풀이
  ```java
  import java.util.Scanner;
  
  class Hanoi {
    static void move(int no, int x, int y){
    if(no > 1)
      move(no-1, x, 6-x-y);  // 1. 맨 아래 원반을 제외한 원반을 임시 6-x-y 기둥으로 옮김.
    
    System.out.printl("원판[" + no + "]을 " + x + "기둥에서 " + y "기둥으로 옮김");  // 2. 맨 아래 원반을 최종 기둥으로 옮김.
    
    if(no > 1)
      move(no -1, 6-x-y, y);  // 3. 1에서 임시 기둥으로 옮긴 n-1 개의 원반을 최종 기둥으로 옮김.
    }
    
    public static void main(String[] args){
      Scanner stdIn = new Scanner(System.in);
      
      System.out.println("하노이의 탑");
      System.out.print("원반 개수 : ");
      int n = stdIn.nextInt();
      
      move(n, 1, 3);
      }
  }
  ```
  하노이의 탑의 재귀적 문제를 해결하는 키워드는 3가지 동작이 반복된다는 점에서 접근을 해야한다.  
  
  재귀적 알고리즘을 짜는 가장 쉬운 방법이지만 핵심적인 과정은 '어떤 과정이 반복되는가'를 찾아내는것에서 시작한다.  
  
  
  - 다른 방법을 이용한 풀이  
  <a href="https://www.geeksforgeeks.org/iterative-tower-of-hanoi/">Stack을 이용한 풀이</a>도 참고하면 좋을것 같습니다!  
  이번 주제는 재귀라 자세하게 다루지는 않겠습니다!
  
  ### 8퀸 문제
  - 퀸 배치하기  
  
    - 8*8 체스판에 8개의 퀸을 배치하는 방법 : 64C8 = 4,426,165,368가지   
    - 8*8 체스판에 8개의 퀸을 각 열또는 행에 하나씩 배치하는 방법 : 8^8 = 16,777,216가지 
    - 8*8 체스판에 8개의 퀸을 각 열과 행에 하나씩 배치하는 방법: 8! = 40,320가지 (8룩 문제)  
    - 8*8 체스판에 8가지 퀸을 각 열과 행, 대각선에 하나씩 배치하는 방법: 92가지 (8퀸 문제)  
    
  - 가지 뻗기 
  
  가장 기본적인 케이스에서 하나씩 조건을 추가하면서 원하는 목적을 달성하는 방법으로 문제를 해결하자.  
  
  가장 기본적인 케이스: 1~8까지의 수를 00000000부터 77777777까지 배열하는 방법을 생각해보자  
  
  1. 8개의 for문을 이용하는 방법  
  ```java
  int[] array = new int[8];
  for(int i = 0; i < 8 ; i++)
    for(int j = 0; j < 8; j++)
      for(int k = 0; k < 8; k++)
        ...
          for(int p = 0; p < 8 ; p++)
  ```
  가장 직관적인 풀이 방법일 수 있으나, 너무 많은 반복문을 사용하며, 8개에서 9개로 바꾸는경우 for문을 매번 추가해주어야함.  
    
  2. 재귀 알고리즘을 이용하는 방법
  ```java
  class QueenB{
    static int[] pos = new int[8]

    static void set(int index){
      for(int j = 0; j < 8; j++){
        pos[index] = j;
        if(index == 7)
          print();
        else
          set(index+1);
      }
    }

    public static void main(String[] args){
      set(0);
    }
  }
  ```
    
  이 재귀문의 구성을 정확하게 이해하면, 이어지는 재귀문도 무리 없이 이해할 수 있다. 다만 아쉬운점은 책에서는 i와 j라는 변수명을 사용하였는데, 위와같이 i대신 index 혹은 depth라는 변수명을 사용하였으면 훨씬 더 쉽게 이해되지 않았을까 하는 생각이다.  

  두가지 변수 index와 j의 역할을 이해하는 것이 중요하다.  

  index는 말 그대로 결과를 담을 pos 배열의 index를 의미한다. set이라는 메서드를 재귀적으로 호출할 때, index를 하나씩 키워서 호출함을 알 수 있는데, 이는 말 그대로 다음 index에 값을 저장하기 위함이라고 할 수 있다.  

  위 재귀 함수의 탈출 조건이 되는 if문을 살펴보면, index가 7, 즉 pos 배열의 마지막까지 채우고 난 뒤에 print 메서드를 이용하여 pos 배열을 출력함을 알 수 있다.  
  그렇지 않았을 경우(index가 7미만이라, pos배열을 끝까지 채우지 못하였을 경우에는), 다음 index를 채우기 위한 set 메서드를 실행한다.  

  j는 0부터 8까지의 값을 pos배열에 담아주는 역할을 한다, 각 index별로 0부터 7까지의 값을 할당해준다.  

  ```java
  static void set(int index){
    if(index == 8)
      print();
    else{
      for(int j = 0; j < 8; j++){
        pos[index] = j;
        set(index + 1);
      }
    }
   ```

   따라서, 위와같이 set 메서드를 바꾸어도 결과적으로는 같은 동작을 하게됨을 알 수 있다.  

   - 분기 한정법  
   ```java
   class QueenBB {
     static boolean[] flag = new boolean[8];
     static int[] pos = new int[8];

     static void set(int index){
      for(int j = 0; j<8; j++){
        if(flag[j] == false){
          pos[index] = j;
          if(index == 7)
            print();
          else{
            flag[j] = true;
            set(index + 1);
            flag[j] = false;
          }
        }
      }
     }
     
     public static void main(String[] args){
      set(0);
     }
   }
   ```
   
   이때 flag라는 boolean배열은 같은 '행'에 두개 이상의 퀸이 배치되지 못하도록 하는 역할을 한다.  
   
   따라서, 위의 코드를 실행하면, 40,320가지수의 8룩 문제를 해결할 수 있지만, 아직 8퀸 문제를 해결할 수는 없다.  
   
   하지만 행에 중복되는 숫자가 오는 것을 막는 방법을 위에서 도입했으니, 이를 응용하면, 대각선도 생각보다 쉽게 제어할 수 있다.  
   
   ```Java
   class EightQueen {
     static boolean[] flag_a = new boolean[8];
     static boolean[] flag_b = new boolean[8];
     static boolean[] flag_c = new boolean[8];
     static int[] pos = new int[8];
     
     static void set(int index){
       for(int j = 0; j < 8; j++){
         if(flag_a[j] == flase && flag_b[j+index] == false && flag_c[index-j+7] == false){
           pos[index] = j;
           if(j == 7)
             print();
           else{
             flag_a[j] = flag_b[j+index] = flag_c[index-j+7] == true;
             set(index + 1);
             flag_a[j] = flag_b[j+index] = flag_c[index-j+7] == false;
           }
         }
       }
     }
     
    public static void main(String[] args){
      set(0);
    }
   }
   ```
   
   /모양 대각선과, \모양 대각선이 x, y 좌표에 따라 어떤 관계가 있는지 유추하여, flag_b와 flag_c에 적절한 자리를 true로 표시한다면, 8퀸 문제를 해결 할 수 있다.  
   
   - Q9) 8퀸 문제를 비재귀적으로 구현한 프로그램을 작성하세요.  
   ```java
   class EightQueenN {
    static boolean[] flag_a = new boolean[8];
    static boolean[] flag_b = new boolean[15];
    static boolean[] flag_c = new boolean[15];
    static int[] pos = new int[8]; // 각 열의 퀸의 위치

    // 체스판(각 열의 퀸의 위치)을 출력
    static void print() {
      for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++)
          System.out.printf("%s", j == pos[i] ? "■" : "□");
        System.out.println();
      }
      System.out.println();
    }

    // i열의 알맞은 위치에 퀸을 배치
    static void set(int i) {
      int j;
      int[] jstk = new int[8];

      Start: while (true) {
        j = 0;
        while (true) {
          while (j < 8) {
            if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]) {
              pos[i] = j;
              if (i == 7) // 모든 열에 배치 마침
                print();
              else {
                flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                jstk[i++] = j; // i 열의 행을 Push
                continue Start;
              }
            }
            j++;
          }
          if (--i == -1)
            return;
          j = jstk[i]; // i 열의 행을 Pop
          flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
          j++;
        }
      }
    }

    public static void main(String[] args) {
      set(0);
    }
  }
  ```
  
