package ModernJavaInAction.chapter4;

import ModernJavaInAction.chapter4.Chapter4.Dish.Type;
import java.util.Arrays;
import java.util.List;

public class Chapter4 {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        List<Dish> q5_1 = menu.stream()
                .filter(i -> i.getType().equals(Type.MEAT))
                .limit(2)
                .toList();
        // q5_2
        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        List<Integer> list2 = list1.stream()
                .map(i -> i * i)
                .toList();

        //q5_2_2
        List<Integer> q5_2 = List.of(1, 2, 3);
        List<Integer> q5_2_2 = List.of(3, 4);
        List<int[]> answer = q5_2.stream()
                .flatMap(i -> q5_2_2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .toList();
        //q5_3
        int dishCount = menu.stream().map(d -> 1).reduce(0, Integer::sum);
    }

    public static class Dish {
        private final String name;
        private final boolean vegetarian;
        private final int calories;
        private final Type type;

        public Dish(String name, boolean vegetarian, int calories, Type type) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.calories = calories;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public boolean isVegetarian() {
            return vegetarian;
        }

        public int getCalories() {
            return calories;
        }

        public Type getType() {
            return type;
        }

        @Override
        public String toString() {
            return name;
        }

        public enum Type {MEAT, FISH, OTHER}
    }
}
