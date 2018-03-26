package logic.numerals;

import exceptions.InvalidRomanNumeralException;
import utils.RomanNumeralUtils;

import java.util.List;

/**
 * Defines the combination of RomanNumerals
 */
public class RomanNumeralCombination implements IRomanNumeral<String> {

    private List<RomanNumeral> numerals;

    public RomanNumeralCombination(List<RomanNumeral> numerals) {
        // Make sure that the sequence is valid
        if (!RomanNumeralUtils.isValidRomanNumeral(numerals)) {
            throw new InvalidRomanNumeralException("This RomanNumeral is not valid");
        }
        this.numerals = numerals;
    }

    /**
     * Calculates the value of a RomanNumeral in base 10
     */
    @Override
    public int getValue() {

        final int length = numerals.size();

        // If the Numeral contains only one element then return it
        if (length == 1)
            return numerals.get(0).getValue();

        int result = 0;
        RomanNumeral currentNumeral = numerals.get(0);
        for (int i = 0; i < length; i++) {
            if (i + 1 < length) {
                RomanNumeral nextNumeral = numerals.get(i + 1);
                // If the current numeral greater than next number, add it
                if (currentNumeral.compareTo(nextNumeral) >= 0)
                    result += currentNumeral.getValue();
                // Otherwise, subtract it
                else
                    result -= currentNumeral.getValue();
                // Set current RomanNumeral to next one
                currentNumeral = nextNumeral;
            }
            // No matter what, add the end character's value to result
            // Because there is no next character, so we can't do any comparision
            if (i == length - 1)
                result += currentNumeral.getValue();
        }
        return result;
    }

    @Override
    public String getSymbol() {
        return RomanNumeralUtils.getSymbol(numerals);
    }

}
