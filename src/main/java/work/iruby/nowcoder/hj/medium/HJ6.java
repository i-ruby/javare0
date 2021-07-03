package work.iruby.nowcoder.hj.medium;

/**
 * @author ruby
 * @since 2021/7/1
 */
public class HJ6 {
    public static void main(String[] args) {

    }

    static class Test {
        public static void main(String[] args) {
            HJ6 test = new HJ6();
            long start = System.currentTimeMillis();
            System.out.println(test.solution(180L));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }

    private String solution(long l) {
        long max = (long) Math.sqrt(l);
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 2; i <= max; ) {
            if (l % i == 0) {
                l = l / i;
                max = (long) Math.sqrt(l);
                stringBuffer.append(i).append(" ");
                i = 2;
                continue;
            }
            i++;
        }
        stringBuffer.append(l).append(" ");
        return stringBuffer.toString();
    }
}
