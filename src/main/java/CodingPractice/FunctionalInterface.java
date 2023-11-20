package CodingPractice;

import java.util.ArrayList;
import java.util.List;
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
        System.out.println(list);
        makeRandomWithGenerics(s, list2);
        System.out.println(list2);

        Optional<String> opt = Optional.empty();
        System.out.println(opt);

        String str = "";

        str = opt.orElse("EMPTY");
        System.out.println(str);
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
