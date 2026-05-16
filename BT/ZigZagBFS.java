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

public class ZigZagBFS {
    public List<List<Integer>> ZigZagTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.offer(root);

        while (!levelNodes.isEmpty()) {

            int levelSize = levelNodes.size();

            List<Integer> levelList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {

                TreeNode currTreeNode = levelNodes.poll();

                levelList.add(currTreeNode.val);

                if (currTreeNode.left != null) {
                    levelNodes.offer(currTreeNode.left);
                }

                if (currTreeNode.right != null) {
                    levelNodes.offer(currTreeNode.right);
                }
            }

            result.add(levelList);
        }
        int flag = 0;

        for (int i = 0; i < result.size(); i++) {

            if (++flag % 2 == 0) {
                Collections.reverse(result.get(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        ZigZagBFS tree = new ZigZagBFS();

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> ans = tree.ZigZagTraversal(root);

        System.out.println(ans);
    }
}