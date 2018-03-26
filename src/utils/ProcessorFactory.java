package utils;

import logic.processors.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessorFactory {

    /**
     * If a string is matched with this Pattern
     * Then it will be handled by AssignmentProcessor
     * i.e glob is X
     */
    private static final Pattern assignmentPattern =
            Pattern.compile("(\\w+)\\s(is)\\s" + "(" + RomanNumeralUtils.baseNumeralPattern + ")");


    /**
     * If a string is matched with this Pattern
     * Then it will be handled by CreditProcessor
     * i.e glob prok Gold is 57800 Credits
     */
    private static final Pattern creditPattern =
            Pattern.compile("(.+)\\s(Silver|Gold|Iron)\\sis\\s(\\d+)\\sCredits");


    /**
     * If a string is matched with this Pattern
     * Then it will be handled by QueryProcessor
     * i.e how much is pish tegj glob ?
     */
    private static final Pattern questionPatternByValue =
            Pattern.compile("how\\smuch\\sis\\s(.+)\\?");


    /**
     *  If a string is matched with this Pattern
     *  Then it will be handled by QueryProcessor
     *  i.e how many Credits is glob prok Silver ?
     */
    private static final Pattern questionPatternByCredit =
            Pattern.compile("how\\smany\\sCredits\\sis\\s(.+)(Silver|Gold|Iron)\\s\\?");

    /**
     * Creates a specific processor by looking up the pattern
     */
    public static Processor getProcessor(String line) {
        Matcher matcher;
        if (Pattern.matches(assignmentPattern.pattern(), line)) {
            matcher = getMatcher(assignmentPattern, line);
            return new AssignmentProcessor(matcher.group(1), matcher.group(3));
        } else if (creditPattern.matcher(line).find()) {
            matcher = getMatcher(creditPattern, line);
            return new CreditProcessor(matcher.group(1), matcher.group(2), matcher.group(3));
        } else if (questionPatternByValue.matcher(line).find()) {
            matcher = getMatcher(questionPatternByValue, line);
            return new QuestionProcessor(true, matcher.group(1));
        } else if (questionPatternByCredit.matcher(line).find()) {
            matcher = getMatcher(questionPatternByCredit, line);
            return new QuestionProcessor(matcher.group(1), matcher.group(2));
        } else {
            return new UnknownProcessor();
        }
    }

    private static Matcher getMatcher(Pattern pattern, String line) {
        Matcher matcher;
        matcher = pattern.matcher(line);
        matcher.find();
        return matcher;
    }

}
