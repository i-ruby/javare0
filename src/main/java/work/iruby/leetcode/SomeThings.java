package work.iruby.leetcode;


import work.iruby.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

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
        //System.out.println(isCircle(node1));

        //System.out.println(binarySearchFindLeft(new int[]{-1, 0, 3, 5, 9, 12}, 1));
        SomeThings someThings = new SomeThings();
        System.out.println(someThings.generateParenthesis(4));

    }

    private static int binarySearch(int[] arr, int tar) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (arr[mid] == tar) {
                return mid;
            }
            if (arr[mid] > tar) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchFindLeft(int[] arr, int tar) {
        int start = 0, end = arr.length;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (arr[mid] == tar) {
                end = mid;
            } else if (arr[mid] > tar) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    private static boolean isCircle(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }
        ListNode slow = node;
        ListNode fast = node.next;
        while (slow != fast) {
            slow = slow.next;
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
        }
        return true;
    }

    List<String> stringList = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int l = 0, r = 0;
        String s = "";
        test("", 0, 0, n);
        return stringList;
    }
    private void test(String s, int l, int r, int n) {
        if (l >= r && l < n) {
            test(s + "(", l + 1, r, n);
            test(s + ")", l, r + 1, n);
        } else if (l >= r && l == n) {
            test(s + ")", l, r + 1, n);
        }
        if (l == r && l == n) {
            stringList.add(s);
        }
    }

}
