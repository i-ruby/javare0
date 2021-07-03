package work.iruby.nowcoder.hj.medium;

import java.util.Scanner;

/**
 * @author ruby
 * @since 2021/7/1
 */
public class HJ5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int res = 0;
            char[] chars = line.toCharArray();
            int n = chars.length;

            for (int i = 2; i < n; i++) {
                double pow = Math.pow(16, n - i - 1);
                if (Character.isDigit(chars[i])) {
                    res += pow *chars[i];
                } else {
                    res += pow * (chars[i] - 'A' + 10);
                }
            }
            System.out.println(res);
        }
    }

}
