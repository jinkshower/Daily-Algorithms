package ModernJavaInAction;

import java.util.List;

public class Quiz2_1 {
    public static void main(String[] args) {
        prettyPrintApple(inventory, new AppleSimpleFormatter());
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter appleFormatter) {
        for (Apple apple : inventory) {
            String output = appleFormatter.accept(apple);
            System.out.println(output);
        }
        //List<Apple> result =
        //          filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));
    }

    class Apple {
        String name;
        String color;
        int weight;

        public int getWeight() {
            return weight;
        }

        public String getName() {
            return name;
        }

        public String getColor() {
            return color;
        }
    }

    interface AppleFormatter {
        String accept(Apple apple);
    }

    class AppleFancyFormatter implements AppleFormatter {

        @Override
        public String accept(Apple apple) {
            String characteristic = apple.getWeight() > 150 ? "heavy" :
                    "light";
            return "A" + characteristic + " " + apple.getColor() + " apple";
        }
    }

    class AppleSimpleFormatter implements AppleFormatter {

        @Override
        public String accept(Apple apple) {
            return "An apple of " + apple.getWeight() + "g";
        }
    }
}
