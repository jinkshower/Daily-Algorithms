package ModernJavaInAction.chapter4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Practice5_6 {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> first = transactions.stream()
                .filter(i -> i.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();

        List<String> second = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .toList();

        List<Trader> third = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .toList();

        String fourth = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));

        Optional<Trader> fifth = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Milan"))
                .findAny();

        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(transaction -> System.out.println(transaction.getValue()));

        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        Optional<Transaction> smallestValueTransaction = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
    }

    public static class Trader {
        private final String name;
        private final String city;

        public Trader(String n, String c) {
            this.name = n;
            this.city = c;
        }

        public String getName() {
            return this.name;
        }

        public String getCity() {
            return this.city;
        }

        public String toString() {
            return "Trader:" + this.name + " in " + this.city;
        }
    }

    public static class Transaction {
        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public Trader getTrader() {
            return this.trader;
        }

        public int getYear() {
            return this.year;
        }

        public int getValue() {
            return this.value;
        }

        public String toString() {
            return "{" + this.trader + ", " +
                    "year: " + this.year + ", " +
                    "value: " + this.value + "}";
        }
    }
}
