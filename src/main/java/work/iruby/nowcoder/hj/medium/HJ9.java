package work.iruby.nowcoder.hj.medium;

import java.util.Scanner;

/**
 * @author ruby
 * @since 2021/7/1
 */
public class HJ9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] flag = new boolean[10];
        char[] chars = scanner.nextLine().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            int index = chars[i] - '0';
            if (!flag[index]) {
                stringBuilder.append(chars[i]);
                flag[index] = true;
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
