# 2장 기본 자료구조 (p41-p89)
  
  ## 목차 
  1. 배열(42p)
      - 자료구조
      - 배열
      - 배열 요소의 최댓값 구하기
      - 배열 요소를 역순으로 정렬하기
      - 두 배열의 비교
      - 기수 변환
      - 소수의 나열
      - 다차원 배열
      - 한 해의 경과 일 수를 계산하는 프로그램
      - 다차원 배열의 내부
  
  2. 클래스(89p)
      - 클래스란?
      - 클래스의 배열
  
  ### 자료구조
  > 데이터 단위와 데이터 자체 사이의 물리적 또는 논리적인 관계

  
  ### 배열
  배열은 자료구조의 일부이며, 동일한 자료형의 구성요소(Component)로 이루어진 것이다.  
  Java에서 배열을 선언하는 방식은 다음 두가지 방식을 따른다.
  
  ```java
  int[] a; //형식 A  
  int a[]; //형식 B  
  ```
  두 선언 모두 'int자료형을 가지는 배열을 참조하는 변수 a를 선언'하며, 형식 A 방식을 더 선호한다.
  
  ```
  a = new int[5] //
  ```
  선언을 통하여 '참조변수 a에 길이가 5인 int자료형의 배열 주소값을 할당'한다.  
  Java에서는 배열의 길이가 0인 배열을 생성할 수 있으며, 초기화 하지 않은 배열은 자료행에 따라 다음의 값으로 초기화 된다.
  
  |형|초깃값|
  |:---:|:---:|
  byte|(byte)0
  short|(short)0
  int|0
  long|0L
  float|0.0f
  double|0.0d
  char|'\u0000'
  boolean|false
  참조형|공백 참조 또는 null
  
  ### Question

<details><summary>int형 배열, int[]는 원시타입일까 참조타입 일까?</summary>
<p>

  원시타입과 참조타입을 구분하는 좋은 방법중에 하나는, null값을 가질 수 있는지 없는지로 판단하는 것이다!  
  원시타입은 null값을 가질 수 없고, 참조타입은 null값을 가질 수 있다...  

```java
int[] a = null; // 참조타입인 배열을 참조하는 변수a를 null값으로 초기화 하는것은 가능하지만,  
int b = null; // 원시타입인 int형 변수에 null값으로 초기화를 하는것은 불가능하다.  
```

자세한사항은 다음 참고
<a>http://net-informations.com/faq/general/valuetype-referencetype.htm</a>

</p>
</details>

 배열은 다음과 같이 선언과 함께 초기화 할 수도, 선언 후 초기화 할 수도 있다!  
 다만 선언과 함께 초기화 할때 배열의 길이와 요소를 동시에 입력하면 에러가 발생한다는점 유의하자.
 
```java
int[] arr1 = new int[4]; //배열의 길이로 초기화하는 방법
int[] arr2 = new int[]{1,2,3,4} //배열의 요소로 초기화하는 방법
int[] arr3 = new int[4]{1,2,3,4} //두가지 혼합사용시 다음의 에러 발생!
             java: array creation with both dimension expression and initialization is illegal
```
  
 ### 배열의 복제  
  다음 두가지 방법의 차이점은 무엇인지 생각해보자

```java
int[] a = new int[]{1,2,3,4,5};
int[] b = a;
int[] c = a.clone();

a[1] = 8;

System.out.println(a[1]);  // 당연히 8
System.out.println(b[1]);  // ??  정답은
System.out.println(c[1]);  // ??  생각해보자
```

### 배열 요소의 최댓값 구하기  
  어렵지않다.
  
### 난수 사용해 배열의 요솟값 설정하기  
  요솟값 설정하는 정도는 그리 어렵지 않다! 따라서 java에서 난수를 설정하는 두가지 방법을 이야기 하고자 한다.
  
  첫번째 방법 - Random class를 import하여 사용
  ```java
  import java.util.Random
  ...
  중략
  ...
  
  Random rand1 = new Random() // parameter를 비워둘 경우 임의의 seed가 설정됨.
  Random rand2 = new Random(1) // seed를 원하는 수로 지정하여 생성할 수도 있음.
  
  
  int num1 = rand1.nextInt(); -214783648 ~ +2147483647 의 임의의 정수값 생성
  int num2 = rand1.nextInt(10); 0~9 의 임의의 정수값 생성
  ```
  
  두번째 방법 - java.lang.Math class 사용
  ```java
  double num2 = Math.random(); // 기본 Math.random()은 0~1 사이의 임의의 수를 return 한다.
  int num1 = (int)(Math.random()*10); // 위와같이 원하는 0~n-1 범위의 자연수를 추출하고자 할때는 다음과 같이 선언해준다.
  ```

