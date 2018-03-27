package logic.letters;

import logic.numerals.RomanNumeral;

import java.util.Arrays;
import java.util.List;

public class M extends RomanNumeral {

    @Override
    public int getValue() {
        return 1000;
    }

    @Override
    public Character getSymbol() {
        return 'M';
    }
}
