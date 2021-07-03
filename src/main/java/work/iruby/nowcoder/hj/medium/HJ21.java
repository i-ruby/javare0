package work.iruby.nowcoder.hj.medium;

import java.util.Scanner;

/**
 * @author ruby
 * @since 2021/7/1
 */
public class HJ21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            char[] chars = scanner.nextLine().toCharArray();
            if (chars.length == 0) {
                break;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (char aChar : chars) {
                stringBuilder.append(of(aChar));
            }
            System.out.println(stringBuilder);
        }
    }

    private static char of(char ch) {
        if (ch >= 'A' && ch <= 'Y') {
            return (char) (ch - 'A' + 'a' + 1);
        } else if (ch == 'Z') {
            return 'a';
        } else if (ch >= 'a' && ch <= 'c') {
            return '2';
        } else if (ch >= 'd' && ch <= 'f') {
            return '3';
        } else if (ch >= 'g' && ch <= 'i') {
            return '4';
        } else if (ch >= 'j' && ch <= 'l') {
            return '5';
        } else if (ch >= 'm' && ch <= 'o') {
            return '6';
        } else if (ch >= 'p' && ch <= 's') {
            return '7';
        } else if (ch >= 't' && ch <= 'v') {
            return '8';
        } else if (ch >= 'w' && ch <= 'z') {
            return '9';
        } else {
            return ch;
        }
    }
}
