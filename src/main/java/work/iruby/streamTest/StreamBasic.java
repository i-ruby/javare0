package work.iruby.streamTest;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import work.iruby.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ruby
 * @date 2020/12/15 19:25
 */
@Testable
public class StreamBasic {
    @Test
    public void constructor() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        // 1. Individual values
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6);
        // 2. 迭代器
        Stream<Integer> stream2 = Stream.iterate(0, x -> x * x);
        Stream<Integer> stream3 = Stream.iterate(0, x -> x < 10, x -> x + 1);
        // 3. Arrays
        Stream<List<Integer>> list4 = Stream.of(list);
        Stream<Integer> stream5 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
        // 4. Collections
        Stream<Integer> stream6 = list.stream();
        // 5 . Streams 过时
        Stream<Integer> stream7 = Streams.stream(list);
    }

    @Test
    public void deal1() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "ruby", 18, "研发"));
        list.add(new User(2, "张三", 38, "测试"));
        list.add(new User(3, "李四", 12, "策划"));
        list.add(new User(4, "王五", 28, "研发"));
        list.add(new User(4, "王五", 28, "研发"));

        // filter 筛选 skip 跳过前n个 limit 查到一个结果后结束
        list.stream().filter(user -> user.getAge() < 25).skip(1).limit(1).forEach(System.out::println);
        // findAny 随机选一个符合条件的,串行条件时可能选的不是第一个符合元素 相对有 findFirst()
        // Optional.empty 时调用 get() 会出现 NoSuchElementException: No value present
        // orElse可以在没有给到没有符合对象时返回的对象
        System.out.println(list.stream().filter(user -> "研发1".equals(user.getDepartment())).findAny()
                .orElse(null)
        );
        // 经典除重(当然需要重写equal 和 HashCode)
        list.stream().distinct().forEach(System.out::println);
        System.out.println("---------------------");
        System.out.println(list.stream().map(user -> user.getId() + " " + user.getName()).collect(Collectors.toList()));
        System.out.println(Arrays.toString(list.stream().mapToInt(user -> user.getAge() + 10).toArray()));
        //
        Stream<Stream<char[]>> stream = list.stream().map(user -> stringToChars(user.getDepartment()));
        Stream<char[]> stream1 = list.stream().flatMap(user -> stringToChars(user.getDepartment()));
        System.out.println("---------------------");
        stream.forEach(s -> s.forEach(System.out::println));
        System.out.println("---------------------");
        stream1.forEach(System.out::println);
        System.out.println("---------------------");

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        // flatMap 把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
        outputStream.forEach(System.out::println);
    }

    private Stream<char[]> stringToChars(String str) {
        return Stream.of(str.toCharArray());
    }

    @Test
    public void test() {
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5};
        int[] result = Arrays.stream(integers).mapToInt(x -> x * x).toArray();
        System.out.println(Arrays.toString(result));

        List<User> list = new ArrayList<>();
        list.add(new User(1, "ruby", 18, "研发"));
        list.add(new User(2, "张三", 38, "测试"));
        list.add(new User(3, "李四", 12, "策划"));
        list.add(new User(4, "王五", 28, "研发"));
        list.add(new User(4, "王五", 28, "研发"));
        int count = list.stream().map(user -> 1).reduce(0, Integer::sum);
        System.out.println(count);
    }
}
