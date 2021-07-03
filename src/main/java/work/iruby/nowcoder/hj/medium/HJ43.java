package work.iruby.nowcoder.hj.medium;

import java.util.Scanner;

/**
 * @author ruby 未完
 * @since 2021/7/1
 */
public class HJ43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        int n = Integer.parseInt(split[0]), m = Integer.parseInt(split[1]);
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            split = line.split(" ");
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println();
    }
}
