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
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
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


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution127_BugNotFound {

    HashSet<String> wordSet = new HashSet<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        wordSet.addAll(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        //从头方向处理的队列和从尾方向处理的队列
        Queue<String> beginQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        //初始化
        beginQueue.offer(beginWord);
        endQueue.offer(endWord);
        //记录头方向可达的位置的map和距离和记录尾方向可达的位置和距离map
        Map<String, Integer> beginMap = new HashMap<>(), endMap = new HashMap<>();
        //初始化
        beginMap.put(beginWord, 0);
        endMap.put(endWord, 0);
        //如果任意处理队列为空且没有找到通路则无法转换
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int length;
            //从更短的处理队列处理
            if (beginQueue.size() < endQueue.size()) {
                length = update(beginQueue, beginMap, endMap);
            } else {
                length = update(endQueue, endMap, beginMap);
            }
            if (length != -1) {
                return length + 1;
            }
        }
        return 0;
    }

    /**
     * @param curQueue 需要处理的队列
     * @param curMap   处理队列对应的map
     * @param otherMap 另一个map
     * @return 返回连通的长度或者暂没有找到(- 1)
     */
    private int update(Queue<String> curQueue, Map<String, Integer> curMap, Map<String, Integer> otherMap) {
        //当前需要处理的字符
        String poll = curQueue.poll();
        //这个字符在此方向对应的距离
        int length = curMap.get(poll);

        List<String> legalString = filter(poll);
        for (String s : legalString) {

            //此方向记录过
            if (curMap.containsKey(s)) {
                continue;
            }

            //另一个方向可以连通
            if (otherMap.containsKey(s)) {
                return otherMap.get(s) + length + 1;
            } else {
                curMap.put(s, length + 1);
                curQueue.offer(s);
            }
        }

        //这次遍历没有找到通路
        return -1;
    }

    private List<String> filter(String word) {
        List<String> res = new ArrayList<>();
        for (String s : wordSet) {
            if (isLegalString(word, s)) {
                res.add(s);
            }
        }
        return res;
    }

    private boolean isLegalString(String word, String s) {
        int difference = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != s.charAt(i)) {
                difference++;
            }
        }
        return difference == 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
