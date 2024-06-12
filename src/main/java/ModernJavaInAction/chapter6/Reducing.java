package ModernJavaInAction.chapter6;

import static ModernJavaInAction.chapter6.Dish.menu;
import static java.util.stream.Collectors.reducing;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class Reducing {
    public static void main(String... args) {
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithMethodReference());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithoutCollectors());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesUsingSum());

        // Mine
        long menuCount = menu.stream().collect(Collectors.counting());
        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish =
                menu.stream()
                        .max(dishCaloriesComparator);
        int totalCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        Optional<Dish> mostCalorieDish2 =
                menu.stream().max(Comparator.comparing(Dish::getCalories));
        
    }

    private static int calculateTotalCalories() {
        return menu.stream().collect(reducing(0, Dish::getCalories, (Integer i, Integer j) -> i + j));
    }

    private static int calculateTotalCaloriesWithMethodReference() {
        return menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
    }

    private static int calculateTotalCaloriesWithoutCollectors() {
        return menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
    }

    private static int calculateTotalCaloriesUsingSum() {
        return menu.stream().mapToInt(Dish::getCalories).sum();
    }
}
