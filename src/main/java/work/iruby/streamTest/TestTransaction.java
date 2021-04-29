package work.iruby.streamTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import work.iruby.entity.Trader;
import work.iruby.entity.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ruby
 * @date 2020/12/16 0:18
 */
@Testable
public class TestTransaction {
    List<Transaction> transactions = null;

    @BeforeEach
    private void before() {
        Trader A = new Trader("A", "city1");
        Trader B = new Trader("B", "city2");
        Trader C = new Trader("C", "city1");
        Trader D = new Trader("D", "city2");

        transactions = Arrays.asList(
                new Transaction(A, 2011, 300),
                new Transaction(B, 2012, 1000),
                new Transaction(B, 2011, 400),
                new Transaction(C, 2012, 710),
                new Transaction(C, 2012, 700),
                new Transaction(D, 2012, 950)
        );
    }

    @Test
    public void test1() {
        Stream<Transaction> stream1 = transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(Comparator.comparingInt(Transaction::getValue));
        stream1.forEach(System.out::println);
        System.out.println("---------------------------");
        Stream<String> stream2 = transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct();
        stream2.forEach(System.out::println);
        System.out.println("---------------------------");
        Stream<Trader> stream3 = transactions.stream().map(Transaction::getTrader).filter(trader -> "city1".equals(trader.getCity())).sorted(Comparator.comparing(Trader::getName));
        stream3.forEach(System.out::println);
        System.out.println("---------------------------");
        Stream<String> stream4 = transactions.stream().map(transaction -> transaction.getTrader().getName()).sorted(String::compareTo);
        stream4.forEach(System.out::println);
    }

    @Test
    public void test2() {
        boolean flag = transactions.stream().map(transaction -> transaction.getTrader().getCity()).anyMatch("city2"::equals);
        System.out.println(flag);

        Integer max = transactions.stream().map(Transaction::getValue).max(Integer::compareTo).get();
        System.out.println(max);

        Integer sum = transactions.stream()
                .filter(transaction -> "city2".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue).reduce(0, Integer::sum);
        System.out.println(sum);

        Stream<Transaction> stream2 = transactions.stream().sorted(Comparator.comparingInt(Transaction::getValue)).limit(1);
        System.out.println(stream2.collect(Collectors.toList()).get(0));
    }
}
