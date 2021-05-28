package work.iruby.misc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

/**
 * @author ruby
 * @since 2021/5/22
 */
public class WordCount {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool(3);
        Path path = Paths.get("src/main/java/work/iruby/sort");
        List<Path> pathList = Files.list(path).collect(Collectors.toList());
        System.out.println(pool.submit(new Count(pathList)).join());
    }

    static class Count extends RecursiveTask<Map<String, Integer>> {
        List<Path> pathList;
        Map<String, Integer> map = new HashMap<>();

        public Count(List<Path> pathList) {
            this.pathList = pathList;
        }

        @Override
        protected Map<String, Integer> compute() {
            if (pathList.size() == 0) {
                return map;
            } else if (pathList.size() == 1) {
                return countWord(pathList.get(0));
            } else {
                ForkJoinTask<Map<String, Integer>> leftTask = new Count(pathList.subList(0, pathList.size() / 2)).fork();
                ForkJoinTask<Map<String, Integer>> rightTask = new Count(pathList.subList(pathList.size() / 2, pathList.size())).fork();
                return reduce(leftTask.join(), rightTask.join());
            }
        }

        private Map<String, Integer> reduce(Map<String, Integer> map1, Map<String, Integer> map2) {
            if (map1.size() < map2.size()) {
                for (String s : map1.keySet()) {
                    map2.merge(s, map1.get(s), Integer::sum);
                }
                return map2;
            } else {
                for (String s : map2.keySet()) {
                    map1.merge(s, map2.get(s), Integer::sum);
                }
                return map1;
            }
        }

        private Map<String, Integer> countWord(Path path) {
            try {
                Files.lines(path)
                        .flatMap(s -> Arrays.stream(s.replaceAll("[.,;<>()\\[\\]{}\"]+", " ")
                                .split(" ")))
                        .forEach(w -> map.merge(w, 1, Integer::sum));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return map;
        }
    }
}
