package thread;

public class Calculator {
    private static long count = 0;

    public static void main(String[] args) {
        int maxCount = 10;

        for (int i = 0; i < maxCount; i++) {
            new Thread(() -> {
                count++;
                System.out.println(count);
            }).start();
        }
    }
}

