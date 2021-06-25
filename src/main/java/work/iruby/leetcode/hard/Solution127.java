package work.iruby.leetcode.hard;//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 哈希表 字符串 
// 👍 782 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution127 {
    static class Test {
        public static void main(String[] args) {
            Solution127 test = new Solution127();
            long start = System.currentTimeMillis();
            System.out.println(test.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<Character, Set<String>> wordMap = new HashMap<>();
        for (String word : wordList) {
            char head = word.charAt(0);
            Set<String> set = wordMap.get(head);
            if (set == null) {
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(word);
                wordMap.put(head, hashSet);
            } else {
                set.add(word);
            }
        }

        Map<String, Integer> beginMap = new HashMap<>(), endMap = new HashMap<>();
        beginMap.put(beginWord, 0);
        endMap.put(endWord, 0);

        Queue<String> beginQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        beginQueue.offer(beginWord);
        endQueue.offer(endWord);
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int res = -1;
            if (beginMap.size() < endMap.size()) {
                res = update(beginQueue, wordMap, beginMap, endMap, true);
            } else {
                res = update(endQueue, wordMap, endMap, beginMap, false);
            }
            if (res != -1) {
                return res;
            }
        }
        return -1;
    }

    private int update(Queue<String> curQueue, Map<Character, Set<String>> wordMap, Map<String, Integer> curMap, Map<String, Integer> otherMap, boolean beginToEnd) {
        String poll = curQueue.poll();
        int length = curMap.get(poll);
        char target;
        if (beginToEnd) {
            target = poll.charAt(poll.length() - 1);
        } else {
            target = poll.charAt(0);
        }

        Set<String> wordSet = wordMap.get(target);
        for (String word : wordSet) {
            if (otherMap.get(word) != null) {
                return otherMap.get(word) + length;
            }
            if (!curMap.containsKey(word)) {
                curMap.put(word, length + 1);
            }
        }
        return -1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
