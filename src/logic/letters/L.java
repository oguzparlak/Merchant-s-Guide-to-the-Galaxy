package logic.letters;

import logic.numerals.RomanNumeral;

import java.util.List;

public class L extends RomanNumeral {

    @Override
    public int getValue() {
        return 50;
    }

    @Override
    public Character getSymbol() {
        return 'L';
    }
}
