package work.iruby.nowcoder.jz;

public class JZ8 {
    public int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int n1 = 1, n2 = 2;
        int sum = 0;
        for (int i = 2; i < target; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return sum;
    }

    static class Test {
        public static void main(String[] args) {
            JZ8 test = new JZ8();
            long start = System.currentTimeMillis();
            System.out.println(test.jumpFloor(3));
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }
}