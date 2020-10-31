## **3주차 세미나: 스택 (Stack)**



### 1. 목차

------

```
1. 스택이란?

2. 스택의 기본 메서드

3. 스택의 활용성
```



### 스택이란?

-----

- 데이터를 <u>일시적</u>으로 저장하기 위해 사용하는 자료구조이다

- 후입선출 (LIFO, Last In First Out) 의 데이터 입/출력 순서를 갖는다.

  (입/출력이 되는 윗부분은 꼭대기 (top), 스택의 가장 아랫부분은 바닥 (bottom) 이라한다.)

  

![](https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR4d_-uDWP-TI83VWg9V5CJYcl1ONvrkeb71g&usqp=CAU)



- 스택 클래스는 크게 3가지 멤버 변수를 갖는다.

  - 스택의 용량: 스택이 최대로 담을 수 있는 데이터 수
  - 스택 포인터: 스택에 쌓여 있는 데이터 수
  - 스택의 본체: 푸시된 데이터를 저장하는 본체의 배열

  ```java
  Class IntStack {
    private int max; // 스택의 용량
    private int ptr; // 스택 포인터
    private int[] stk; // 스택의 본체
  }
  ```

​           **- 멤버 변수를  private 으로 설정하는 이유는??**

### 스택의 기본 메서드

------

-  생성자 IntStack

  ```java
  public IntStack(int capacity){
    ptr=0;
    max=capacity;
    try {
      stk=new int[max];             // 스택 본체용 배열을 생성
    } catch (OutOfMemoryError e) {  // 생성할 수 없음
      max= 0;
    }
  }
  ```

  - int capacity 를 parameter 로 받는 생성자 메서드를 구현하여, 초기 생성시 스택의 용량을 설정한다.

  - 설정한 용량만큼의 int array 스택 본체를 생성한다.

  - 초기 생성된 스택에는 데이터가 없으므로 스택 포인터 ptr 의 값은 0으로 설정한다.

    

- 푸시 메서드 push

  ```java
  // 스택에 x를 푸시
  public int push(int x) throws OverflowIntStackException{
    if (ptr>=max)
      throw new OverflowIntStackException();
    return stk[ptr++]=x;
  }
  ```

  - int x 를 parameter 로 받아, 스택에 푸시하고 싶은 데이터를 입력 받는다.

  - ptr++ 를 사용하여 먼저 스택에는 stk[ptr]=x 로 현재 포인터 위치에 데이터 x를 저장하고, ptr=ptr+1 을 하여 포이터 위치를 다음 데이터가 들어올 위치로 옮겨준다.

    

  **-실수로 ++ptr 을 사용하여 푸시 메서드를 짜면 자료구조가 어떻게 바뀔까??**

  **-교재에 나와있는 푸시 메서드는 return 값이 int 로 되어있는데, int return 값이 꼭 필요할까??**

  ```java
  // 스택에 x를 푸시
  public void push(int x) throws OverflowIntStackException{
    if (ptr>=max)
      throw new OverflowIntStackException();
      stk[ptr++]=x;
  }
  ```



- 팝 메서드 pop

  ```java
  // 스택에서  데이터를 팝(정상에 있는 데이터를 꺼냄)
  public int pop() throws EmptyIntStackException {
    if (ptr<=0)
      throw new EmptyIntStackException();
    return stk[--ptr];
  }
  ```

  - pop 메서드는 스택의 꼭대기에서 데이터를 제거하고 그 값을 반환 하는 메서드이므로 parameter 가 필요 없다.
  - --ptr 을 사용하여 ptr=ptr-1 로 포인터를 한 칸 내린 후, 그 데이터를 return 한다.

 

​     **-pop 메서드 어디를 보아도 데이터를 지우는 코드는 안 보이는데 어떻게 제거되는 걸까??**

​      **(아래와 같이 기존에 사용하고 있던 코드의 ptr 과 stk 변수를 private 에서 public 으로 바꿔본다)**

