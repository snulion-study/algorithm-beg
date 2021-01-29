# 해시법


**해시법(hashing)** 은 데이터를 저장할 위치(인덱스)를 간단한 연산으로 구하는 것으로, 검색뿐만 아니라 **추가, 삭제도 효율적으로 수행** 할 수 있다.

**해시 값(hash value)** 은 데이터에 접근할 때 사용하며, 해시 값이 인덱스가 되도록 원래의 키 값을 저장한 배열을 **해시 테이블(hash table)** 이라 한다.

키 값을 통해 해시 값을 만드는 과정을 **해시 함수(hash function)** 이라 한다.

해시 테이블의 각 요소는 **버킷(bucket)** 이라고 한다.



## 충돌(collision)

저장할 버킷이 중복되는 현상을 말한다.



### 충돌에 대한 대처

1. 체인법 : 같은 해시 값을 갖는 요소를 연결 리스트로 관리하기
2. 오픈 주소법 : 빈 버킷을 찾을 때까지 해시를 반복하기



## 체인법(chaining)

같은 해시 값을 갖는 데이터를 연결 리스트에서 연결하는 방법으로, **오픈 해시법(open hashing)** 이라고도 한다.



#### 검색 과정

1. 해시 함수가 키 값을 해시 값으로 변환
2. 해시 값을 인덱스로 하는 버킷을 선택
3. 선택한 버킷의 연결 리스트를 처음부터 순서대로 검색. 키 값과 같은 값을 찾으면 검색 성공. 끝까지 스캔하여 찾지 못하면 검색 실패



#### 추가 과정

1. 해시 함수가 키 값을 해시 값으로 변환
2. 해시 값을 인덱스로 하는 버킷을 선택
3. 버킷이 가리키는 연결 리스트를 처음부터 순서대로 검색. 키 값과 같은 값을 찾으면 키 값이 이미 등록된 상태이므로 추가에 실패. 끝까지 스캔하여 찾지 못하면 맨 앞 위치에 노드를 삽입.

> 리스트의 마지막에 삽입하지 않고, 맨 앞에 삽입하는 이유?



#### 삭제 과정

1. 해시 함수가 키 값을 해시 값으로 변환
2. 해시 값을 인덱스로 하는 버킷을 선택
3. 버킷이 가리키는 연결 리스트를 처음부터 순서대로 검색. 키 값과 같은 값을 찾으면 그 노드를 리스트에서 삭제. 그렇지 않으면 삭제에 실패.



