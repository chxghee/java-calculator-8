package calculator.calculation;

import java.util.List;

public class Adder {

    private final List<Integer> terms;

    public Adder(List<Integer> terms) {
        this.terms = terms;
    }

    public int sumTerms() {
        return terms.stream()
                .reduce(0, Integer::sum);
    }
}
