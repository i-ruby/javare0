package work.iruby.nowcoder.hj.medium;

import java.util.Scanner;

/**
 * @author ruby
 * @since 2021/7/1
 */
public class HJ40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            print(line);
        }
        scanner.close();
    }

    private static void print(String line) {
        int letter = 0, digit = 0, whitespace = 0, other = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isLetter(c)) {
                letter++;
            } else if (Character.isDigit(c)) {
                digit++;
            } else if (Character.isWhitespace(c)) {
                whitespace++;
            } else {
                other++;
            }
        }
        System.out.println(letter);
        System.out.println(whitespace);
        System.out.println(digit);
        System.out.println(other);
    }
}
