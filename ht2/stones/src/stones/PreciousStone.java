package stones;

public class PreciousStone extends Stone {

    private final String clarity;

    public PreciousStone(String name, double weight, double pricePerCarat, String clarity) {
        super(name, weight, pricePerCarat);
        this.clarity = clarity;
    }

    public String getClarity() {
        return clarity;
    }

    @Override
    public String toString() {
        return super.toString() + ", clarity: " + clarity + "\n";   
    }


}
