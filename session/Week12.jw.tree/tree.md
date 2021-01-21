# CH10. 트리 (p.368 ~ p.375)

## 10-1 트리

### 트리란?

: 트리는 노드(node)와 가지(edge)로 구성되며 데이터 사이의 계층 관계를 나타내는 자료구조 <br />
<br />

**트리 관련 용어**
- 루트(root): 트리 가장 윗부분에 위치하는 노드, 하나의 트리에는 하나의 루트가 있다.
- 리프(leaf): 트리 가장 아랫부분에 위치하는 노드. 물리적으로 가장 아랫 노드가 아니라, 더이상 뻗어나가지 않는 마지막 노드를 의미
- 안쪽 노드(internal node): 루트와 리프노드를 제외한 노드
- 자식: 어떤 노드로부터 가지로 연결된 아래쪽 노드를 의미. 리프 노드는 자식을 가질 수 없음
- 부모: 어떤 노드에서 가지로 연결된 바로 윗쪽 노드. 루트는 부모를 가질 수 없음
- 형제(sibling): 같은 부모를 가지는 노드
- 조상: 어떤 노드에서 가지로 연결된 위쪽 모든 노드를 의미
- 자손: 어떤 노드에서 가지로 연결된 아래쪽 모든 노드를 의미
- 레벨(level): 루트로부터 얼마나 떨어져 있는지에 대한 값. 따라서 루트 노드의 레벨은 0이며, 밑으로 내려가면서 1씩 증가함
- 차수(degree): 노드가 갖는 자식의 수. 모든 노드의 차수가 n 이하인 트리를 n진 트리라고 함. ex) 2진트리..
- 높이 (height: 루트로부터 가장 멀리 떨어진 리프까지의 거리 (리프 레벨의 최댓값)
- 서브트리(subtree): 트리 안에서 다시 어떤 노드를 루트로 설정했을 때 그 자손으로 이루어진 트리.
- 널 트리(null tree): 노드나 가지가 없는 트리
- 순서 트리(ordered tree)와 무순서 트리(unordered tree): 형제 노드 사이에 순서를 따진다면 순서 트리, 그렇지 않다면 무순서 트리라고 함
  
<br />

**순서 트리 탐색**

: 크게 두가지로 분류 가능
1. 넓이 우선 탐색(breadth-first Search): 루트 노드부터 시작해서 현재 바라보고 있는 레벨의 모든 루트를 순회한 후에, 다음 레벨로 넘어가 같은 과정을 반복
2. 깊이 우선 탐색(depth-first Search): 루트 노드부터 시작해서 리프노드까지 자식 노드를 쭉 탐색한 후에 리프 노드에 도달하게 되면 다시 부모노드로 올라가 또다른 자식 노드를 택해 같은 과정을 반복하는 탐색방법.
   > 이진트리에서 깊이 우선 탐색은 '노드의 방문 시점'에 따라 3가지로 나눌 수 있다. <br />
   > 1. 전위 순회(preorder) : 해당 노드를 먼저 방문하고 자식 노드 탐색
   > 2. 중위 순회(inorder) : 왼쪽 자식 노드를 먼저 방문하고 해당 노드 방문 후 마지막으로 오른쪽 자식 노드 방문
   > 3. 후위 순회(postorder) : 두 자식 노드를 먼저 방문하고 마지막으로 해당 노드 방문
   
<br />

---
## 10-2 이진트리와 이진검색트리

### 이진트리(binary tree)
: 노드가 왼쪽 자식과 오른쪽 자식을 갖는 트리

### 완전이진트리(complete binary tree)
: 마지막 레벨을 제외한 모든 레벨에 노드가 가득 채워져 있고, 마지막 레벨의 경우 왼쪽부터 순차적으로 노드가 채워져 있는 트리

**완전이진트리의 특성**
- 높이 k인 완전이진트리가 가질 수 있는 노드의 최대값은 2^(K+1) - 1
- 따라서 n개의 노드를 저장할 수 있는 완전 이진트리의 높이는 logn (힙정렬에 사용된다.)


### 정이진트리(full binary tree)
: 모든 노드가 2개의 자식을 가지고 있거나 리프노드인 이진 트리

### 이진검색트리(binary search tree, BST)
: 이진트리가 다음 두 조건을 모두 만족하는 경우 BST라고 함
1. 어떤 노드 N을 기준으로 왼쪽 서브트리의 모든 노드의 키값은 N의 키 값보다 작다.
2. N을 기준으로 오른쪽 서브트리의 모든 노드의 키값은 N과 같거나(같은 키값은 갖는 노드가 있을 경우) N보다 크다.

**따라서, BST를 중위 순회하게 되면 키값의 오름차순으로 노드를 얻을 수 있다.**

### BST 구현


```java
import java.util.Comparator;
// 이진검색트리

public class BinTree<K,V> {
	// 노드
	static class Node<K,V> {
		private K key;					// 키 값
		private V data;					// 데이터
		private Node<K,V> left;			// 왼쪽 자식 노드
		private Node<K,V> right;		// 오른쪽 자식 노드

		// 생성자
		Node(K key, V data, Node<K,V> left, Node<K,V> right) {
			this.key   = key;
			this.data  = data;
			this.left  = left;
			this.right = right;
		}

		// 키 값을 반환
		K getKey() {
			return key;
		}

		// 데이터를 반환
		V getValue() {
			return data;
		}

		// 데이터를 출력
		void print() {
			System.out.println(data);
		}
	}

	private Node<K,V> root;								// 루트
	private Comparator<? super K> comparator = null;	// 비교자

	// 생성자
	public BinTree() {
		root = null;
	}

	// 생성자
	public BinTree(Comparator<? super K> c) {
		this();
		comparator = c;
	}

	// 두 키 값을 비교 -> BST의 여러 메소드는 결국 대소 비교를 기반으로 실행되기 때문에 이를 잘 활용하여야 한다.
	private int comp(K key1, K key2) {
		return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2)
											 : comparator.compare(key1, key2);
	}


	/*
    키를 활용한 검색. BST에서 기준 노드의 왼쪽에는 키값이 작은 노드만 위치하고, 오른쪽에는 기준 노드보다 키값이 큰 노드만 위치한다는 점을 활용.
    만약 찾으려는 키값이 기준 노드의 키값과 같다면 기준 노드를 반환하고 기준 노드의 키값보다 크다면 오른쪽, 작다면 왼쪽 노드로 넘어가서 탐색 진행. 만약 리프 노드까지 간 상태에서 자식 노드로 탐색을 하게 될 경우 기준노드에 null이 담기게 되며, 이 경우 찾는 키값을 가진 노드가 없다는 얘기이므로 탐색 실패.
    
    수업시간에는 재귀함수로 구현하였으나 이 교재에선 while문으로 구현함
  */
	public V search(K key)	{
		Node<K,V> p = root;								// 루트에 주목

		while (true) {
			if (p == null)								
				return null;							
			int cond = comp(key, p.getKey());			
			if (cond == 0)								
				return p.getValue();					
			else if (cond < 0)							
				p = p.left;								
			else										
				p = p.right;
		}
	}


  /*
    노드 삽입 시 주의해야할 점은 BST의 특성을 지키는 것(키값의 대소). 따라서 노드가 삽입될 적절한 위치를 찾는 것이 중요하다. 
    탐색과 마찬가지로 대소비교를 하며 삽입할 노드와 같은 키값을 가진 노드가 있다면 함수를 종료하고(같은 키값을 허용하지 않는다고 가정) / 삽입 노드의 키 값이 기준 노드의 키값보다 작다면 왼쪽, 아니라면 오른쪽 자식 노드를 타고 내려가다가 null을 만나면 그곳에 삽입.
  */
	private void addNode(Node<K,V> node, K key, V data) {
		int cond = comp(key, node.getKey());
		if (cond == 0)
			return;										// key가 이진검색트리에 이미 있음
		else if (cond < 0) {
			if (node.left == null)
				node.left = new Node<K,V>(key, data, null, null);
			else
				addNode(node.left, key, data);			// 왼쪽 서브 트리에 주목
		} else {
			if (node.right == null)
				node.right = new Node<K,V>(key, data, null, null);
			else
				addNode(node.right, key, data);			// 오른쪽 서브 트리에 주목
		}
	}

	// 노드를 삽입
	public void add(K key, V data) {
		if (root == null)
			root = new Node<K,V>(key, data, null, null);
		else
			addNode(root, key, data);
	}


  /*
    세 가지 경우를 고려하여 구현해야 한다.
    1. 자식 노드가 없는 노드를 삭제하는 경우
    2. 자식 노드가 1개인 노드를 삭제하는 경우
    3. 자식 노드가 2개인 노드를 삭제하는 경우
    ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    1: 삭제하려는 노드 G의 부모 노드 P에서 후 G의 위치(왼쪽, 오른쪽)에 따라 해당 자식의 값을 Null로 설정하면 자동으로 C가 삭제된다.
    2: 삭제하려는 노드가 자식을 가지고 있을 경우, 그 자식까지 삭제하지 않도록 주의해야 한다. 따라서 삭제하려는 노드 G의 부모 P의 포인터가 G의 자식 노드 C를 가리키게 설정해야 한다. (G가 P의 왼쪽 자식이라면 C를 P의 왼쪽 자식으로, 오른쪽 자식이라면 C가 P의 오른쪽 자식이 되도록 설정)
    3: 삭제하려는 노드의 자식이 2개라면 그 노드를 직접 삭제하지 않는다. 삭제하려는 노드 G의 왼쪽 서브트리 중 제일 큰 키값을 가진 노드 K를 찾는다. 그 후 'K의 키 값을 G에 복사한다(덮는다)'. 그러면 삭제하려던 노드 G의 기존 데이터는 사라지게 되어 삭제한 것과 같은 효과를 낸다. 
      그리고 난 뒤에, 현재 G의 키값을 원래 가지고 있던 K노드를 대신 삭제한다. 이 때 K가 가지고 있는 자식 노드의 수에 따라 1, 2, 3번을 택하여 삭제한다.
  */
	public boolean remove(K key) {
		Node<K,V> p = root;								// 스캔 중인  노드
		Node<K,V> parent = null;						// 스캔 중인  노드의 부모 노드
		boolean isLeftChild = true;						// p는 parent의 왼쪽 자식 노드인가?

    // part1 : 삭제할 키값을 가진 노드를 검색함. 없다면 함수를 종료하고, 찾았다면 p에 그 노드를 저장
		while (true) {
			if (p == null)								
				return false;							
			int cond = comp(key, p.getKey());			
			if (cond == 0)								
				break;									
			else {
				parent = p;								
				if (cond < 0) {							
					isLeftChild = true;					
					p = p.left;							
				} else {								
					isLeftChild = false;				
					p = p.right;						
				}
			}
		}

    // part2 : 자식이 1개인 경우
		if (p.left == null) {							
			if (p == root)					 
				root = p.right;
			else if (isLeftChild)
				parent.left  = p.right;					
			else
				parent.right = p.right;					
		} else if (p.right == null) {					
			if (p == root)
				root = p.left;
			else if (isLeftChild)
				parent.left  = p.left;					
			else
				parent.right = p.left;					
		} else {
    // 자식이 2개인 경우
			parent = p;
			Node<K,V> left = p.left;					
			isLeftChild = true;
      // 왼쪽 서브트리에서 가장 큰 키값을 가지는 노드를 찾음 while문이 종료되면 left는 왼쪽 서브트리 중 가장 큰 값을 지닌 노드를 가리킴
			while (left.right != null) {				
				parent = left;
				left = left.right;
				isLeftChild = false;
			}
			p.key  = left.key;							
			p.data = left.data;							
			if (isLeftChild)
				parent.left  = left.left;				
			else
				parent.right = left.left;				
		}
		return true;
	}

	// node를 루트로 하는 서브 트리의 노드를 키 값의 오름차순으로 출력
	private void printSubTree(Node node) {
		if (node != null) {
			printSubTree(node.left);								// 왼쪽 서브 트리를 키 값의 오름차순으로 출력
			System.out.println(node.key + " " + node.data);			// node를 출력
			printSubTree(node.right);								// 오른쪽 서브 트리를 키 값의 오름차순으로 출력
		}
	}

	// 모든 노드를 키 값의 오름차순으로 출력
	public void print() {
		printSubTree(root);
	}
}
```

3번의 경우(자식 노드가 2개 있는 노드를 삭제), 알고리즘 스터디 교재에서는 같은 값을 가지는 노드가 없다고 가정하여 왼쪽 서브트리의 가장 큰 노드의 값을 복사해주었다. 하지만 같은 값이 있다고 가정할 경우(즉, 기준 노드의 오른쪽에 위치한 노드들의 키값은 기준노드의 키값과 같거나 보다 큰 경우) 왼쪽 서브트리의 가장 큰 노드 키값을 복사할 경우 BST의 정의가 깨질 수 있으므로 **오른쪽 서브트리의 가장 작은 키값을 가진 노드**를 찾아주어야 한다. 따라서 자료구조 수업에서는 가장 작은 키값을 가진 노드를 찾아주는 getMin()를 활용하여 BST의 remove를 구현했다.