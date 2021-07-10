package work.iruby.leetcode.medium;//大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
//
// 你可以搭配 任意 两道餐品做一顿大餐。 
//
// 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大
//餐 的数量。结果需要对 109 + 7 取余。 
//
// 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。 
//
// 
//
// 示例 1： 
//
// 
//输入：deliciousness = [1,3,5,7,9]
//输出：4
//解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
//它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
// 
//
// 示例 2： 
//
// 
//输入：deliciousness = [1,1,1,3,3,3,7]
//输出：15
//解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。 
//
// 
//
// 提示： 
//
// 
// 1 <= deliciousness.length <= 105 
// 0 <= deliciousness[i] <= 220 
// 
// Related Topics 数组 哈希表 
// 👍 87 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1711 {
    static class Test {
        public static void main(String[] args) {
            Solution1711 test = new Solution1711();
            long start = System.currentTimeMillis();
            System.out.println(test.countPairs(new int[]{2160, 1936, 3, 29, 27, 5, 2503, 1593, 2, 0, 16, 0, 3860, 28908, 6, 2, 15, 49, 6246, 1946, 23, 105, 7996, 196, 0, 2, 55, 457, 5, 3, 924, 7268, 16, 48, 4, 0, 12, 116, 2628, 1468}));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }

    public int countPairs(int[] deliciousness) {
        Set<Integer> delicious = new HashSet<>();
        Set<Integer> bitter = new HashSet<>();
        int MOD = 1000000007;

        Map<Integer, Integer> pretreatment = new HashMap<>();
        for (int k : deliciousness) {
            pretreatment.put(k, pretreatment.getOrDefault(k, 0) + 1);
        }

        int count = 0;
        List<Integer> key = new ArrayList<>(pretreatment.keySet());
        for (int i = 0; i < key.size(); i++) {
            for (int j = i; j < key.size(); j++) {
                // 两种餐品的美味值
                int curVal = key.get(i);
                int othVal = key.get(j);
                // 两种餐品的数量
                int curNum = pretreatment.get(curVal);
                int othNum = pretreatment.get(othVal);
                //两种餐品组合的美味值
                int sumVal = curVal + othVal;
                //如果是同种餐品
                if (curVal == othVal) {
                    if (curNum > 1) {
                        if (isDelicious(delicious, bitter, sumVal)) {
                            System.out.println(sumVal);
                            count = (count + (curNum - 1) * curNum / 2 % MOD) % MOD;
                        }
                    }
                } else {
                    if (isDelicious(delicious, bitter, sumVal)) {
                        System.out.println(sumVal);
                        count = (count + othNum * curNum % MOD) % MOD;
                    }
                }
            }
        }
        return count;
    }

    private boolean isDelicious(Set<Integer> delicious, Set<Integer> bitter, int sumVal) {
        if (!bitter.contains(sumVal)) {
            if (delicious.contains(sumVal)) {
                return true;
            } else {
                //需要计算是不是大餐
                if (calculateDelicious(sumVal)) {
                    delicious.add(sumVal);
                    return true;
                } else {
                    bitter.add(sumVal);
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    private boolean calculateDelicious(int sumVal) {
        if (sumVal == 1) {
            return true;
        }
        if (sumVal == 0) {
            return false;
        }
        while (sumVal % 2 == 0) {
            sumVal /= 2;
            if (sumVal == 1) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
