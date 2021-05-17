package work.iruby.nowcoder.jz;

public class JZ11 {
    boolean invalidInput = false;

    public double Power(double base, int exponent) {
        if (equalZero(base) && exponent < 0) {
            invalidInput = true;
            return 0.0;
        }
        int absexponent = exponent;
        if (exponent < 0)
            absexponent = -exponent;
        double res = getPower(base, absexponent);
        if (exponent < 0)
            res = 1.0 / res;
        return res;
    }

    boolean equalZero(double num1) {
        double zero = 0.0;
        return num1 - zero > -0.000001 && num1 - zero < 0.000001;
    }

    double getPower(double b, int e) {
        if (e == 0) {
            return 1.0;
        }
        if (e == 1) {
            return b;
        }
        double result = getPower(b, e >> 1);
        result *= result;
        if ((e & 1) == 1) {
            result *= b;
        }
        return result;
    }

    static class Test {
        public static void main(String[] args) {
            JZ11 test = new JZ11();
            long start = System.currentTimeMillis();
            long end = System.currentTimeMillis();
            System.out.println("执行用时+" + (end - start) + " ms");
        }
    }
}