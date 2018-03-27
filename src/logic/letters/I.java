package logic.letters;

import logic.numerals.RomanNumeral;

import java.util.Arrays;
import java.util.List;

public class I extends RomanNumeral {

    @Override
    public int getValue() {
        return 1;
    }

    @Override
    public Character getSymbol() {
        return 'I';
    }
}