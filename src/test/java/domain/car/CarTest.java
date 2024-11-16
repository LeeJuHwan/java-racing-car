package domain.car;

import static org.assertj.core.api.Assertions.*;

import exception.GameException;
import messages.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 이름은 5글자를 초과 할 수 없다")
    @NullAndEmptySource
    @ValueSource(strings = {"testabc"})
    void test_자동차_단일_객체_생성(String given) {

        assertThatThrownBy(() -> {
            Car.from(given);
        })
                .isInstanceOf(GameException.class)
                .hasMessage(ErrorMessage.invalidCarName);
    }

    @ParameterizedTest
    @DisplayName("자동차가 전진 하기 위해 0과 9의 숫자만 입력한다")
    @ValueSource(ints = {-1, 10})
    void test_자동차_전진_메서드_인자_검증(int move) {

        Car car = Car.from("test");
        assertThatThrownBy(() -> {
            car.moveForward(move);
        })
                .isInstanceOf(GameException.class)
                .hasMessage(ErrorMessage.invalidCarMoveThresold);
    }

    @ParameterizedTest
    @DisplayName("자동차는 4 이상 나올 시 앞으로 한 칸 전진한다")
    @CsvSource(value = {"0,0", "3,0", "4,1", "9,1"})
    void test_자동차_전진_메서드_검증(int move, int position) {
        Car car = Car.from("test");
        car.moveForward(move);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @Test
    @DisplayName("자동차는 전진 하면 객체의 위치 값이 1 증가한다")
    void test_자동차_전진_후_위치값_검증() {
        Car car = Car.from("test");
        assertThat(car.getPosition()).isEqualTo(0);
        car.moveForward(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
