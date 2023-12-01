package CodingPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalInterface {
    public static void main(String[] args) {
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
        Consumer<Integer> c = i -> System.out.println(i + ", ");

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        makeRandom(s, list);
        makeRandomWithGenerics(s, list2);
        System.out.println(list2);

        Optional<String> opt = Optional.empty();
        System.out.println(opt);

        String str = "";
        String st1r = "skdngi";

        str = opt.orElse("EMPTY");
        System.out.println(str);

        Map<String, Integer> map = new HashMap<>();
        map.put("김자바", 1);
        map.put("이자바", 2);
        map.put("최자바", 3);
        printMap(map);
    }

    private static void printMap(Map<String, Integer> map) {
        map.forEach((key, value) ->
                System.out.println(key + value));
    }


    static void makeRandom(Supplier<Integer> s, List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }

    static <T> void makeRandomWithGenerics(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }
}
