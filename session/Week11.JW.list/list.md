# 9장 List (p.306 - 367)

## 09-1 선형 리스트

리스트 : 데이터를 순서대로 나열한 자료구조 Ex) 배열, 스택, 큐 등

**선형 리스트란?**

:일렬로 나열되어 있는 가장 단순한 구조의 리스트. 선형 리스트(linear list) 혹은 연결 리스트(linked list)라고 한다. <br>

우리에게 익숙한 리스트는 바로 포인터를 활용한 linked list! '데이터 + 포인터'로 구성된 노드 혹은 요소들을 연결한 구조이다. 이 포인터는 다른 노드를 가리키며, 일반적으로 다음 노드를 가리키는 포인터 1개만을 가지거나(*단일 연결 리스트, singly linked list*) 이전 노드까지 가리키는 포인터를 포함하여 총 2개의 포인터로 이루어진 형태(*이중 연결 리스트, doubly linked list*)가 있다. <br>

또 일반적으로 제일 앞 노드를 *head* 노드라고 지칭하며 반대로 제일 뒷 노드를 *tail* 노드라고 지칭한다.

<br>

**배열로 선형 리스트 만들기**

배열은 그 자체로 리스트이기 때문에 구현에 큰 어려움은 없지만 몇가지 유의할 점이 있다.

1. 배열은 미리 메모리를 할당하므로 쌓이는 데이터 양의 변화에 효율적으로 대처할 수 없다.
2. 중간에 삽입되거나 삭제된다면, 공간을 효율적으로 사용하기 위해서는 그 뒤의 모든 요소들을 1칸씩 당기거나 밀어야하므로 비효율적이다.

잠시 뒤에 이에 대해 좀 더 자세하게 다뤄보도록 하자.

<br>

## 09-2 포인터로 연결 리스트 만들기 

```java
class Node<E> {
  E data;
  Node<E> next;
}
```

다음과 같이 연결 리스트의 노드는 데이터를 담은 필드 data 외에 자기 자신과 같은 클래스형의 인스턴트를 참조하기 위한 참조용 필드 next를 가진다. 이런 클래스 구조를 *자기 참조(self-referential) 형* 이라고 한다.

위와 같은 구조의 노드를 활용하여 연결리스트를 만들 때 유의해야 할 것은 *head* 와 *curr*이다. (교재에선 crnt라는 이름) <br>

 먼저, *curr* 은 배열과 달리 리스트에서는 인덱스를 통한 직접 접근을 할 수 없기 때문에 리스트 중에서 현재 처리할 노드 혹은 다음 연산에 영향을 주는 위치를 가리키고 있는 참조 필드가 필요하다. 그것이 바로 *curr* 이다. <br> 
다음으로, 연결 리스트는 *head* 를 어떻게 처리할 것인지에 따라서 조금 다른 방식으로 구현할 수 있다.
1. 첫번째로, head에 곧바로 첫번째 데이터를 담은 노드를 담을 경우에는 삽입/삭제 시 head와 연관된 경우를 예외 처리해주어야 한다. 책에 정리된 코드는 다음과 같다. <br>
```java
public class LinkedList<E> {
  class Node<E> {
    private E data;
    private Node<E> next;

    Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
  }

  private Node<E> head;
  private Node<E> crnt;

  public LinkedList() {
    head = crnt = null;
  }

  public E search(E obj, Comparator<? super E> c) {
    Node<E> ptr = head;

    while (ptr != null) {
      if (c.compare(obj, ptr.data) == 0) {
        crnt = ptr;
        return ptr.data;
      }
      ptr = ptr.next;
    }
    return nul;;
  }

  public void addFirst(E obj) {
    Node<E> ptr = head;
    head = crnt = new Node<E>(obj, ptr);
  }

  public void addLast(E obj) {
    if (head == null) addFrist(obj);
    else  {
      Node<E> ptr = head;
      while (ptr.next!= null)
        ptr = ptr.next;
      ptr.next = crnt = new Node<E>(obj, null);
    }
  }

  public void removeFirst() {
    if (head != null)
      head = crnt = head.next;
  }

  public void removeLast() {
    if (head != null) {
      if (head.next == null) removeFirst();
      else {
        Node<E> ptr = head; // 스캔 중인 노드
        Node<E> pre = head; // 스캔 중인 노드의 앞쪽 노드

        while (ptr.next != null) {
          pre = ptr;
          ptr = ptr.next;
        }

        pre.next = null;
        crnt = pre;
      }
    }
  }

  public void remove(Node p) {
    if (head != null) {
      if (p == head) removeFirst();
      else {
        Node<E> ptr = head;

        while (ptr.next != p) {
          ptr = ptr.next;
          if (ptr == null) return; // p가 리스트에 없는 경우
        }
        ptr.next = p.next;
        crnt = ptr;
      }
    }
  }

  public void removeCurrentNode() {
    remove(crnt);
  }
}
```

