package ModernJavaInAction.chapter6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimePartition {
    public static void main(String... args) {
        System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimes(100));
        Map<String, List<String>> movies = new HashMap<>();
        movies.computeIfAbsent("Raphael", name -> new ArrayList<>()).add("Star Wars");
        movies.putIfAbsent("Jessica", List.of("int"));
        movies.compute("Raphael", (key, value) -> new ArrayList<>()).add("sin");
        movies.computeIfAbsent("Raphael", name -> new ArrayList<>(List.of("Star")));

        System.out.println(movies);
        Map<String, String> my = new HashMap<>();
        my.put("rah", "oien");
        my.putIfAbsent("rah", "mymy");
        System.out.println(my);
    }

    private static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
    }

    private static Boolean isPrime(int candidate) {
        return IntStream.rangeClosed(2, candidate - 1)
                .limit((long) Math.floor(Math.sqrt(candidate)) - 1)
                .noneMatch(i -> candidate % i == 0);
    }
}
