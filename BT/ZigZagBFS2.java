package DSA.BT;

import java.util.*;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ZigZagBFS2 {
    public List<List<Integer>> traversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.offer(root);
        boolean flag = false;

        while (!levelNodes.isEmpty()) {
            int levelSize = levelNodes.size();
            List<Integer> LevelList = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                if (!flag) {
                    TreeNode node = levelNodes.pollFirst();
                    LevelList.add(node.val);

                    if (node.left != null) {
                        levelNodes.offerLast(node.left);
                    }
                    if (node.right != null) {
                        levelNodes.offerLast(node.right);
                    }

                } else {
                    TreeNode node = levelNodes.pollLast();
                    LevelList.add(node.val);

                    if (node.right != null) {
                        levelNodes.offerFirst(node.right);
                    }

                    if (node.left != null) {
                        levelNodes.offerFirst(node.left);
                    }
                }
            }
            flag = !flag;
            result.add(LevelList);

        }
        return result;

    }

    public static void main(String[] args) {

        ZigZagBFS2 tree = new ZigZagBFS2();

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans = tree.traversal(root);

        System.out.println(ans);
    }
}