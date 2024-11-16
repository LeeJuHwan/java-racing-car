package domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

    @Test
    @DisplayName("자동차 이름을 ','로 구분하여 입력 하면 자동차 객체의 배열로 반환한다")
    void test_자동차_이름_분리() {
        String given = "a, b";
        Cars fixture = Cars.from(List.of(Car.from("a"), Car.from("b")));
        assertThat(CarFactory.from(given)).isEqualTo(fixture);
    }

}
