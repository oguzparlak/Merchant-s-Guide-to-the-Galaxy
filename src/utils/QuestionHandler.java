package utils;

import logic.numerals.RomanNumeral;

import java.util.HashMap;
import java.util.Map;

public class QuestionHandler {

    private static QuestionHandler sInstance = new QuestionHandler();

    /**
     * Generic Dictionary
     * We can store our variables here
     * and make queries out of them
     */
    private Map<String, Object> valueAssigner;

    /**
     * Private Singleton Constructor
     */
    private QuestionHandler() {
        valueAssigner = new HashMap<>();
    }

    public void assignValue(String key, Object object) {
        valueAssigner.put(key, object);
    }

    public Object readValue(String key) {
        return valueAssigner.get(key);
    }

    public static QuestionHandler getInstance() {
        return sInstance;
    }


}
