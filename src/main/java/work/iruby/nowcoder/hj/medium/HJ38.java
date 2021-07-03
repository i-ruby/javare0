package work.iruby.nowcoder.hj.medium;

import java.util.Scanner;

/**
 * @author ruby
 * @since 2021/7/1
 */
public class HJ38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double height = scanner.nextDouble();
        System.out.printf("%6f", 2.875 * height);
        System.out.println();
        System.out.printf("%6f", 0.03125 * height);
    }
}
