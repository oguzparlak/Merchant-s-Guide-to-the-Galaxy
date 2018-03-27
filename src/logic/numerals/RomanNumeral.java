package logic.numerals;

public abstract class RomanNumeral<T> implements Comparable<RomanNumeral> {

    /**
     * Returns the value of RomanNumeral
     * in base10 number system.
     */
    public abstract int getValue();

    /**
     * Defines the symbol of the RomanNumeral
     * i.e 'X', 'I', 'V', 'VI'
     */
    public abstract T getSymbol();

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

