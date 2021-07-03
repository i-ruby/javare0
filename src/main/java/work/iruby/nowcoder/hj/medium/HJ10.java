package work.iruby.nowcoder.hj.medium;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author ruby
 * @since 2021/7/1
 */
public class HJ10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Character> set = new HashSet<>();
        char[] chars = scanner.nextLine().toCharArray();
        for (char aChar : chars) {
            if (aChar <= 127) {
                set.add(aChar);
            }
        }
        System.out.println(set.size());
    }
}