위 두가지 방법중 편한것을 사용하면 될듯 하나, 다음 글을 참고하면 첫번째 방법이 더욱 우수한 방법이라고 한다...  
자세한 이야기는 다음을 참고하자
https://stackoverflow.com/questions/738629/math-random-versus-random-nextintint

### 배열 요소를 역순으로 정렬하기
### 두 값의 교환
### 두 배열의 비교  
  이정도는 충분히 할수있다.
  
  #### 연습문제 Q6
  > 배열의 앞쪽에 아랫자리가 아니라 윗자리를 넣어두는 메서드를 작성하세요
  >
  >         static int cardConv(int x, int r, char[] d)
<details><summary>좋은 방법이 없을까?</summary>
<p>
1. 첫번째 방법 : 역순으로 받은 다음 배열을 역순으로 재정렬 (실습 2-8A 방법)<br>
2. 두번째 방법 : 몇자리일지 먼저 계산한다음(배열의 크기를 정해두고), 뒤에서부터 값 지정<br>
3. 세번째 방법 : 저는 두개밖에 모르겠어요
</p>
</details>

 ### 소수의 나열  
 #### version1
 
 ```java
 //version 1 -원시적인 방법, 모든 수를 일일이 나누는 과정을 거치게 되어
 // n = 1000일때 총 나눗셈 시행 횟수 78022회 0.011초
 // n= 10000일때 총 나눗셈 시행 횟수 5775223회 0.027초
 
 class PrimeNumber1{
  public static void main(String[] args){
     int counter = 0;
     
     for(int n = 2; n<=1000; n++){
      int i;
      for(i = 2; i< n ; i++){
        counter++;
        if(n % i == 0)
          break;
      }
      if(n==1)
        System.out.println(n)
    }
    
    System.out.println("나눗셈을 수행한 횟수 : " + counter);  // println의 parameter내부에서 String과 변수는 + 기호를 통하여 연결할 수 있다! Javascript와 유사
    //System.out.print("나눗셈을 수행한 횟수 : " + counter);  위와 동일하나, 출력후 줄바꿈이 되지 않는 print방식
    //System.out.printf("나누셈을 수행한 횟수 : %d %n", counter); format형식으로 출력해도 된다. 줄바꿈을 하려면 \n 혹은 %n을 String안에 넣어준다.
  }
}
```  
---
#### version2
```java
//version2 - 개선된 알고리즘, n보다 작은 소수로만 나눠보고 판단함
// n = 1000일때 총 나눗셈 시행 횟수 14622회  0.009초
// n = 10000일때 총 나눗셈 시행 횟수 766633회 0.015초

class PrimeNumber2{
    public static void main(String[] args){
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[5000];

        prime[ptr++] = 2;

        for(int n = 3; n<=10000 ; n+=2){
            int i;
            for(i = 1 ; i<ptr; i++){
                counter++;
                if(n%prime[i] == 0)
                    break;
            }
            if(ptr == i)
                prime[ptr++] = n;
        }

        System.out.println("나눗셈을 수행한 횟수 : " + counter);
    }
}
```
---
#### version3  
```java
// version3 - 추가적으로 개선된 알고리즘, 에라토스테네스의 채 원리를 충분히 적용한 알고리즘
// n = 1000일때 총 나눗셈 시행 횟수 3774회 0.007
// n = 10000일때 총 나눗셈 시행 횟수 68739회 0.01초
public class PrimeNumber3 {
    public static void main(String[] args) {
        int counter = 0;
        int ptr = 0;
        int[] prime = new int[5000];

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for(int n = 5; n <= 1000; n+=2){
            boolean flag = false;
            for(int i =1; prime[i]*prime[i] <= n; i++){
                counter +=2;
                if(n%prime[i] == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                prime[ptr++] = n;
                counter ++;
            }
        }

        System.out.println("곱셈과 나눗셈을 수행한 횟수: " + counter);
    }
}
```

<details><summary>시간 측정</summary>
<p>

  프로그램을 시작할때의 시간과, 끝날때의 시간을 기록하여 두 시간의 차를 계산하는 방식으로 측정하였다...

```java
// 시작 부분에 아래처럼 현재 시간을 계산하고
long start = System.currentTimeMillis();

// 프로그램 본문

// 끝에 아래와 같이 삽입
long end = System.currentTimeMillis();
System.out.println( "실행 시간 : " + ( end - start )/1000.0 );
```

