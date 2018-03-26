package logic.letters;

import logic.numerals.RomanNumeral;

import java.util.List;

public class D extends RomanNumeral {

    @Override
    public List<RomanNumeral> canBeSubtractedFrom() {
        return null;
    }

    @Override
    public int getValue() {
        return 500;
    }

    @Override
    public Character getSymbol() {
        return 'D';
    }
}
