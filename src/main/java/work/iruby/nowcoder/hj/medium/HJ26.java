package work.iruby.nowcoder.hj.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author ruby
 * @since 2021/7/1
 */
public class HJ26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<String> list = new ArrayList<>();
            char[] chars = line.toCharArray();
            if (chars.length == 0) {
                break;
            }
            for (char aChar : chars) {
                if (Character.isLetter(aChar)) {
                    list.add(String.valueOf(aChar));
                }
            }
            list.sort(Comparator.comparing(String::toLowerCase));
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0, j = 0, charsLength = chars.length; i < charsLength; i++) {
                char aChar = chars[i];
                if (Character.isLetter(aChar)) {
                    stringBuilder.append(list.get(j));
                    j++;
                } else {
                    stringBuilder.append(aChar);
                }
            }
            System.out.println(stringBuilder);
        }
        scanner.close();
    }
}