</p>
</details>

### 다차원배열  
> 배열을 구성요소로 하는 배열  
> ex) ''int형을 구성 자료형으로 하는 배열'을 구성 자료형으로 하는 배열'

### Question
<details><summary>2차원배열또한 .clone() 매서드로 복제할 수 있을까?</summary>
<p>

```java  
int[][] x = {{1,2,3},{4,5,6}};
int[][] y = x;
int[][] z = x.clone();

x[0][0] = 99; // x[0][0]인 1을 99로 바꿨을때 y와 z의 [0][0]값은 어떻게될까?

System.out.println(x[0][0]);  // 당연히 99
System.out.println(y[0][0]);  // ??  정답은
System.out.println(z[0][0]);  // ??  생각해보자

```

shallow copy와 deep copy에 대한 사항은 다음 참고
<a>https://stackoverflow.com/questions/1564832/how-do-i-do-a-deep-copy-of-a-2d-array-in-java</a>
</p>


</details>

### 확장 for문  
python의 for in, javascript의 for in 문법과 유사하며, 타입을 지정해줘야함  
```java
int[] a= {1,2,3,4,5};
for(int i : a) // 변수 a는 int형의 배열을 저장한 값이므로, 변수 i의 타입을 int로 지정해준다.
  System.out.printf("%3d", i); // 출력값: 1 2 3 4 5
// i는 a의 index를 나타내는것이 아니라, 요소값을 나타낸다!
```

### 클래스
> 클래스는 임의의 데이터형을 자유로이 조합하여 만들 수 있는 자료구조이다.  
 
클래스는 필드, 생성자, 메서드로 구성되며, 클래스의 종류에 따라 공개 클래스, final 클래스, 파생 클래스, 추상 클래스, 중첩 클래스로 나뉜다 

#### 필드  
클래스가 가지고 있는 데이터 요소들을 의미하여, 다양한 타입의 필드를 가질 수 있다.
```java
class XYZ{
  int x;
  boolean y;
  double z;
 }
 ```
 
 #### 생성자  
 클래스를 생성하는 규칙을 나타내는 부분이며, overloading을 통하여 다양한 생성자를 가질 수 있다.  
 ```java
 class XYX{
  int x;
  boolean y;
  double z;
  
  XYZ(int x){
    this.x = x;  // XYZ obj = new XYZ(3)과 같은 방식으로 선언되었을때, obj변수가 참조하는 인스턴스의 x값을 3으로 초기화시킴
  }
  
  XYZ(){ // 생성자를 지정하지 않았을 경우, 컴파일 과정에서 기본적으로 생성되는 생성자
  }
  
 }
 ```
 
 #### 클래스의 배열  
 클래스를 배열로 가질 수 있다!  
 
 ```java
 XYZ[] objects = new XYZ[] // XYZ 인스턴스를 배열로 가지는 objects라는 참조변수 선언
 ```

 위와같이 클래스를 배열로 선언하여 사용할경우, 유사한 데이터를 따로따로 관리하는 것이 아니라, 배열로써 효율적으로 관리할 수 있게된다.  
 ex) 100명의 신체검사 데이터를 신체검사 클래스의 배열로 사용하면, 각 사람마다 키, 뭄무게, 시력, 이름과 같은 데이터를 모아서 관리할 수 있게된다.

 ### 중첩 클래스
  <img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile5.uf.tistory.com%2Fimage%2F99DA873B5AC20B79183F1C">  
 
  #### 들어가기전  
  ##### Q1. 중첩클래스란 무엇인가?
  클래스안에 선언된 또 하나의 클래스로써 선언된 위치(종류)에 따라 서로 다른 특징을 가진다.

  ##### Q2. 왜 사용하는가?
  1. 외부 클래스와 내부 클래스가 서로의 멤버에 접근하기 쉽다.  
  2. 외부에는 불필요한 클래스를 은닉함으로써 코드의 복잡성을 줄일 수 있다.
  
  #### 용어 정리
 1. 대표적인 기본서인 '이것은 자바다'에서는 이너 클래스라는 용어를 사용하지 않고 중첩 클래스라는 용어를 이용해 개념을 설명한다. 이너 클래스라는 말은 한번도 나오지 않는다.  
    + 인스턴스 멤버 클래스  
    + 정적 멤버 클래스  
    + 로컬 클래스  
    + 익명 클래스  

 2. 반대로 또다른 기본서 '자바의 정석'에서는 이너 클래스라는 용어만 사용한다.
    + 인스턴스 클래스(instance class)  
    + 스태틱 클래스(static class)  
    + 지역 클래스(local class)  
    + 익명 클래스(anonymous class)  
    
 3. 본 책에서는 다음과 같은 분류로 간단하게 소개되어있다.  
    + 멤버 클래스(member class)  
    + 내부 클래스(inner class)  
    + 지역 클래스(local class)  
    
  이하의 내용은 기본서의 개념에 충실하여 작성하고자, 위 두 기본서의 용어를 사용하여 설명하겠다.  
  
  #### 1. 인스턴스 클래스( 인스턴스 멤버 클래스 in 이것이 자바다 )  
  ```java
  claas A{
    //field
    class B {
                     <= class A의 field 선언부에 선언된 class B는 중첩 클래스 중 '인스턴스 클래스'이다.
    }

    //constructor

    //method
  }
  ```  
