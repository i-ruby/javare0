package work.iruby.nowcoder.jz;

import work.iruby.leetcode.common.ListNode;

public class JZ14 {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cache ;
        while (head != null) {
            cache = head.next;
            head.next = pre;
            pre = head;
            head = cache;
        }
        return pre;
    }

    static class Test {
        public static void main(String[] args) {
            JZ14 test = new JZ14();
            long start = System.currentTimeMillis();
//            ListNode n5 = new ListNode(5);
//            ListNode n4 = new ListNode(4, n5);
            ListNode n3 = new ListNode(3);
            ListNode n2 = new ListNode(2, n3);
            ListNode n1 = new ListNode(1, n2);
            test.ReverseList(n1);
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }
}