package Junit;

import java.text.DecimalFormat;

public class BootCamp {
    static double[] prices = new double[] {2.23, 1.32, 4.32, 11.33};

    public static void main(String[] args) {

    }
    public static double getsSubtotal() {
        double tmp = 0;
        for (double price: prices) {
            tmp += price;
        }
        return tmp;
    }

    public static double getTax(double subtotal) {
        DecimalFormat formatter = new DecimalFormat();
        return Double.parseDouble(formatter.format(subtotal * 0.13));
    }

    public static double getTotal(double subtotal, double tax) {
        return subtotal + tax;
    }
}
