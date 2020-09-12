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
  
 + 배열의 복제  
  다음 두가지 방법의 차이점은 무엇인지 생각해보자

```java
int[] a = new int[]{1,2,3,4,5};
int[] b = a;
int[] c = a.clone();

a[1] = 8;

System.out.println(a[1]);  // 당연히 8
System.out.println(b[1]);  // ??
System.out.println(c[1]);  // ??  생각해보자
```

+ 배열 요소의 최댓값 구하기  
  어렵지않다.
  
+ 난수 사용해 배열의 요솟값 설정하기  
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


- 참고서적: Do it 자료구조와 함께 배우는 알고리즘 입문 자바 편 (이지스퍼블리싱)
