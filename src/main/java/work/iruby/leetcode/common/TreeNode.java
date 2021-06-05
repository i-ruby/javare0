package work.iruby.leetcode.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    /**
     * [1,2,3,null,4,null,5]
     * *      1
     * *     /\
     * *    2  3
     * *    \   \
     * *    4    5
     *
     * @param integers 输入数组
     * @return 输出树的根
     */
    public static TreeNode of(Integer[] integers) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = getNode(integers[0]);
        queue.add(root);
        int remnant = 0;
        TreeNode left = null;
        TreeNode right = null;
        for (int i = 1; i < integers.length; i++) {
            if (i % 2 == 0) {
                right = getNode(integers[i]);
            } else {
                left = getNode(integers[i]);
            }
            remnant++;
            if (remnant == 2) {
                remnant = connectNode(queue, remnant, left, right);
            }
        }
        connectNode(queue, remnant, left, right);
        return root;
    }

    private static int connectNode(Queue<TreeNode> queue, int remnant, TreeNode left, TreeNode right) {
        TreeNode node = queue.poll();
        if (node == null) {
            return 0;
        }
        switch (remnant) {
            case 2: {
                node.right = right;
            }
            case 1: {
                node.left = left;
            }
            default:
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
                remnant = 0;
        }
        return remnant;
    }

    private static TreeNode getNode(Integer val) {
        if (val == null) {
            return null;
        } else {
            return new TreeNode(val);
        }
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}