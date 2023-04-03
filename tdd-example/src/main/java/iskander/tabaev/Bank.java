package iskander.tabaev;

import java.util.HashMap;

public class Bank {
    private final HashMap<Pair, Integer> rateMap = new HashMap<>();

    public Money reduce(Expression source, String toCurrency) {

        return source.reduce(this, toCurrency);
    }

    public int rate(String from, String to) {
        if (from.equals(to)) {
            return 1;
        } else {
            return rateMap.get(new Pair(from, to));
        }
    }

    public void addRate(String from, String to, int rate) {
        this.rateMap.put(new Pair(from, to), rate);
    }
}
