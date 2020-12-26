# 집합

### 7-1. 집합

#### 집합과 요소

집합(set)이란 객관적으로 범위를 규정한 '어떤 것'의 모임이며, 그 집합 안에서 각각의 '어떤 것'을 요소(element)라고 부른다. 



- a가 집합 X의 요소일 때

  > a ∈ X or X ∋ a	// a는 X에 포함된다

- b가 집합 X의 요소가 아닐 때

  > b ∉ X or X ∌ b	// b는 X에 포함되지 않는다

- 집합 X와 Y가 같은 요소로 구성될 때

  > X = Y or Y = X	// X와 Y는 서로 같다

- 집합 X와 Y가 같은 요소로 구성되지 않을 때

  > X ≠ Y or Y  ≠ X	// X와 Y는 서로 같지 않다

- 유한집합과 무한집합의 표기

  > n(X) = n			 // X는 유한집합(요소의 개수 n)
  >
  > n(Y) = ∞			// Y는 무한집합



#### 부분집합과 진부분집합

##### 부분집합

집합 A의 모든 요소가 집합 B의 요소일 때 A는 B의 부분집합이다

> A ⊂ B or B ⊃ A			// A는 B에 포함된다

##### 진부분집합

집합 A의 모든 요소가 집합 B의 요소이면서 집합 A와 집합 B가 같지 않을 때 A는 B의 진부분집합이다

> A ⊊ B or B ⊋ A



#### 집합의 연산

- 합집합 : A ∪ B
- 교집합 : A ∩ B
- 차집합 : A - B



### 7-2. 배열로 집합 만들기

- capacity 메서드 : 집합의 최대 개수를 반환
- size 메서드 : 집합의 현재 요소 개수를 반환
- indexOf 메서드 : 요소를 검색하여 요소의 인덱스를 반환
- contains 메서드 : 요소 n이 있는지 확인하여 boolean 값 반환
- add 메서드 : 요소 n을 집합에 추가
- remove 메서드 : 요소 n을 집합에서 삭제



- copyTo 메서드 : 집합을 다른 집합으로 복사
- copyFrom 메서드 : 다른 집합을 집합으로 복사
- equalTo 메서드 : 집합과 다른 집합을 비교하여 같은지 판단
- unionOf 메서드 : 두 집합의 합집합을 복사
- toString 메서드 : 집합을 문자열로 변환하여 반환



#### 보충수업1. toString 메서드

toString 메서드는 모두 클래스 인스턴스의 데이터를 문자열로 반환하는 메서드이다.

그리고 "클래스 이름@해시값"의 형태로 문자열을 반환한다.

```java
public class Object {
    // 중략
    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
    // 중략
}
```



Java의 모든 클래스는 Object 클래스의 자식 클래스로, toString 메서드를 오버라이드하여 사용 가능하다.

```Java
class Test {
    static class StudentWithout {
        // toString 오버라이드 x
    }
    
    static class StudentWith {
        // toString 오버라이드 o
    }
    
    public static void main(String[] args) {
        StudentWithout student1 = new StudentWithout("2020-12345", "학생1", "전기");
        StudentWith student2 = new StudentWith("2015-12345", "학생2", "컴공");

        System.out.println(student1.toString());
        // Test$StudentWithout@2133c8f8
        
        System.out.println(student1);
        // Test$StudentWithout@2133c8f8
        
        System.out.println("학번 : " + student1.id + " / 이름 : " + student1.name + " / 전공 : " + student1.major);
		// 학번 : 2020-12345/ 이름 : 학생1 / 전공 : 전기
        
        System.out.println(student2.toString());
        // 학번 : 2015-12345 / 이름 : 학생2 / 전공 : 컴공
        
        System.out.println(student2);
        // 학번 : 2015-12345 / 이름 : 학생2 / 전공 : 컴공
    }   
}
```



Test$StudentWithout@2133c8f8 에서 "2133c8f8"는 인스턴스 student1에 대해  Java가 임의로 부여한 해시값으로, 인스턴스에 대해 고유한 값이 생긴 것이라고 할 수 있다.

```java
System.out.println(student1.hashCode());							// 557041912
System.out.println(Integer.toHexString(student1.hashCode()));		// 2133c8f8
```



#### 보충수업2. Set의 사용

List 클래스는 선형 자료구조를 구현한 클래스이며, Set은 비선형 자료구조를 구현한 클래스이다.

Set은 인터페이스이므로, Set을 구현하는 클래스를 통해 사용가능하며 Set을 구현하는 클래스로는 HashSet, LinkedHashSet, TreeSet이 있다.



HashSet과 LinkedHashSet, TreeSet의 중요한 특징을 정리하면 다음과 같다.



##### 1. HashSet

- HashSet은 Hash 알고리즘을 사용하여 속도가 셋 중에서 가장 빠르다 - O(1).
- 인스턴스의 해시값을 기준으로 데이터가 저장되기 때문에 순서대로 저장되지 않는다.

```java
public class Test {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        hashSet.add("one");
        hashSet.add("two");
        hashSet.add("three");
        hashSet.add("four");
        hashSet.add("five");

        Iterator it1 = hashSet.iterator();
        while (it1.hasNext()) {
            System.out.print(it1.next() + " ");
        }
	}
}
```

