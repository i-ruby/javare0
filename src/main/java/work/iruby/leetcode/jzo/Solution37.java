package work.iruby.leetcode.jzo;//请实现两个函数，分别用来序列化和反序列化二叉树。
//
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
//符串反序列化为原始的树结构。 
//
// 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
//法解决这个问题。 
//
// 
//
// 示例： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-b
//inary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 
// 👍 205 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import work.iruby.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution37 {
    static class Test {
        public static void main(String[] args) {
            Solution37 test = new Solution37();
            long start = System.currentTimeMillis();
            String serialize = test.serialize(TreeNode.of(new Integer[]{1, 2, null, null, 3}));
            System.out.println(serialize);
            TreeNode treeNode = test.deserialize(serialize);
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringJoiner stringJoiner = new StringJoiner(",");
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode poll = queue.poll();
            stringJoiner.add(node2Val(poll));
            if (poll != null) {
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return stringJoiner.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = val2Node(split[0]), left = null, right = null;
        queue.add(root);
        int remnant = 0;
        for (int i = 1; i < split.length; i++) {
            if (i % 2 == 0) {
                right = val2Node(split[i]);
            } else {
                left = val2Node(split[i]);
            }
            remnant++;
            if (remnant == 2) {
                remnant = connectNode(queue, remnant, left, right);
            }
        }
        connectNode(queue, remnant, left, right);
        return root;
    }

    private int connectNode(Queue<TreeNode> queue, int remnant, TreeNode left, TreeNode right) {
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

    private static String node2Val(TreeNode node) {
        if (node == null) {
            return "n";
        } else {
            return node.val + "";
        }
    }

    private static TreeNode val2Node(String val) {
        if ("n".equals(val)) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(val));
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)
