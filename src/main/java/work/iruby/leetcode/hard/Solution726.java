package work.iruby.leetcode.hard;//给定一个化学式formula（作为字符串），返回每种原子的数量。
//
// 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。 
//
// 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
// 
//
// 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。 
//
// 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。 
//
// 给定一个化学式 formula ，返回所有原子的数量。格式为：第一个（按字典序）原子的名字，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字
//典序），跟着它的数量（如果数量大于 1），以此类推。 
//
// 
//
// 示例 1： 
//
// 
//输入：formula = "H2O"
//输出："H2O"
//解释：
//原子的数量是 {'H': 2, 'O': 1}。
// 
//
// 示例 2： 
//
// 
//输入：formula = "Mg(OH)2"
//输出："H2MgO2"
//解释： 
//原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
// 
//
// 示例 3： 
//
// 
//输入：formula = "K4(ON(SO3)2)2"
//输出："K4N2O14S4"
//解释：
//原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
// 
//
// 示例 4： 
//
// 
//输入：formula = "Be32"
//输出："Be32"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= formula.length <= 1000 
// formula 由小写英文字母、数字 '(' 和 ')' 组成。 
// formula 是有效的化学式。 
// 
// Related Topics 栈 哈希表 字符串 
// 👍 204 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution726 {
    static class Test {
        public static void main(String[] args) {
            Solution726 test = new Solution726();
            long start = System.currentTimeMillis();
            System.out.println(test.countOfAtoms("Mg(OH)2"));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }

    int index = 0, length;
    String formula;

    public String countOfAtoms(String formula) {
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        stack.push(new HashMap<>());

        length = formula.length();
        this.formula = formula;

        while (index < length) {
            char curChar = formula.charAt(index);
            if (curChar == '(') {
                index++;
                stack.push(new HashMap<>());
            } else if (curChar == ')') {
                index++;
                //当前括号内的所有元素
                Map<String, Integer> last = stack.pop();
                //计算完毕加到括号外
                Map<String, Integer> peek = stack.peek();
                int num = getNum();

                for (Map.Entry<String, Integer> entry : last.entrySet()) {
                    peek.put(entry.getKey(), entry.getValue() * num + peek.getOrDefault(entry.getKey(), 0));
                }
            } else {
                String name = getName();
                int num = getNum();
                Map<String, Integer> last = stack.peek();
                last.put(name, last.getOrDefault(name, 0) + num);
            }
        }

        Map<String, Integer> pop = stack.pop();

        List<String> names = new ArrayList<>(pop.keySet());
        Collections.sort(names);
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : names) {
            stringBuilder.append(name);
            stringBuilder.append(pop.get(name));
        }
        return stringBuilder.toString();
    }


    private String getName() {
        int j = index + 1;
        while (j < length && Character.isLowerCase(formula.charAt(j))) {
            j++;
        }
        String name = formula.substring(index, j);
        index = j;
        return name;
    }

    private int getNum() {
        if (index == length || !Character.isDigit(formula.charAt(index))) {
            return 1;
        } else {
            int j = index;
            while (j < length && Character.isDigit(formula.charAt(j))) {
                j++;
            }
            int num = Integer.parseInt(formula.substring(index, j));
            index = j;
            return num;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
