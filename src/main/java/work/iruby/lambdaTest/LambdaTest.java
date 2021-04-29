package work.iruby.lambdaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Ruby
 * @date 2020/12/12 22:57
 */
public class LambdaTest {
    public static void main(String[] args) {
        consume(1, m -> System.out.println(m + "aa"));
        supplier(10, () -> (int) (Math.random() * 10)).forEach(System.out::print);
        System.out.println();
        System.out.println(function(10, i -> "花费了" + i + "元"));
        System.out.println(predicate(1, integer -> integer > 60));

    }

    //消费
    public static void consume(int money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }

    //供给
    public static List<Integer> supplier(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }


    //函数
    public static String function(int money, Function<Integer, String> function) {
        return function.apply(money);
    }

    //断言
    public static boolean predicate(int grade, Predicate<Integer> predicate) {
        return predicate.test(grade);
    }
}
