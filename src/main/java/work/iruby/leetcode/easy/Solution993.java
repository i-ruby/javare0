package work.iruby.leetcode.easy;//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 广度优先搜索 
// 👍 155 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import work.iruby.leetcode.common.TreeNode;

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
class Solution993 {

    static class Test {
        public static void main(String[] args) {
            TreeNode node2 = new TreeNode(3);
            TreeNode node3 = new TreeNode(2);
            TreeNode node1 = new TreeNode(1, node2, node3);
            Solution993 solution993 = new Solution993();
            System.out.println(solution993.isCousins(node1, 2, 4));
        }
    }

    int[] x1 = new int[2];
    int[] y1 = new int[2];

    public boolean isCousins(TreeNode root, int x, int y) {
        bfs(root, x, y, 1, -1);
        return (x1[0] != y1[0]) && (x1[1] == y1[1]);
    }

    private void bfs(TreeNode root, int x, int y, int depth, int parent) {
        if (root == null){
            return;
        }
        if (root.val == x) {
            x1[0] = parent;
            x1[1] = depth;
        }
        if (root.val == y) {
            y1[0] = parent;
            y1[1] = depth;
        }
        bfs(root.left, x, y, depth + 1, root.val);
        bfs(root.right, x, y, depth + 1, root.val);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
