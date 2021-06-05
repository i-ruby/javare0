package work.iruby.leetcode.easy;//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点在范围 [0, 104] 内 
// 1 <= Node.val <= 50 
// 0 <= k <= 50 
// 
// Related Topics 链表 
// 👍 616 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import work.iruby.leetcode.common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode p = new ListNode(-1, head);
        ListNode q = p;
        while (head != null) {
            if (head.val == val) {
                q.next = head.next;
            } else {
                q = q.next;
            }
            head = head.next;
        }
        return p.next;
    }

    static class Test {
        public static void main(String[] args) {
            Solution203 test = new Solution203();
            long start = System.currentTimeMillis();
            System.out.println(test.removeElements(ListNode.of(new int[]{1, 2, 3, 4, 5, 6, 5}), 5));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
