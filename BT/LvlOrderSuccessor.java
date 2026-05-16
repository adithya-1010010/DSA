package DSA.BT;

import java.util.*;

public class LvlOrderSuccessor {
    public TreeNode levelOrder(TreeNode root, int target) {
        TreeNode result = root;
        if (root == null) {
            return result;
        }

        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.offer(root);
        int num = root.val;

        while (!levelNodes.isEmpty()) {
            int levelSize = levelNodes.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currTreeNode = levelNodes.poll();
                num = currTreeNode.val;
                if (currTreeNode.left != null) {
                    levelNodes.offer(currTreeNode.left);
                }

                if (currTreeNode.right != null) {
                    levelNodes.offer(currTreeNode.right);
                }
            }

        }
        if (num == target) {
        }
        return result;
    }
}