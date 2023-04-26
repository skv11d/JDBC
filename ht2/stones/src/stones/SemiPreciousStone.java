package stones;

public class SemiPreciousStone extends Stone {

    private final String color;

    public SemiPreciousStone(String name, double weight, double pricePerCarat, String color) {
        super(name, weight, pricePerCarat);
        this.color = color;
    }

    public String getColour() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString() + ", colour: " + color + "\n";
    }
}
