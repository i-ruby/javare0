package work.iruby.leetcode;


import work.iruby.leetcode.common.ListNode;

/**
 * @author Ruby
 */
public class SomeThings {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        System.out.println(isCircle(node1));

    }

    private static boolean isCircle(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        ListNode slow = node;
        ListNode fast = node.next;
        while (slow != fast) {
            slow = slow.next;
            if (fast.next == null || fast.next.next == null){
                return false;
            }
            fast = fast.next.next;
        }
        return true;
    }

}
