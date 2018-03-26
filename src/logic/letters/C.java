package logic.letters;

import logic.numerals.RomanNumeral;

import java.util.Arrays;
import java.util.List;

public class C extends RomanNumeral {

    @Override
    public List<RomanNumeral> canBeSubtractedFrom() {
        RomanNumeral[] arr = { new D(), new M() };
        return Arrays.asList(arr);
    }

    @Override
    public int getValue() {
        return 100;
    }

    @Override
    public Character getSymbol() {
        return 'C';
    }
}
