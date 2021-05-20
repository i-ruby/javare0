package work.iruby.leetcode.medium;//给一非空的单词列表，返回前 k 个出现次数最多的单词。
//
// 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。 
//
// 示例 1： 
//
// 
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//    注意，按字母顺序 "i" 在 "love" 之前。
// 
//
// 
//
// 示例 2： 
//
// 
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k
// = 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//    出现次数依次为 4, 3, 2 和 1 次。
// 
//
// 
//
// 注意： 
//
// 
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。 
// 
//
// 
//
// 扩展练习： 
//
// 
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。 
// 
// Related Topics 堆 字典树 哈希表 
// 👍 279 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution692 {
    private static int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        if (a.getValue() > b.getValue()) {
            return 1;
        } else if (a.getValue() < b.getValue()) {
            return -1;
        } else {
            return a.getKey().compareTo(b.getKey());
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }
        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, Solution692::compare);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry);
            } else {
                if (Solution692.compare(queue.peek(), entry) < 0) {
                    queue.poll();
                    queue.add(entry);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            ans.add(queue.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;
    }

    static class Test {
        public static void main(String[] args) {
            Solution692 test = new Solution692();
            long start = System.currentTimeMillis();
            System.out.println(test.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
