import java.io.*;
import java.util.*;

class Node {
    List<Node> nodes = new ArrayList<>();
    Boolean bipartite;

    public void append(Node node) {
        nodes.add(node);
    }
}

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static Node[] nodes;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            nodes = new Node[V+1];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                nodes[n1] = nodes[n1] == null ? new Node() : nodes[n1];
                nodes[n2] = nodes[n2] == null ? new Node() : nodes[n2];

                nodes[n1].append(nodes[n2]);
                nodes[n2].append(nodes[n1]);
            }

            bfs();
        }

        System.out.println(sb);
        br.close();
    }

    public static void bfs() {

        for (int i = 1; i < nodes.length; i++) {

            Node root = nodes[i];

            if (root == null || root.bipartite != null)
                continue;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            root.bipartite = true;

            while (!queue.isEmpty()) {
                Node node = queue.poll();

                if (node.bipartite == null)
                    continue;

                for (Node next: node.nodes) {
                    // 만약 이분 그래프가 아니면 break
                    if (next.bipartite == node.bipartite) {
                        sb.append("NO").append("\n");
                        return;
                    }

                    if (next.bipartite == null) {
                        next.bipartite = !node.bipartite;
                        queue.add(next);
                    }
                }
            }
        }

        sb.append("YES").append("\n");
    }
}