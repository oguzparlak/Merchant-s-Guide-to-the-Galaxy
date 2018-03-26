package logic.processors;

import logic.numerals.RomanNumeral;
import logic.numerals.RomanNumeralCombination;
import utils.RomanNumeralUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class QuestionProcessor extends Processor {

    /**
     * If this flag is true this processor will
     * do processing by querying a variable's value
     * otherwise it will query its credits
     */
    private boolean queryByValue;

    public QuestionProcessor(boolean queryByValue, String... parameters) {
        super(parameters);
        this.queryByValue = queryByValue;
    }

    public QuestionProcessor(String... parameters) {
        super(parameters);
        queryByValue = false;
    }

    @Override
    public void process() {
        if (queryByValue)
            processByValue();
        else
            processByCredit();
    }

    private void processByCredit() {
        RomanNumeralCombination combination = getRomanNumeralCombination();
        double unitValue = (double) getHandler().readValue(getParameters()[1].trim());
        NumberFormat nf = new DecimalFormat("#.####");
        System.out.printf("%s %s is %s Credits\n", getParameters()[0], getParameters()[1],
                nf.format(combination.getValue() * unitValue));
    }

    private void processByValue() {
        RomanNumeralCombination combination = getRomanNumeralCombination();
        System.out.printf("%s is %d\n", getParameters()[0], combination.getValue());
    }

    private RomanNumeralCombination getRomanNumeralCombination() {
        String[] variables = getParameters()[0].trim().split("\\s");
        List<RomanNumeral> numerals = RomanNumeralUtils.fromDictionary(getHandler(), variables);
        return new RomanNumeralCombination(numerals);
    }
}
