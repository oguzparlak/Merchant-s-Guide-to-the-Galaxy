package exceptions;

public class InvalidRomanNumeralException extends RuntimeException {

    public InvalidRomanNumeralException(String message) {
        super(message);
    }

    public InvalidRomanNumeralException() { }
}
