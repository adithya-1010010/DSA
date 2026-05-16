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

public class BFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> levelNodes = new LinkedList<>();
        levelNodes.offer(root);

        while (!levelNodes.isEmpty()) {
            int levelSize = levelNodes.size();
            List<Integer> LevelList = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode currTreeNode = levelNodes.poll();
                LevelList.add(currTreeNode.val);

                if (currTreeNode.left != null) {
                    levelNodes.offer(currTreeNode.left);
                }

                if (currTreeNode.right != null) {
                    levelNodes.offer(currTreeNode.right);
                }
            }
            result.add(LevelList);

        }
        return result;

    }
}