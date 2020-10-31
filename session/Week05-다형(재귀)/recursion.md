# 재귀 알고리즘

---

## 재귀의 기본

---

### 재귀란?

- 어떤 사건이 자기 자신을 포함하고 다시 자기 자신을 사용하여 정의될 때
- 재귀적 정의(recursive definition)에 의해 무한으로 존재하는 자연수를 다음 두 문장으로 정의할 수 있다.

```java
// 1. 1은 자연수입니다.
// 2. 자연수 n의 바로 다음 수도 자연수입니다.
```

### 예제1. 팩토리얼 구하기

대표적인 재귀 사용의 예. 음이 아닌 정수의 팩토리얼 구하는 프로그램.

음이 아닌 정수 n!은 아래처럼 재귀적으로 정의할 수 있다.

```java
// 1. 0! = 1
// 2. n > 0이면 n! = n * (n-1)!
```

```java
package chap05;
import java.util.Scanner;
// 팩토리얼을 재귀적으로 구현  

class Factorial {
	// 양의 정수 n의 팩토리얼을 반환  
	static int factorial(int n) {
		if (n>0)
			return n * factorial(n-1);
		else
			return 1;
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요: ");
		int x = stdIn.nextInt();
		
		System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
	}
}
```

### 재귀 호출(recursive call)/재귀함수
- 어떤 함수에서 자신을 다시 호출하여 작업을 수행하는 방식의 함수. 재귀호출, 되부름이라고도 부름.
- 반복문을 사용하는 코드는 항상 재귀함수를 통해 구현할 수 있으며, 그 반대도 가능하다.
- 재귀호출이란 함수 내부에서 함수가 자기 자신을 또다시 호출하는 행위를 의미. 이러한 재귀호출은 자기가 자신을 계속해서 호출하므로, 끝없이 반복되게 됨. 따라서 함수 내에 재귀 호출을 중단하도록 조건이 변경될 명령문을 반드시 포함해야 함. (재귀함수를 작성할 때에는 함수내에서 다시 자신을 호출한 후 그 함수가 끝날 때까지 함수 호출 이후의 명령문이 수행되지 않는다는 사실과 종료조건이 꼭 포함되어야한다는 사실을 인지하고 작성해야 무한루프를 방지할 수 있다.)

<div><img src="https://user-images.githubusercontent.com/55521320/97769832-8b76b880-1b71-11eb-85a1-3b59ba3ff788.gif" width ="50%"></img></div>

factorial(n)은 n-1의 팩토리얼 값을 구하기 위해 다시 factorial 메서드를 호출함.

재귀호출의 장점 : 코드의 간결함

재귀호출의 단점 : 무한 재귀호출의 위험성, 성능 상의 문제

- 직접(direct) 재귀와 간접(indirect) 재귀

직접 재귀: 자기가 자기 자신을 호출. 직접적으로 재귀 함수의 이름으로 호출을 당당하게 진행한다.

간접 재귀: 함수 a가 함수 b를 호출하고 b는 a를 호출. 다른 함수를 통해 간접적으로 재귀 함수의 이름을 호출한다.

<div><img src="https://user-images.githubusercontent.com/55521320/97769904-ec9e8c00-1b71-11eb-9e9d-68aa3d0f1d42.jpg" width="50%"></img></div>


### 예제2. 유클리드 호제법

두 수의 최대공약수를 구하는 알고리즘

- 설명 그림
- 임의의 두 자연수 x, y가 주어졌을때. 둘중 큰 값이 a라고 가정
- x를 y로 나눈 나머지를 n 이라고 하면 (x%y = n)
- n이 0일때, y가 최대 공약수: gcd(x,y)
- 만약 n이 0이 아니라면, x에 y값을 다시 넣고 n를 y에 대입 한 후 다시 위에 step2부터 반복
- 즉, 최대공약수는 y가 0이면 x이고, y가 0이 아니면 gcd(y, x%y)로 구함