> #### 보충수업 11-2. 열거
>
> - 클래스처럼 보이게 하는 상수
>
> - 서로 관련 있는 상수들을 모아 심볼릭한 명칭의 집합으로 정의한 것
>
> - Enum 클래스형을 기반으로 한 클래스형 선언
>
> - 새로운 열거형을 선언하면, 내부적으로 Enum 클래스형 기반의 새로우누 클래스형이 만들어짐.
>
> - 메서드
>
>   1. **values() : 열거된 모든 원소를 배열에 담아 순서대로 반환**
>
>      ```java
>      public class test {
>       
>        enum Season {
>          SPRING, SUMMER, AUTUMN, WINTER
>        }
>        
>        public static void main(String[] args) {
>              for (Season season : Season.values()) {
>                  System.out.println(season);
>              }
>          }
>      }
>      ```
>
>      ```java
>      // 출력 결과
>      SPRING
>      SUMMER
>      AUTUMN
>      WINTER
>      ```
>
>   2. **ordinal() : 원소에 열거된 순서를 정수 값으로 반환**
>
>      ```java
>      // ...
>      System.out.println(Season.SPRING.ordinal());
>      System.out.println(Season.SUMMER.ordinal());
>      System.out.println(Season.AUTUMN.ordinal());
>      System.out.println(Season.WINTER.ordinal());
>      ```
>
>      ```java
>      // 출력 결과
>      0
>      1
>      2
>      3
>      ```
>
>   3. **valueOf() : 매개변수로 주어진 String과 열거형에서 일치하는 이름을 갖는 원소를 반환
>      (주어진 String과 일치하는 원소가 없는 경우 IllegalArgumentException 예외 발생)**
>
>      ```java
>      // ...
>      System.out.println(Season.valueOf("SPRING"));
>      // SPRING
>      
>      System.out.println(Season.valueOf("HOTSPRING"));
>      // 에러 발생 : Exception in thread "main" java.lang.IllegalArgumentException: No enum constant test.Season.HOTSPRING
>      at java.base/java.lang.Enum.valueOf(Enum.java:273)
>      at test$Season.valueOf(test.java:16)
>      at test.main(test.java:13)
>      ```
>
> - 열거형 상수를 다른 값과 연결하기
>
>   ```java
>   public class test {
>       enum Type {
>           // 상수("연결할 문자")
>           WALKING("워킹화"),
>           RUNNING("러닝화"),
>           TRACKING("트래킹화"),
>           HIKING("등산화"); // 세미콜론 빠지면 에러
>   
>           final private String name;
>   
>           private Type(String name) { //enum에서 생성자 같은 역할
>               this.name = name;
>           }
>           public String getName() { // 문자를 받아오는 함수
>               return name;
>           }
>       }
>     
>     public static void main(String[] args) {
>           for(Type type : Type.values()){
>               System.out.println(type.getName());
>           }
>       }
>   }
>   ```
>
>   ```java
>   // 출력 결과
>   워킹화
>   러닝화
>   트래킹화
>   등산화
>   ```
>
> - ##### 클래스의 static final 이용해서 열거형 선언하기
>
>   ```java
>   public class test {
>     
>       class Type {
>           static final String WALKING = "워킹화";
>           static final String RUNNING = "러닝화";
>           static final String TRACKING = "트래킹화";
>           static final String HIKING = "등산화";
>       }
>     
>       public static void main(String[] args) {
>             String w = Type.WALKING;
>           	System.out.println(w); // 출력 결과 : "워킹화"
>       }
>   }
>   ```
>
> Reference : https://www.opentutorials.org/module/1226/8025



## 또 다른 해시법 - 오픈 주소법(open addressing)

충돌이 발생했을 때 **재해시를 수행**하여 비어 있는 버킷을 찾아내는 방법으로, **닫힌 해시법(closed hashing)**이라고도 한다.

빈 버킷을 만날 때까지 재해시를 여러 번 반복하므로 **선형 탐사법(linear probing)**이라고도 한다.



#### 요소 삭제

각 버킷에 속성 부여

- 데이터 저장 속성값

- 비어 있음 속성값(-)

- 삭제 마침 속성값(*)

  

## hashCode()의 이용

`HashMap` 과 같이 해싱을 구현한 컬렉션 클래스에서는 `Object` 클래스에 정의된 `hashCode()` 를 해시함수로 사용한다. `Object` 클래스에 정의된 `hashCode()` 는 객체의 주소를 이용하는 알고리즘으로 해시 코드를 만들어 내기 때문에 모든 객체에 대해 `hashCode()` 를 호출한 결과가 서로 유일하다.

`String` 클래스의 경우 `Object` 로부터 상속받은 `hashCode()` 를 오버 라이딩해서 문자열의 내용으로 해시 코드를 만들어낸다. 그래서 서로 다른 `String` 인스턴스일지라도 같은 내용의 문자열을 가졌다면 `hashCode()` 를 호출했을 때 같은 해시 코드를 얻는다.

**새로운 클래스를 정의할 때 `equals()` 를 오버 라이딩해야 한다면 `hashCode()` 도 같이 재정의해서 `equals()` 의 결과가 `true`인 두 객체의 `hashCode()` 의 결과값이 항상 같도록 해주어야 한다.** 그렇지 않으면 `HashMap` 과 같이 해싱을 구현한 컬렉션 클래스에서는 `equals()` 의 호출 결과가 `true` 지만 해시 코드가 다른 두 객체를 서로 다른 것으로 인식하고 따로 저장한다.

출처: https://pridiot.tistory.com/75 [pridiot]