위와 같이 인스턴스 클래스는 field 선언부에 위치한다는 점에서 , 2. 스태틱 클래스와 유사하나, static 선언이 없다.  
 + 특징  
    + 외부 클래스(class A)의 '멤버'인 클래스이기 때문에, 외부 클래스의 객체를 생성한 후 내부 클래스의 객체를 생성하여 사용한다.  
    ```java
    class Object{
      int num = 3;
      class Inner{
        int innerNum = 4;
      }
     }
    ```  
    위와 같이 class Object 의 멤버변수인 num에 접근하고자 할때  
    ```java
    Object obj = new Object();
    Object.Inner innerObj = obj.new Inner();
    System.out.println(obj.num); // 3
    System.out.println(innerObj.innerNum) // 4
    ```  
    이렇게 class A를 참조하는 참조변수 a를 생성한후 a.num으로 접근하는것과 같은 논리.  
    obj class의 멤버중 하나인 Inner class를 생성하기 위하여, obj.new Inner()를 사용하여 내부 객체를 생성하였다!! 
    
    + 인스턴스 내부에는 instance member만 선언할 수 있다. (static 선언 불가) 
    
  #### 2. 스태틱 클래스( 정적 멤버 클래스 in 이것이 자바다 )  
  ```java
  claas A{
    //field
    static class B {
                     <= class A의 field 선언부에 선언된 static class B는 중첩 클래스 중 '스태틱 클래스'이다.
    }

    //constructor

    //method
  }
  ```
  + 특징  
    + statc 키워드가 붙은 내부 클래스이기 때문에, 외부 클래스의 객체를 생성하지 않고 내부 클래스의 객체를 생성할 수 있다.
    ```java
    class Object{
      static int num = 3;
      static class Inner{
        int innerNum1 = 4;
        static int innerNum2 = 5;
      }
     }
    ```  
    위와 같이 class Object 의 static member인 num에 접근하고자 할때  
    ```java
    Object obj = new Object(); // 이런 객체 생성과정 없이
    System.out.println(Object.num); // 3 이렇게 접근할 수 있듯,
    Object.Inner innerObj = Object.Inner(); //이렇게 Object객체 생성없이 바로 Inner class 객체 생성가능
    System.out.println(innerObj.innerNum) // 4
    Ststem.out.println(Object.Inner.innerNum2) // 스태틱 클래스 안의 static 변수는 Object, Inner객체 모두 없이 접근가능
    ```  
    
    + 인스턴스 내부에는 instance member(위 코드에서 innerNum1) 와 static member(위 코드에서 innerNum2) 모두 생성가능
    
   #### 3. 지역 클래스( 로컬 클래스 in 이것이 자바다 )
   ```java
    claas A{
      //field

      //constructor

      //method
      void method1(){
        class B {
          int data = 3;             <= class A의 method 선언부의 method 내부에 선언된 class B는 중첩 클래스 중 '지역 클래스'이다.
        }
        
        B b = new B();              // method1 내부에서 선언된 class B를 참조하는 변수 b를 생성하여 접근한다!    
        System.out.println(b.data); // 3 
      }
    }
   ```
  + 특징  
    + 외부 클래스(class A)의 메소드 내부에 위치하는 클래스로, 지역변수와 같은 성격을 지닌다.
    + 원래 메소드 내에서는 static 멤버를 선언할 수 없듯, static을 붙일 수 없다.
   

  

 
- 참고서적: Do it 자료구조와 함께 배우는 알고리즘 입문 자바 편 (이지스퍼블리싱)
