package work.iruby.nowcoder.hj.medium;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author ruby
 * @since 2021/7/1
 */
public class HJ8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            int key = Integer.parseInt(split[0]);
            int val = Integer.parseInt(split[1]);
            map.merge(key, val, Integer::sum);
        }
        scanner.close();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
