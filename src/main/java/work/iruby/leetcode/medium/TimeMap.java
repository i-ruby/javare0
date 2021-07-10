package work.iruby.leetcode.medium;//创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
//
// 1. set(string key, string value, int timestamp) 
//
// 
// 存储键 key、值 value，以及给定的时间戳 timestamp。 
// 
//
// 2. get(string key, int timestamp) 
//
// 
// 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。 
//
// 如果有多个这样的值，则返回对应最大的 timestamp_prev 的那个值。 
// 如果没有值，则返回空字符串（""）。 
// 
//
// 
//
// 示例 1： 
//
// 输入：inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["f
//oo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
//输出：[null,null,"bar","bar",null,"bar2","bar2"]
//解释：  
//TimeMap kv;   
//kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1   
//kv.get("foo", 1);  // 输出 "bar"   
//kv.get("foo", 3); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即
// "bar"）   
//kv.set("foo", "bar2", 4);   
//kv.get("foo", 4); // 输出 "bar2"   
//kv.get("foo", 5); // 输出 "bar2"   
//
// 
//
// 示例 2： 
//
// 输入：inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [
//[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["lov
//e",20],["love",25]]
//输出：[null,null,null,"","high","high","low","low"]
// 
//
// 
//
// 提示： 
//
// 
// 所有的键/值字符串都是小写的。 
// 所有的键/值字符串长度都在 [1, 100] 范围内。 
// 所有 TimeMap.set 操作中的时间戳 timestamps 都是严格递增的。 
// 1 <= timestamp <= 10^7 
// TimeMap.set 和 TimeMap.get 函数在每个测试用例中将（组合）调用总计 120000 次。 
// 
// Related Topics 设计 哈希表 字符串 二分查找 
// 👍 121 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class TimeMap {
    Map<String, List<Node>> table;

    public TimeMap() {
        table = new HashMap<>();
    }

    static class Node {
        String key, value;
        int timestamp;

        public Node(String key, String value, int timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public void set(String key, String value, int timestamp) {
        if (table.containsKey(key)) {
            table.get(key).add(new Node(key, value, timestamp));
        } else {
            List<Node> list = new ArrayList<>();
            list.add(new Node(key, value, timestamp));
            table.put(key, list);
        }
    }

    public String get(String key, int timestamp) {
        if (table.containsKey(key)) {
            //因为规定是时间严格递增, 使用二分查找
            List<Node> nodeList = table.get(key);
            int left = 0, right = nodeList.size() - 1;
            if (nodeList.get(left).timestamp > timestamp) {
                return "";
            } else {
                while (left < right) {
                    //使用上边界作为中点,避免死循环
                    int mid = (left + right + 1) / 2;
                    Node midNode = nodeList.get(mid);
                    if (midNode.timestamp == timestamp) {
                        return midNode.value;
                    } else if (midNode.timestamp < timestamp) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                return nodeList.get(right).value;
            }

        } else {
            return "";
        }
    }

    static class Test {
        public static void main(String[] args) {
            TimeMap test = new TimeMap();
            long start = System.currentTimeMillis();
            test.set("foo", "bar", 1);
            System.out.println(test.get("foo", 1));
            System.out.println(test.get("foo", 3));
            test.set("foo", "bar2", 4);
            System.out.println(test.get("foo", 4));
            System.out.println(test.get("foo", 5));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)
