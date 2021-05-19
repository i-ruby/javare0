package work.iruby.nowcoder.jz;

import work.iruby.leetcode.common.ListNode;

public class JZ15 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        while ((list1 != null) || (list2 != null)) {
            if (list1 == null) {
                pre.next = list2;
                break;
            }
            if (list2 == null) {
                pre.next = list1;
                break;
            }
            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        return head.next;
    }

    static class Test {
        public static void main(String[] args) {
            ListNode n5 = new ListNode(5);
            ListNode n4 = new ListNode(4);
            ListNode n3 = new ListNode(3, n5);
            ListNode n2 = new ListNode(2, n4);
            ListNode n1 = new ListNode(1, n3);
            JZ15 test = new JZ15();
            long start = System.currentTimeMillis();
            System.out.println(test.Merge(n1, n2));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }
}