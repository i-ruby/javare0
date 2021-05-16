package work.iruby.nowcoder.jz;

import work.iruby.leetcode.common.TreeNode;

import java.util.Arrays;

public class JZ4 {
    static class Test {
        public static void main(String[] args) {
            JZ4 jz4 = new JZ4();
            TreeNode tree = jz4.reConstructBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{3, 2, 4, 1, 6, 5, 7});
            System.out.println(tree);
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        TreeNode root = new TreeNode(pre[0]);
        int index = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                index = i;
                break;
            }
        }
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index + 1),
                Arrays.copyOfRange(in, 0, index));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, pre.length),
                Arrays.copyOfRange(in, index + 1, in.length));
        return root;
    }
}