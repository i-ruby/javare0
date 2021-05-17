package work.iruby.nowcoder.jz;

import work.iruby.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;


public class JZ13 {
    public ListNode FindKthToTail(ListNode pHead, int k) {
        if (k <= 0) {
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while (pHead != null) {
            list.add(pHead);
            pHead = pHead.next;
        }
        return k > list.size() ? null : list.get(list.size() - k);
    }

    static class Test {
        public static void main(String[] args) {
            JZ13 test = new JZ13();
            long start = System.currentTimeMillis();
            ListNode n5 = new ListNode(5);
            ListNode n4 = new ListNode(4, n5);
            ListNode n3 = new ListNode(3, n4);
            ListNode n2 = new ListNode(2, n3);
            ListNode n1 = new ListNode(1, n2);
            test.FindKthToTail(n1, 0);
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }
}