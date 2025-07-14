
import java.util.List;

public class KassenRechner {

    public static void printChange(double paid, double cost, List<Denomination> denominations) {
        if (paid < cost) {
            System.out.println("The total paid amount is not enough.");
            return;
        }
        int changeInCents = (int) Math.round((paid - cost) * 100);

        System.out.println("The cashier has to return to the customer: ");
        System.out.println("BILLS:");
        for (Denomination d : denominations) {
            if(d.type.equals("bill")) {
            int count = changeInCents / d.cents;
            if (count > 0) {
                changeInCents %= d.cents;
                System.out.println(d + ": " + count);
            }
            }
        }

        System.out.println("COINS:");
        for (Denomination d : denominations) {
            //for step 2 to skip 1 and 2 cents
            if(d.type.equals("coin")) {
            //    if (d.cents == 2 || d.cents == 1) continue;

            int count = changeInCents / d.cents;
            changeInCents %= d.cents;
            System.out.println(d + ": " + count);
            }
        }
    }
}