```java
public class IntStack {
	private int max;
	public int ptr;     // private 에서 public 으로 바꿔본다. 
	public int[] stk;   // private 에서 public 으로 바꿔본다.
	
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {}
	}
	
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}
	
	public IntStack(int capacity) {
		ptr=0;
		max=capacity;
		try {
			stk=new int[max];
		} catch(OutOfMemoryError e) {
			max=0;
		}
	}
	
	public void push(int x) throws OverflowIntStackException {
		if (ptr>=max)
			throw new OverflowIntStackException();
		stk[ptr++]=x;
		
	}
	
	public int pop() throws OverflowIntStackException {
		if (ptr<=0)
			throw new OverflowIntStackException();
		return stk[--ptr];
	}
}
```

**-public 으로 바꿨다면 아래의 코드를 실행시켰을 때 결과가 어떻게 나올까?**

```java
	public static void main(String[] args) {
		IntStack stk1=new IntStack(8);    // 용량 8짜리 스택을 생성
		stk1.push(100);                
		stk1.push(200);
		stk1.pop();
		stk1.push(300);
		System.out.println(stk1.peek());  // Q1. 출력될 값은?
		stk1.stk[3]=400;
		System.out.println(stk1.peek());  // Q2. 출력될 값은?
		stk1.push(900);
		System.out.println(stk1.peek());  // Q3. 출력될 값은?
    System.out.println(stk1.stk[3]);  // Q4. 출력될 값은?
		
	}
```



**스택에서 pop 을 했을 때 포인터의 위치로 들어나는 값이 변하는 것이지, 실제로 스택 내부의 stk 의 값이 지워지는  것이 아니다.**



|  ptr  | 100  | 300  | 900  |      |
| :---: | :--: | :--: | :--: | :--: |
| index |  0   |  1   |  2   |  3   |
|  stk  | 100  | 300  | 900  | 400  |



**위 예시를 통해 스택의 ptr 와 stk 을 왜 private 변수로 지정하는지 이해 할 수 있다.**



- 피크 메서드 peek

  ```java
  // 스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
  public int peek() throws EmptyIntStackException {
    if (ptr<=0)
      throw new EmptyIntStackException();
    return stk[ptr-1];
  }
  ```

  - 피크 메서드 역시 정상에 있는 데이터를 반환하는 메서드이므로 parameter 가 필요없다.

  - 앞서 보았던 푸시와 팝과 달리 ptr 의 위치를 변환 시킬 필요가 없으므로 --ptr, ptr++ 과 같이 ptr의 값을

    직접 바꾸지 않고 ptr-1 로 해당 값만 return 한다.

    

- indexOf, clear, capacity, size, IsEmpty, IsFull 메서드

  ```java
  // 스택에서 x 를 찾아 인덱스 (없으면 -1)를 반환
  public int indexOf(int x) {
  	for (int i=ptr-1;i>0;i--)
  		if (stk[i]==x)
  			return i;
  	return -1;
  }
  
  // 스택을 비움
  public void clear() {
  	ptr=0;
  }
  
  // 스택의 용량을 반환
  public int capacity() {
    return max;
  }
  
  // 스택에 쌓여 있는 데이터 수를 반환
  public int size(){
    return ptr;
  }
  
  // 스택이 비어 있는가?
  public boolean isEmpty() {
    return ptr<= 0;
  }
  
  // 스택이 가득 찼는가?
  public boolean isFull() {
    return ptr>=max;
  }
  
  // 스택 안의 모든 데이터를 바닥에서 꼭대기 순으로 출력
  public void dump() {
    if (ptr<=0)
      System.out.println("스택이 비었습니다.");
    else {
      for (int i=0; i<ptr; i++)
        System.out.print(stk[i]+" ");
      System.out.println();
    }
  }
  ```

앞서 pop 메서드에서 볼 수 있었던 것 처럼, clear, size 메서드 역시 stk의 값을 직접 바꾸지 않고, 포인터 값만 바꿔서 스택 정보를 바꾼다.



### 스택의 활용성

-----------

- 웹 브라우저 방문기록 (뒤로 가기): 가장 나중에 열린 페이지부터 다시 보여준다.

- 역순 문자열 만들기: 가장 나중에 입력된 문자부터 출력한다.
- 실행 취소 (undo): 가장 나중에 실행된 것부터 실행을 취소한다.
- 후위 표기법 계산
- 수식의 괄호 검사 (연산자 우선순위 표현을 위한 괄호 검사)