package logic.letters;

import logic.numerals.RomanNumeral;

import java.util.List;

public class V extends RomanNumeral {

    @Override
    public List<RomanNumeral> canBeSubtractedFrom() {
        return null;
    }

    @Override
    public int getValue() {
        return 5;
    }

    @Override
    public Character getSymbol() {
        return 'V';
    }
}
