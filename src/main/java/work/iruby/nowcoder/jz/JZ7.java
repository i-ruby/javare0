package work.iruby.nowcoder.jz;

public class JZ7 {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int n1 = 0, n2 = 1;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }
    static class Test {
        public static void main(String[] args) {
            JZ7 test = new JZ7();
            long start = System.currentTimeMillis();
            test.Fibonacci(45);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }
}