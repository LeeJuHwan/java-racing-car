package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


public class StringAddCalculatorTest {

    @ParameterizedTest
    @DisplayName("빈 문자열 또는 Null을 입력 하는 경우 0을 반환한다")
    @NullAndEmptySource
    void test_빈문자열_null_0반환(String given) {
        StringAddCalculator stringAddCalculator = StringAddCalculator.from(StringNumber.from(given));

        assertThat(stringAddCalculator.calculate()).isZero();
    }

    @ParameterizedTest
    @DisplayName("숫자 하나만 입력 하면 해당 숫자를 반환한다")
    @CsvSource(value = {"1, 1", "10, 10", "100, 100"})
    void test_숫자_한개_반환(String given, int expected) {
        StringAddCalculator stringAddCalculator = StringAddCalculator.from(StringNumber.from(given));
        assertThat(stringAddCalculator.calculate()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("숫자 사이에 구분자(',')를 포함 하면 숫자의 합을 반환한다")
    @ValueSource(strings = {"1,2", "2,1"})
    void test_숫자_두개_합_구분자_한개() {
        StringAddCalculator stringAddCalculator = StringAddCalculator.from(StringNumber.from("1,2"), ",");
        assertThat(stringAddCalculator.calculate()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("숫자 사이에 구분자(',' 또는 '|')를 포함 하면 숫자의 합을 반환한다")
    @ValueSource(strings = {"1,2:3", "1:2,3"})
    void test_숫자_세개_합_구분자_두개(String given) {
        StringAddCalculator stringAddCalculator = StringAddCalculator.from(StringNumber.from(given), ",|:");
        assertThat(stringAddCalculator.calculate()).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 사이에 커스텀 구분자를 포함 하면 숫자의 합을 반환한다")
    void test_숫자_세개_합_구분자_커스텀() {
        StringAddCalculator stringAddCalculator = StringAddCalculator.from(StringNumber.from("//;\n1;2;3"), "//(.)\n(.*)");
        assertThat(stringAddCalculator.calculate()).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("음수를 입력한 경우 'RuntimeException'을 반환한다")
    @ValueSource(strings = {"-1,2,3", "1,-2,3", "1,2,-3"})
    void test_음수_입력_에러(String given) {
        StringAddCalculator stringAddCalculator = StringAddCalculator.from(StringNumber.from(given), ",");
        assertThatThrownBy(() -> {
            stringAddCalculator.calculate();
        }).isInstanceOf(RuntimeException.class).hasMessageContaining("음수는 입력 할 수 없습니다");

    }
}
