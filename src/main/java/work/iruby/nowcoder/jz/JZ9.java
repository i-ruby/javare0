package work.iruby.nowcoder.jz;

public class JZ9 {
    public int jumpFloorII(int target) {
        if (target ==1){
            return 1;
        }
        if (target ==2){
            return 2;
        }
        int[] mem = new int[target + 1];
        mem[1] = 1;
        mem[2] = 2;
        for (int i = 3; i < target + 1; i++) {
            for (int j = 1; j < i; j++) {
                mem[i] += mem[j];
            }
            mem[i] += 1;
        }
        return mem[target];
    }
    static class Test {
        public static void main(String[] args) {
            JZ9 test = new JZ9();
            long start = System.currentTimeMillis();
            System.out.println(test.jumpFloorII(19));
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }
}