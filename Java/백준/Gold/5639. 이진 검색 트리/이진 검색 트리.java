import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static final StringBuilder sb = new StringBuilder();

	public static class Node {
		int value;
		Node left = null;
		Node right = null;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Node root = new Node(Integer.parseInt(br.readLine()));
		String line;

		while ((line = br.readLine()) != null && !line.isEmpty())
			insertNode(root, Integer.parseInt(line));

		printNode(root);
		System.out.println(sb);
	}

	public static void insertNode(Node root, int value) {

		Node node = new Node(value);

		while (true) {
			if (value < root.value) {
				if (root.left == null) {
					root.left = node;
					return;
				}
				root = root.left;
			}
			if (value > root.value) {
				if (root.right == null) {
					root.right = node;
					return;
				}
				root = root.right;
			}
		}
	}

	public static void printNode(Node root) {
		if (root != null) {
			printNode(root.left);
			printNode(root.right);
			sb.append(root.value).append("\n");
		}
	}
}