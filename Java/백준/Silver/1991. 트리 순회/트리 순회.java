import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 노드 리스트 생성
        Node head = new Node('A');

        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            char value = str[0].charAt(0);
            char left = str[1].charAt(0);
            char right = str[2].charAt(0);

            insertNode(head, value, left, right);
        }

        preorder(head);
        sb.append("\n");

        inorder(head);
        sb.append("\n");

        postorder(head);
        sb.append("\n");

        bw.write(sb+"\n");
        bw.flush();

        br.close();
        bw.close();
    }

    public static void insertNode(Node root, char value, char left, char right) {

        if (root.value == value) {
            if (left != '.') root.left = new Node(left);
            if (right != '.') root.right = new Node(right);
        }
        else {
            if (root.left != null) insertNode(root.left, value, left, right);
            if (root.right != null) insertNode(root.right, value, left, right);
        }
    }

    public static void preorder(Node node) {
        if (node == null) return;
        sb.append(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        sb.append(node.value);
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.value);
    }
}