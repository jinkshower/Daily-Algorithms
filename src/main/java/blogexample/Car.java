//package blogexample;
//
//import java.util.HashMap;
//import java.util.Map;
//
//class Car {
//    String name;
//
//    Car(String name) {
//        this.name = name;
//    }
//
//    static Car create(String name) {
//        return new Car(name);
//    }
//}
//
//class User {
//    int id;
//
//    private User(int id) {
//        this.id = id;
//    }
////
////    static User from(int id) {
////        if (isInvalidId(id)) {
////            return null;
////        }
//        return new User(id);
//    }
//}
//
//class CarFactory {
//
//    static final Map<String, Car> cars = new HashMap<>();
//
//    static {
//        cars.put("a", new Car("a"));
//        cars.put("b", new Car("b"));
//        cars.put("c", new Car("c"));
//    }
//
//    static Car from(String text) {
//        if (cars.containsKey(text)) {
//            return cars.get(text);
//        }
//        return new Car(text);
//    }
//}
//
//class CarSet {
//    private final Map<Car, String> coins;
//
//    public CarSet(final Map<Car, String> coins) {
//        this.coins = new HashMap<>(coins);
//    }
//
//    public static CarSet from(String text) {
//        //Complicated Logic..
//        //..
////        return new CarSet(cars);
////    }
//}
