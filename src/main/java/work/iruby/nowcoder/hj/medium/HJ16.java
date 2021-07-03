package work.iruby.nowcoder.hj.medium;

import java.util.Scanner;

/**
 * @author ruby 未完
 * @since 2021/7/1
 */
public class HJ16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        int maxCount = Integer.parseInt(split[0]), n = Integer.parseInt(split[1]);
        int[][] res = new int[n + 1][maxCount];
        res[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            String s = scanner.nextLine();
            String[] split1 = s.split(" ");

        }
    }
}
