package logic.processors;

import logic.numerals.RomanNumeral;
import logic.numerals.RomanNumeralCombination;
import utils.RomanNumeralUtils;

import java.util.List;

public class CreditProcessor extends Processor {

    public CreditProcessor(String... parameters) {
        super(parameters);
    }

    @Override
    public void process() {
        String[] name = getParameters()[0].split("\\s");
        List<RomanNumeral> numerals = RomanNumeralUtils.fromDictionary(getHandler(), name);
        RomanNumeralCombination combination = new RomanNumeralCombination(numerals);
        String materialType = getParameters()[1];
        int credit = Integer.parseInt(getParameters()[2]);
        int numeralValue = combination.getValue();
        getHandler().assignValue(materialType, (double) credit / numeralValue);
    }
}
