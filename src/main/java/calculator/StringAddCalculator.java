package calculator;

import java.util.List;

public class StringAddCalculator {

    private final StringNumber stringNumber;
    private final String delimiter;

    private StringAddCalculator(StringNumber stringNumber, String delimiter) {
        this.stringNumber = stringNumber;
        this.delimiter = delimiter;
    }

    public static StringAddCalculator from(StringNumber stringNumber, String delimiter) {
        return new StringAddCalculator(stringNumber, delimiter);
    }

    public static StringAddCalculator from(StringNumber stringNumber) {
        return new StringAddCalculator(stringNumber, " ");
    }

    public int calculate() {
        if (isNullOrBlank()) {
            return 0;
        }

        List<Integer> split = this.stringNumber.converToIntegerListBySeperator(this.delimiter);

        if (isOnlyOneNumber(split)) {
            return this.stringNumber.getStringNumber();
        }

        return split.stream().mapToInt(Integer::valueOf).sum();
    }

    private boolean isNullOrBlank() {
        return this.stringNumber.isNull() || this.stringNumber.isEmpty();
    }

    private boolean isOnlyOneNumber(List<Integer> split) {
        return split.size() == 1;
    }

}
