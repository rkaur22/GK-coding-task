import java.util.*;

public class Main {
    public static void main(String[] args) {
        double paidEuros = 50.0;
        double costEuros = 16.09;

        List<Integer> bills = Arrays.asList(500, 200, 100, 50, 20, 10, 5);
        List<Double> coins = Arrays.asList(2.0, 1.0, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01);

        List<Denomination> denominations = new ArrayList<>();
        for (int b : bills) {
            denominations.add(new Denomination("bill", b * 100));
        }
        for (double c : coins) {
            denominations.add(new Denomination("coin", (int) Math.round(c * 100)));
        }

        KassenRechner.printChange(paidEuros, costEuros, denominations);
    }
}
    
