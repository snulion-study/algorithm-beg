import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        BinTree tree = null;

        for (int i = 0; i < nodeCount; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            char parentNodeKey = stk.nextToken().charAt(0);
            char leftChildNodeKey = stk.nextToken().charAt(0);
            char rightChildNodeKey = stk.nextToken().charAt(0);

            boolean hasLeftChildNode = leftChildNodeKey != '.';
            boolean hasRightChildNode = rightChildNodeKey != '.';

            Node<Character> leftChildNode = null;
            Node<Character> rightChildNode = null;

            if (hasLeftChildNode) {
                leftChildNode = new Node<>(leftChildNodeKey, null, null);
            }
            if (hasRightChildNode) {
                rightChildNode = new Node<>(rightChildNodeKey, null, null);
            }

            Node<Character> parentNode = new Node<>(parentNodeKey, leftChildNode, rightChildNode);


            if (i == 0) {
                tree = new BinTree(parentNode);
            } else {
                tree.addNode(tree.root, parentNode);
            }
        }
        preorder(tree.root);
        System.out.println();
        inorder(tree.root);
        System.out.println();
        postorder(tree.root);
    }

    static class BinTree {
        Node<Character> root;

        BinTree(Node<Character> root) {
            this.root = root;
        }

        public void addNode(Node<Character> root, Node<Character> newNode) {
            boolean hasLeftChildNode = root.left != null;
            boolean hasRightChildNode = root.right != null;

            if (hasLeftChildNode) {
                if (root.left.key == newNode.key) {
                    root.left = newNode;
                } else {
                    addNode(root.left, newNode);
                }
            }

            if (hasRightChildNode) {
                if (root.right.key == newNode.key) {
                    root.right = newNode;
                } else {
                    addNode(root.right, newNode);
                }
            }
        }

    }

    public static void postorder(Node<Character> root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.key);
    }

    public static void preorder(Node<Character> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key);
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node<Character> root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.key);
        inorder(root.right);
    }

    static class Node<Character> {
        char key;
        Node<Character> left;
        Node<Character> right;

        Node(char key, Node<Character> left, Node<Character> right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }
}
