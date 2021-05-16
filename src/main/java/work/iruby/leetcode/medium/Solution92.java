package work.iruby.leetcode.medium;//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 903 👎 0


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
class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        for (int i = 1; i < left; i++) {
            preNode = preNode.next;
        }
        ListNode curNode = preNode.next;
        ListNode nextNode;
        for (int i = 0; i < right - left; i++) {
            nextNode = curNode.next;
            curNode.next = nextNode.next;
            nextNode.next = preNode.next;
            preNode.next = nextNode;
        }
        return dummyNode.next;
    }

    static class Test {
        public static void main(String[] args) {
            Solution92 solution92 = new Solution92();
            ListNode node5 = new ListNode(5);
            ListNode node4 = new ListNode(4, node5);
            ListNode node3 = new ListNode(3, node4);
            ListNode node2 = new ListNode(2, node3);
            ListNode node1 = new ListNode(1, node2);

            System.out.println(solution92.reverseBetween(node1, 2, 5).val);
            System.out.println();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
