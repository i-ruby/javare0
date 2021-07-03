package work.iruby.nowcoder.hj.medium;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author ruby
 * @since 2021/7/1
 */
public class HJ14 {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextLine());
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
