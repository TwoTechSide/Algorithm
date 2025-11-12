import java.io.*;
import java.util.*;

class Node {
    public boolean removed = false;
    public Node up = null;
    public Node down = null;
}

class RemovedNode {
    public Node curNode;
    public Node beforeUpNode;
    public Node beforeDownNode;

    public RemovedNode(Node curNode, Node up, Node down) {
        this.curNode = curNode;
        this.beforeUpNode = up;
        this.beforeDownNode = down;
    }
}

class Solution {
    
    public static String solution(int n, int k, String[] cmd) {
    
        Node[] nodes = new Node[n];

        Deque<RemovedNode> removedNodes = new ArrayDeque<>();

        // 노드 생성 및 연결
        for (int i = 0; i < n; i++) {

            nodes[i] = new Node();

            if (i > 0) {
                nodes[i].up = nodes[i - 1];
                nodes[i - 1].down = nodes[i];
            }
        }

        Node curNode = nodes[k];

        for (String str: cmd) {
            String[] strArr = str.split(" ");

            if (strArr[0].equals("U")) {
                int num = Integer.parseInt(strArr[1]);
                while (num-- > 0) curNode = curNode.up;
            } else if (strArr[0].equals("D")) {
                int num = Integer.parseInt(strArr[1]);
                while (num-- > 0) curNode = curNode.down;
            } else if (strArr[0].equals("C")) {
                curNode.removed = true;
                removedNodes.addFirst(new RemovedNode(curNode, curNode.up, curNode.down));

                if (curNode.down != null) {
                    curNode.down.up = curNode.up;
                    curNode = curNode.down;

                    if (curNode.up != null) {
                        curNode.up.down = curNode;
                    }
                } else {
                    curNode.up.down = null;
                    curNode = curNode.up;
                }
            } else if (strArr[0].equals("Z")) {
                RemovedNode recoveredNode = removedNodes.removeFirst();
                recoveredNode.curNode.removed = false;

                if (recoveredNode.beforeUpNode != null)
                    recoveredNode.beforeUpNode.down = recoveredNode.curNode;

                if (recoveredNode.beforeDownNode != null)
                    recoveredNode.beforeDownNode.up = recoveredNode.curNode;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Node node: nodes)
            sb.append((node.removed) ? "X" : "O");

        return sb.toString();
    }
}