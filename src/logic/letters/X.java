package logic.letters;

import logic.numerals.RomanNumeral;

import java.util.Arrays;
import java.util.List;

public class X extends RomanNumeral {

    @Override
    public List<RomanNumeral> canBeSubtractedFrom() {
        RomanNumeral[] arr = { new L(), new C() };
        return Arrays.asList(arr);
    }

    @Override
    public int getValue() {
        return 10;
    }

    @Override
    public Character getSymbol() {
        return 'X';
    }
}
