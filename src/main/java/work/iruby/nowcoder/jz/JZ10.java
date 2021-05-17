package work.iruby.nowcoder.jz;

public class JZ10 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    static class Test {
        public static void main(String[] args) {
            JZ10 test = new JZ10();
            long start = System.currentTimeMillis();
            System.out.println(test.NumberOf1(7));
            long end = System.currentTimeMillis();
            System.out.println("执行用时+" + (end - start) + " ms");
        }
    }
}