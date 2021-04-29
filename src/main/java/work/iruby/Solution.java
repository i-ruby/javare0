package work.iruby;


import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = {0, 1};
        if (nums.length == 2) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.putIfAbsent(nums[i], i);
        }
        return res;
    }


    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuilder stringBuilder = new StringBuilder();
        char ch ;
        for (int i = 0; i < s.length(); ) {
            int count = 0;
            ch = s.charAt(i);
            while (i < s.length() && s.charAt(i) == ch) {
                i++;
                count++;
            }
            stringBuilder.append(count).append(ch);
        }
        return stringBuilder.toString();
    }

}