```java
package chap05;
import java.util.Scanner;
// 유클리드 호제법으로 최대공약수 구하기  

class EuclidGCD {
	// 정수 x, y의 최대공약수를 구하여 반환  
	static int gcd(int x, int y) {
		if (y==0)
			return x;
		else
			return gcd(y, x%y);
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요.:"); int x = stdIn.nextInt();
		System.out.print("정수를 입력하세요.:"); int y = stdIn.nextInt();
		
		System.out.println("최대공약수는 " + gcd(x,y) + "입니다.");
	}
}
```

- cf) 재귀 메서드를 호출하지 않고?

### 예제3. CountDown
```python
def countdown(n):
    if n==0:
        print("boom")
    else:
        print(n)
	countdown(n-1, end='')

countdown(10)
```

결과값: 10 9 8 7 6 5 4 3 2 1 boom

<div><img width="465" alt="스크린샷 2020-10-31 오후 12 19 09" src="https://user-images.githubusercontent.com/55521320/97770118-fde89800-1b73-11eb-9646-8e8e250e4ce2.png"></img></div>

### 예제4. 구구단 출력
- 내림차순 배열
```python
def multi_table_2(n):
    if n==0:
        print("end")
    else:
        print('2*{}={}'.format(n, 2*n))
	multi_table_2(n-1)
	
multi_table_2(9)
```
<div><img width="132" alt="스크린샷 2020-10-31 오후 12 20 33" src="https://user-images.githubusercontent.com/55521320/97770127-1193fe80-1b74-11eb-9817-ad87835bf5e9.png">
</img></div>

- 오름차순 배열
```python
def multi_table_2(n):
    if n==0:
        print("end")
    else:
        multi_table_2(n-1)
        print('2*{}={}'.format(n, 2*n))
	
multi_table_2(10)
```

<div><img width="464" alt="스크린샷 2020-10-31 오후 12 22 30" src="https://user-images.githubusercontent.com/55521320/97770143-24a6ce80-1b74-11eb-8bf4-d817383c1903.png"></img></div>

## 재귀 알고리즘 분석

```java
package chap05;
import java.util.Scanner;

class Recur {
	// 재귀 함수  
	static void recur(int n) {
		if (n>0) {
			recur(n-1);
			System.out.println(n);
			recur(n-2);
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요.:");
		int x = stdIn.nextInt();
		
		recur(x);
	}
}
```

위의 recur 메서드를 두 가지 방식으로 분석할 수 있음.

1. 하향식 분석

가장 처음 메서드 호출부터 시작해 계단식을 자세히 조사하는 분석 기법 

처음 시작하는 재귀함수로부터 나뭇가지 형식으로 아래로 뻗어나가는 방법

ex) 숫자 4를 입력하면 그에따른 프로그램 실행순서를 그래프로 그린다.

2. 상향식 분석

하향식 분석과는 대조적으로 아래쪽 부터 쌓아 올리며 분석하는 방법 

가장 아래의 재귀함수를 먼저 실행하고 하나하나 재귀를 쌓아가는 방법

ex) 숫자 조건 if( n>0 )이라면 1부터 넣어서 출력 결과물을 본다.




## 재귀 알고리즘의 비재귀적 표현

### 꼬리 재귀의 제거

```java
	static void recur(int n) {
		if (n>0) {
			recur(n-1);
			System.out.println(n);
			recur(n-2); // 이 부분
		}
	}
```

위 코드에서 마지막 줄인 'recur(n-2)'는 n-2를 인자로 갖는 recur함수를 다시 호출하라는 의미와 같으므로, n을 n-2의 값으로 업데이트하고 recur함수를 시작하라는 의미와도 같음.

아래처럼 바꿀 수 있다! = *꼬리 재귀를 제거*하는 역할

```java
package chap05;
import java.util.Scanner;

class Recur {
	// 재귀 함수  
	static void recur(int n) {
//		if (n>0) {
		while (n>0) {
			recur(n-1);
			System.out.println(n);
//			recur(n-2);
			n = n -2;
		}
	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요.:");
		int x = stdIn.nextInt();
		
		recur(x);
	}
}
```

### 재귀의 제거

스택의 활용?

참고자료

[http://tcpschool.com/](http://tcpschool.com/)

[https://blockdmask.tistory.com/53](https://blockdmask.tistory.com/53)

[https://gomguard.tistory.com/111](https://gomguard.tistory.com/111)