```java
four one two three five			// 데이터가 순서대로 정렬되지 않는다.
```



##### 2. TreeSet

- Red-black tree(자가 균형 이진 탐색 트리)의 구조로 복잡하지만 실 사용에서 효율적이고, 최악의 경우에도 우수한 실행 시간을 갖는다 - O(logN).
- 기본적으로 오름차순으로 데이터를 정렬한다.

```java
public class Test {
    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>();

        treeSet.add("one");
        treeSet.add("two");
        treeSet.add("three");
        treeSet.add("four");
        treeSet.add("five");

        Iterator it2 = treeSet.iterator();
        while (it2.hasNext()) {
            System.out.print(it2.next() + " ");
        }
	}
}
```

```java
five four one three two			// 오름차순으로 데이터가 정렬된다.
```

>  [Red-black tree란?](https://itstory.tk/entry/%EB%A0%88%EB%93%9C%EB%B8%94%EB%9E%99-%ED%8A%B8%EB%A6%ACRed-black-tree)



##### 3. LinkedHashSet

- 셋 중에서 가장 느리다.
- 입력된 순서대로 데이터를 관리한다.

```java
public class Test {
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("one");
        linkedHashSet.add("two");
        linkedHashSet.add("three");
        linkedHashSet.add("four");
        linkedHashSet.add("five");

        Iterator it3 = linkedHashSet.iterator();
        while (it3.hasNext()) {
            System.out.print(it3.next() + " ");
        }
	}
}
```

```java
one two three four five 		// 입력된 순서대로 데이터가 정렬된다.
```

#### 

##### More HashSet

- **String 객체**의 중복 저장을 방지하는 과정 :

  1. 객체를 저장하기 전에 먼저 객체의 hashCode() 메서드를 호출하여 해시 코드를 얻어낸다.

  2. 저장되어 있는 객체들의 해시 코드를 비교하여 같은 해시 코드가 존재하면 다시 equals() 메서드로 두 객체를 비교한다.

  3. true가 나오면 동일한 객체로 판단하고 중복 저장을 하지 않는다.

```java
public class Test {
    public static void main(String[] args) {
        String st1 = new String("동일");
        String st2 = new String("동일");
        String st3 = new String("동일");
        System.out.println(st1.hashCode());
        System.out.println(st2.hashCode());
        System.out.println(st3.hashCode());
    }
}
```

```java
1478339
1478339
1478339
```

- 문자열을 HashSet에 저장할 경우, 같은 문자열을 갖는 String객체는 동일한 객체로 간주되고 다른 문자열을 갖는 String객체는 다른 객체로 간주된다.
  - **Why?** String클래스가 hashCode()와 equals() 메소드를 재정의해서 같은 문자열일 경우 hashCode()의 리턴 값을 같게, equals()의 리턴 값은 true가 나오도록 했기 때문....이라고 한다.
  - 따라서 위의 "동일"이라는 String 객체는 인스턴스는 다르지만 hash value가 같기 때문에 hashCode()의 리턴 값이 동일하게 나온다.



- **일반적인 객체라면?**

```java
public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("1", "재환");
        Person p2 = new Person("1", "재환");

        Set<Person> personSet = new HashSet<>();
        personSet.add(p1);
        personSet.add(p2);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        Iterator<Person> it1 = personSet.iterator();
        while (it1.hasNext()) {
            Person p = it1.next();
            System.out.println(p.id + ", " + p.name);
        }
    }

    static class Person {
        String id;
        String name;

        public Person(String id, String name) {
            this.id = id;
            this.name = name;
        }
        
        /*@Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(id, person.id) &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }*/
    }
}
```

```java
1239731077			// System.out.println(p1.hashCode());
557041912			// System.out.println(p2.hashCode());
1, 재환			   // Set에 p1 포함
1, 재환			   // Set에 p2 포함
```

hashCode()를 오버라이드 해보자.

```java
public class Test {
	// 중략
    static class Person {
        // 중략
    	@Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
}
```

```java
1641948				// System.out.println(p1.hashCode());
1641948				// System.out.println(p2.hashCode());
1, 재환			   // Set에 p1 포함
1, 재환			   // Set에 p2 포함
```

equals()를 오버라이드 해보자.

```java
public class Test {
	// 중략
    static class Person {
        // 중략
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(id, person.id) &&
                    Objects.equals(name, person.name);
        }
}
```

```java
1641948				// System.out.println(p1.hashCode());
1641948				// System.out.println(p2.hashCode());
1, 재환			   // Set에 p1 포함 o, p2 포함 x
```



**References**

1. https://coding-factory.tistory.com/554
2. http://blog.naver.com/PostView.nhn?blogId=heartflow89&logNo=220994601249&parentCategoryNo=&categoryNo=28&viewDate=&isShowPopularPosts=false&from=postView
3. https://n1tjrgns.tistory.com/102
4. https://2ssue.github.io/base/study-about-set/
5. https://medium.com/@logishudson0218/java-collection-framework-896a6496b14a