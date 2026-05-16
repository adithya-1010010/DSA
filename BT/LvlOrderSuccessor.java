package DSA.BT;

import java.util.*;

public class LvlOrderSuccessor {
    public TreeNode levelOrder(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currTreeNode = queue.poll();
            if (currTreeNode.left != null) {
                queue.offer(currTreeNode.left);
            }

            if (currTreeNode.right != null) {
                queue.offer(currTreeNode.right);
            }

            if (currTreeNode.val == target) {
                break;
            }
        }
        return queue.peek();

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

        LvlOrderSuccessor l1 = new LvlOrderSuccessor();
        System.out.println(l1.levelOrder(root, 2).val);

    }
}