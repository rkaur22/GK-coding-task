import java.util.Objects;

public class Denomination {
    public String type;
    public int cents;

    public Denomination(String type, int cents) {
        this.type = type;
        this.cents = cents;
    }

    @Override
    public String toString() {
        int euros = cents / 100;
        int remainder = cents % 100;
        String formatted = remainder == 0 ? String.format("%02d", euros).replace('.', ',')
                                          : String.format("%d,%02d", euros, remainder);
        return formatted + " Euro " + (type.equals("bill") ? "bills" : "coins");
    }

    @Override
    public int hashCode() {
        return Objects.hash(cents, type);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Denomination)) return false;
        Denomination other = (Denomination) obj;
        return this.cents == other.cents && this.type.equals(other.type);
    }
}