package logic.processors;

import utils.RomanNumeralUtils;

public class AssignmentProcessor extends Processor {

    public AssignmentProcessor(String... parameters) {
        super(parameters);
    }

    @Override
    public void process() {
        String key = getParameters()[0];
        char value = getParameters()[1].charAt(0);
        getHandler().assignValue(key, RomanNumeralUtils.fromSymbol(value));
    }
}
