package work.iruby.nowcoder.hj.medium;

import java.util.Scanner;

/**
 * @author ruby
 * @since 2021/7/1
 */
public class HJ36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String key = scanner.nextLine();
            char[] keyMap = getKeyMap(key);
            String line = scanner.nextLine();
            encrypt(keyMap, line);
        }
        scanner.close();
    }

    private static char[] getKeyMap(String key) {
        char[] keyMap = new char[26];
        boolean[] flag = new boolean[26];
        key = key.toLowerCase();
        int j = 0;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (!flag[index]) {
                keyMap[j] = key.charAt(i);
                j++;
                flag[index] = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (!flag[i]) {
                keyMap[j] = (char) (i + 'a');
                j++;
            }
        }
        return keyMap;
    }

    private static void encrypt(char[] keyMap, String line) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char source = line.charAt(i);
            if (source >= 'a' && source <= 'z') {
                stringBuilder.append(keyMap[source - 'a']);
            } else if (source >= 'A' && source <= 'Z') {
                stringBuilder.append((char) (keyMap[source - 'A'] - 'a' + 'A'));
            } else {
                stringBuilder.append(source);
            }
        }
        System.out.println(stringBuilder);
    }
}
