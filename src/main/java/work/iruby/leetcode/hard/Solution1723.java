package work.iruby.leetcode.hard;//给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
//
// 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你
//设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。 
//
// 返回分配方案中尽可能 最小 的 最大工作时间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：jobs = [3,2,3], k = 3
//输出：3
//解释：给每位工人分配一项工作，最大工作时间是 3 。
// 
//
// 示例 2： 
//
// 
//输入：jobs = [1,2,4,7,8], k = 2
//输出：11
//解释：按下述方式分配工作：
//1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
//2 号工人：4、7（工作时间 = 4 + 7 = 11）
//最大工作时间是 11 。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= jobs.length <= 12 
// 1 <= jobs[i] <= 107 
// 
// Related Topics 递归 回溯算法 
// 👍 91 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1723 {

    int maxIndex = 0;

    public int minimumTimeRequired(int[] jobs, int k) {
        int[] p = new int[k];
        int maxMin = 0;
        for (int i = 0; i < jobs.length; i++) {
            maxMin = distributeJob(jobs[jobs.length - 1 - i], p);
        }
        return maxMin;
    }

    private int distributeJob(int job, int[] p) {
        int minIndex = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] == 0) {
                minIndex = i;
                break;
            }
            if (p[i] < p[minIndex]) {
                minIndex = i;
            } else {
                maxIndex = i;
            }
        }
        p[minIndex] += job;
        if (p[minIndex] > p[maxIndex]) {
            maxIndex = minIndex;
        }
        return p[maxIndex];
    }

    public static void main(String[] args) {
        Solution1723 solution1723 = new Solution1723();
        System.out.println(solution1723.minimumTimeRequired(new int[]{19, 12, 10}, 2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
