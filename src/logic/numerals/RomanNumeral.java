package logic.numerals;

import java.util.List;

public abstract class RomanNumeral implements IRomanNumeral<Character>, Comparable<RomanNumeral> {

    /**
     * Returns the list of RomanNumerals can be subtracted
     * from this RomanNumeral
     */
    public abstract List<RomanNumeral> canBeSubtractedFrom();

    /**
     * If the values of two RomanNumerals are the same
     * then we can say that they are equal RomanNumerals
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof RomanNumeral &&
                ((RomanNumeral) obj).getValue() == this.getValue();
    }

    @Override
    public int compareTo(RomanNumeral o) {
        return Integer.compare(this.getValue(), o.getValue());
    }

    @Override
    public String toString() {
        return String.format("%s with value %d", getSymbol(), getValue());
    }
}

