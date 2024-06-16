package datastructure.recursive;

public class Hanoi {

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(3, 'A', 'B', 'C');
    }

    public void hanoi(int n, char from, char temp, char to) {
        if (n == 1) {
            System.out.println("from " + from + " to " + to);
            return;
        }
        hanoi(n - 1, from, to, temp);
        System.out.println("from " + from + " to " + to);
        hanoi(n - 1, temp, from, to);
    }
}
