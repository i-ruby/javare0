package work.iruby.leetcode.medium;//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
//
// 示例 1: 
//
// 
//输入:
//"tree"
//
//输出:
//"eert"
//
//解释:
//'e'出现两次，'r'和't'都只出现一次。
//因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
// 
//
// 示例 2: 
//
// 
//输入:
//"cccaaa"
//
//输出:
//"cccaaa"
//
//解释:
//'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//注意"cacaca"是不正确的，因为相同的字母必须放在一起。
// 
//
// 示例 3: 
//
// 
//输入:
//"Aabb"
//
//输出:
//"bbAa"
//
//解释:
//此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//注意'A'和'a'被认为是两种不同的字符。
// 
// Related Topics 哈希表 字符串 桶排序 计数 排序 堆（优先队列） 
// 👍 277 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution451 {
    static class Test {
        public static void main(String[] args) {
            Solution451 test = new Solution451();
            long start = System.currentTimeMillis();
            System.out.println(test.frequencySort("Aabb"));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((e1, e2) -> {
            if (!e1.getValue().equals(e2.getValue())) {
                return -(e1.getValue() - e2.getValue());
            } else {
                return e1.getKey().compareTo(e2.getKey());
            }
        });

        queue.addAll(map.entrySet());
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> poll = queue.poll();
            for (int i = 0; i < poll.getValue(); i++) {
                stringBuilder.append(poll.getKey());
            }
        }

        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
