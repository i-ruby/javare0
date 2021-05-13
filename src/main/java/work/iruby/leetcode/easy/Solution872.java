package work.iruby.leetcode.easy;//请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
//
// 
//
// 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。 
//
// 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。 
//
// 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,nul
//l,null,null,null,9,8]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root1 = [1], root2 = [1]
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：root1 = [1], root2 = [2]
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：root1 = [1,2], root2 = [2,2]
//输出：true
// 
//
// 示例 5： 
//
// 
//
// 
//输入：root1 = [1,2,3], root2 = [1,3,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定的两棵树可能会有 1 到 200 个结点。 
// 给定的两棵树上的值介于 0 到 200 之间。 
// 
// Related Topics 树 深度优先搜索 
// 👍 154 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.google.common.collect.Lists;
import com.google.common.collect.Multisets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution872 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(3);

        node4.right = node5;
        node4.left = node6;

        Solution872 solution872 = new Solution872();
        System.out.println(solution872.leafSimilar(node1,node4));
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        isLeaf(leaf1, root1);
        isLeaf(leaf2, root2);
        return leaf1.equals(leaf2);
    }

    private void isLeaf(List<Integer> leaf, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            leaf.add(node.val);
            return;
        }
        isLeaf(leaf, node.left);
        isLeaf(leaf, node.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
