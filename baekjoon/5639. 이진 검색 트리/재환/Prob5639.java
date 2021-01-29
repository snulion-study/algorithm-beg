import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinTree resultTree = new BinTree();
        String str = "";

        while((str = br.readLine()) != null && str.length() != 0) {
            int key = Integer.parseInt(str);
            Node<Integer> newNode = new Node(key, null, null);
            resultTree.addNode(resultTree.root, newNode);
        }
        postorder(resultTree.root);
    }

    static class BinTree {
        Node<Integer> root;

        BinTree() {
            root = null;
        }

        public void addNode(Node<Integer> root, Node<Integer> newNode) {
            if (root == null) {
                this.root = newNode;
                return;
            }

            boolean isLeftSubtreeNode = root.key > newNode.key;
            boolean hasLeftChildNode = root.left != null;
            boolean hasRightChildNode = root.right != null;
            if (isLeftSubtreeNode) {
                if (hasLeftChildNode) {
                    addNode(root.left, newNode);
                }
                else {
                    root.left = newNode;
                }
            }
            else {
                if (hasRightChildNode) {
                    addNode(root.right, newNode);
                }
                else {
                    root.right = newNode;
                }
            }
        }

    }

    public static void postorder(Node<Integer> root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.key);
    }

    static class Node<Integer> {
        int key;
        Node<Integer> left;
        Node<Integer> right;

        Node(int key, Node<Integer> left, Node<Integer> right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }
}
