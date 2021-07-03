package work.iruby.nowcoder.hj.medium;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author ruby
 * @since 2021/7/1
 */
public class HJ35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            print(n);
        }
        scanner.close();
    }

    private static void print(int n) {
        StringJoiner[] stringJoiners = new StringJoiner[n];
        for (int i = 0; i < n; i++) {
            stringJoiners[i] = new StringJoiner(" ");
        }
        int d = 1;
        int cache = d;
        int i = 1;
        while (true) {
            while (d != 0) {
                stringJoiners[d - 1].add(String.valueOf(i));
                d--;
                i++;
            }
            if (cache == n) {
                break;
            } else {
                cache++;
                d = cache;
            }
        }

        for (StringJoiner s : stringJoiners) {
            System.out.println(s);
        }
    }
}
