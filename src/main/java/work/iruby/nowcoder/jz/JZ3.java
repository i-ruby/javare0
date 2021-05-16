package work.iruby.nowcoder.jz; /**
 * public class ListNode {
 * int val;
 * ListNode next = null;
 * <p>
 * ListNode(int val) {
 * this.val = val;
 * }
 * }
 */

import work.iruby.leetcode.common.ListNode;

import java.util.ArrayList;

public class JZ3 {
    static class Test {
        public static void main(String[] args) {
            JZ3 jz3 = new JZ3();
            ListNode node2 = new ListNode(2);
            ListNode node1 = new ListNode(1, node2);
            System.out.println(jz3.printListFromTailToHead(node1));
        }
    }

    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null){
            return res;
        }
        printListFromTailToHead(listNode.next);
        res.add(listNode.val);
        return res;
    }

}