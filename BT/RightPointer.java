package DSA.BT;

import java.util.*;

class Node {

    int val;
    Node left;
    Node right;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class RightPointer {
    public Node pointThestuff(Node root) {
        List<List<Node>> result = new ArrayList<>();

        if (root == null) {
            return null;
        }

        Deque<Node> levelNodes = new LinkedList<>();
        levelNodes.offer(root);

        while (!levelNodes.isEmpty()) {
            int levelSize = levelNodes.size();
            List<Node> LevelList = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                Node currNode = levelNodes.pollLast();
                currNode.next = LevelList.isEmpty() ? null : LevelList.get(0);
                LevelList.add(currNode);

                if (currNode.right != null) {
                    levelNodes.offerFirst(currNode.right);
                }
                if (currNode.left != null) {
                    levelNodes.offerFirst(currNode.left);
                }

            }
            result.add(LevelList);

        }
        return result.get(0).get(0);
    }

    public static void main(String[] args) {

        /*
         * 1
         * / \
         * 2 3
         * / \ /
         * 4 5 6
         */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);

        RightPointer R1 = new RightPointer();
        R1.pointThestuff(root);
        System.out.println(root.left.left.next.val);
    }
}