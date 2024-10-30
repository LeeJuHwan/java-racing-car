package calculator;

import exception.CalculatorException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringNumber {

    private final String stringNumber;

    private StringNumber(String stringNumber) {
        this.stringNumber = stringNumber;
    }

    public static StringNumber from(String stringNumber) {
        return new StringNumber(stringNumber);
    }

    public boolean isNull() {
        return this.stringNumber == null;
    }

    public boolean isEmpty() {
        return this.stringNumber.isEmpty();
    }

    public List<String> split(String sep) {
        return List.of(this.stringNumber.split(sep));
    }

    public List<Integer> converToIntegerListBySeperator(String sep) {
        Matcher pattern = Pattern.compile(sep).matcher(this.stringNumber);

        if (pattern.matches()) {
            List<String> tokens = convertByCustomDelimiter(pattern);
            return convertToIntegerList(tokens);
        }

        return convertToIntegerList(this.split(sep));

    }

    public Integer getStringNumber() {
        return Integer.valueOf(stringNumber);
    }

    private List<String> convertByCustomDelimiter(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        return List.of(matcher.group(2).split(customDelimiter));
    }

    private List<Integer> convertToIntegerList(List<String> sep) {
        List<Integer> integers = sep.stream().map(Integer::parseInt).collect(Collectors.toList());

        if (integers.stream().anyMatch(integer -> integer < 0)) {
            throw new RuntimeException(CalculatorException.negativeIntegerException);
        }

        return integers;
    }

}
