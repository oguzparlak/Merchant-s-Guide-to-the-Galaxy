package logic.letters;

import logic.numerals.RomanNumeral;

import java.util.Arrays;
import java.util.List;

public class M extends RomanNumeral {

    @Override
    public List<RomanNumeral> canBeSubtractedFrom() {
        RomanNumeral[] arr = { new X(), new I(), new C(), new D(), new V(), new L() };
        return Arrays.asList(arr);
    }

    @Override
    public int getValue() {
        return 1000;
    }

    @Override
    public Character getSymbol() {
        return 'M';
    }
}
