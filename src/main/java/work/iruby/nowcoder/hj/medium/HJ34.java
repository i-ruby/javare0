package work.iruby.nowcoder.hj.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author ruby
 * @since 2021/7/1
 */
public class HJ34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            print(scanner);
        }
        scanner.close();
    }

    private static void print(Scanner scanner) {
        char[] chars = scanner.nextLine().toCharArray();
        List<Character> list = new ArrayList<>();
        for (char aChar : chars) {
            list.add(aChar);
        }
        list.sort(Comparator.comparingInt(c -> c));
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : list) {
            stringBuilder.append(character);
        }
        System.out.println(stringBuilder);
    }
}
