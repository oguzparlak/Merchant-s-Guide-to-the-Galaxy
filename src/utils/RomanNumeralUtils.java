package utils;

import logic.letters.*;
import logic.numerals.RomanNumeral;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class RomanNumeralUtils {

    public static Pattern baseNumeralPattern =
            Pattern.compile("M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

    /**
     * A Validation RegExp Pattern for a RomanNumeral
     */
    private static Pattern numeralPattern =
            Pattern.compile("^" + baseNumeralPattern);

    /**
     * Returns RomanNumeral from its symbol
     */
    public static RomanNumeral fromSymbol(char symbol) {
        switch (symbol) {
            case 'X':
                return new X();
            case 'I':
                return new I();
            case 'V':
                return new V();
            case 'M':
                return new M();
            case 'L':
                return new L();
            case 'D':
                return new D();
            case 'C':
                return new C();
            default:
                return null;
        }
    }

    /**
     * Returns a List of RomanNumerals by reading the values from dictionary
     */
    public static List<RomanNumeral> fromDictionary(QuestionHandler handler, String[] sequence) {
        RomanNumeral[] numerals = new RomanNumeral[sequence.length];
        for (int i = 0; i < sequence.length; i++) {
            RomanNumeral numeral = (RomanNumeral) handler.readValue(sequence[i].trim());
            numerals[i] = numeral;
        }
        return Arrays.asList(numerals);
    }

    /**
     * Creates a List of RomanNumerals from a list
     */
    public static List<RomanNumeral> toRomanNumeralList(String sequence) {
        RomanNumeral[] numerals = new RomanNumeral[sequence.length()];
        char[] characters = sequence.toCharArray();
        for (int i = 0; i < sequence.length(); i++) {
            RomanNumeral numeral = fromSymbol(characters[i]);
            numerals[i] = numeral;
        }
        return Arrays.asList(numerals);
    }

    /**
     *  The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more.
     *  "D", "L", and "V" can never be repeated. "I" can be subtracted from "V" and "X" only.
     *  "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only.
     *  "V", "L", and "D" can never be subtracted.
     *  Only one small-value symbol may be subtracted from any large-value symbol.
     */
    public static boolean isValidRomanNumeral(List<RomanNumeral> numerals) {
        return numerals.size() > 0 && numeralPattern.matcher(getSymbol(numerals)).find();
    }

    /**
     * Converts the list of RomanNumerals to String
     */
    public static String getSymbol(List<RomanNumeral> numerals) {
        StringBuilder builder = new StringBuilder();
        numerals.forEach(numeral -> builder.append(numeral.getSymbol()));
        return builder.toString();
    }

}
