package stones;

import java.util.Comparator;

public class Stone {

    private final String name;
    private final double weight;
    private final double pricePerCarat;

    public Stone(String name, double weight, double pricePerCarat) {
        this.name = name;
        this.weight = weight;
        this.pricePerCarat = pricePerCarat;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPricePerCarat() {
        return pricePerCarat;
    }

    @Override
    public String toString() {
        return name + ", weight: " + weight + " carat, price per carat: " + pricePerCarat + "$";
    }

    public static final Comparator<Stone> COMPARE_BY_PRICE = new Comparator<Stone>() {
        @Override
        public int compare(Stone o1, Stone o2) {
            return (int) (o1.getPricePerCarat() - o2.pricePerCarat);
        }
    };
}
