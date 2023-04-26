import stones.PreciousStone;
import stones.SemiPreciousStone;
import stones.Stone;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<Stone> necklace = new ArrayList<>();

        necklace.add(new PreciousStone("Adularia", 3, 7200, "10%"));
        necklace.add(new SemiPreciousStone("Coral", 3, 8100, "orange"));
        necklace.add(new PreciousStone("Diamond", 3, 3900, "70%"));
        necklace.add(new PreciousStone("Lazurite", 3, 5500, "35%"));
        necklace.add(new SemiPreciousStone("Pearl", 3, 6700, "white"));

        Collections.sort(necklace, Stone.COMPARE_BY_PRICE);

        System.out.println(necklace);
    }
}