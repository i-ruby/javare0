package work.iruby.leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public static ListNode of(int[] ints) {
        ListNode p = new ListNode(-1, null);
        ListNode q = p;
        for (int anInt : ints) {
            q.next = new ListNode(anInt);
            q = q.next;
        }
        return p.next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}

