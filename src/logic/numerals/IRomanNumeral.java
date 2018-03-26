package logic.numerals;

public interface IRomanNumeral<T> {

    /**
     * Returns the value of RomanNumeral
     * in base10 number system.
     */
    int getValue();

    /**
     * Defines the symbol of the RomanNumeral
     * i.e 'X', 'I', 'V', 'VI'
     */
    T getSymbol();
}