2. 그러나 `head` 포인터가 더미 노드를 가리키게 하고, 그 이후부터 실제 데이터를 갖고 있는 노드를 넣는다면, curr이 head인 경우의 예외처리를 해줄 필요가 없다. <br>
`head(1번 노드) -> 2번 노드` -> `head(더미 노드) -> 1번 노드`로 바뀌는 셈. 자료구조 수업 때 사용한 교재에선 다음과 같이 구현하고 있다.
```java
// 이 구현방식에서 삽입과 삭제는 curr 노드의 오른쪽에서 이루어진다.
public void insert(E it) {
  curr.setNext(new Link<E>(it curr.next()));
  if (tail == curr) tail = curr.next();
  cnt++
}

public E remove() {
  if (curr.next() == null) return null;
  E it = curr.next().element();
  if (tail == curr.next()) tail = curr;
  curr.setNext(curr.next().next());
  cnt--;
  return it;
}
```


<br>

## 09-3 커서로 연결 리스트 만들기
: 각 노드를 배열에 저장하고 이를 연결 리스트로 구현할 수 있다.

**커서로 연결 리스트 만들기**

포인터를 이용하여 연결 리스트를 만드는 경우, 노드의 삽입, 삭제마다 노드용 객체를 위한 메모리 영역을 만들고 해제하는 과정이 필요하다. 이 비용이 결코 무시할 수 없는 정도이므로, 만약 데이터의 양을 미리 예측할 수 있다면 적절한 크기의 배열을 미리 선언하여 연결리스트로 구현하여 효율적인 수행이 가능하다.

방법은 간단하다. 배열의 각 노드에 (논리적인) 연결리스트 상의 다음 노드의 인덱스를 넣어주면 된다. 코드는 다음과 같다.

```java
Node<E> {
  private E data;
  private int next; // 리스트의 뒤쪽 포인터
  private int dnext; // free 리스트의 뒤쪽 포인터

  void set(E data, int next) {
    this.data = data;
    this.next = next;
  }
}
```

**배열의 비어 있는 요소 처리하기**

: 위의 코드에서 free 리스트는 무엇일까? 배열로 연결 리스트를 구현한 경우, 삭제하고 나서 뒤의 요소들을 당겨줄 필요가 없다는 장점이 있었다. 하지만 그런 경우 배열의 중간중간 빈자리가 생기게 되고, 결국 삽입할 위치를 찾기 위해선 빈자리를 찾아야 하므로 시간복잡도는 O(n)이 된다. 따라서 이를 더 효율적으로 관리할 필요가 있다.

**프리 리스트**

: 위의 문제점을 해결하기 위해서, 우리는 `Node` 클래스에 `dnext` 변수를 추가한 것이다. `dnext`를 활용한 또 하나의 연결 리스트를 만들어서, 본 리스트에서 삭제된 노드의 인덱스를 프리 리스트의 머리에 삽입한다. 후에 본 리스트에 삽입이 필요한 경우 프리 리스트의 머리에서 인덱스를 꺼내어 그곳에 삽입한다면 시간복잡도는 O(1)이 되게 된다.

-> 결국 프리리스트에 노드가 있다면 (본 배열 중간에 빈칸이 있다면) 그곳을 먼저 사용하고, 프리리스트에 노드가 없다면 (현재 인덱스까지 모든 배열이 꽉 차 있다면) 본 배열의 다음 요소에 삽입하게 된다.

<br>

## 09-4 원형 이중 연결 리스트

**원형 리스트**

: 꼬리(tail) 노드의 `next` 포인터가 `null`이 아닌 `head`를 가리키도록 구현한 것을 원형 리스트라고 한다. 이전에 배운 원형 큐와 비슷한 형태


**이중 연결 리스트**
: 이전에 배운 포인터 활용 연결 리스트에서, `next` 포인터 1개만 활용한 경우 삭제를 하기 위해선 임의의 포인터를 head부터 시작해서 curr 이전까지 순서대로 참조하게 해야한다. 즉 O(n)의 시간복잡도를 가진다. 하지만 이전 노드를 가리키는 참조 필드 `prev`를 추가한다면 이 작업을 O(1)에 끝낼 수 있게 된다.

==> 위의 두 개념을 합친다면 원형 이중 연결 리스트(circular doubly linked list)를 구현할 수 있다.