package BT;

import java.util.*;

public class AvgOfLevels {
    public List<Double> levelOrder(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.offer(root);

        while (!levelNodes.isEmpty()) {
            int levelSize = levelNodes.size();
            double valSum = 0;
            double count = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currTreeNode = levelNodes.poll();
                valSum += currTreeNode.val;
                count++;

                if (currTreeNode.left != null) {
                    levelNodes.offer(currTreeNode.left);
                }

                if (currTreeNode.right != null) {
                    levelNodes.offer(currTreeNode.right);
                }
            }
            result.add(valSum / count);

        }
        return result;

    }

    public static void main(String[] args) {

        /*
         * 1
         * / \
         * 2 3
         * / \ /
         * 4 5 6
         */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);

        AvgOfLevels B1 = new AvgOfLevels();
        List<Double> res = B1.levelOrder(root);
        System.out.println(res);

    }
}