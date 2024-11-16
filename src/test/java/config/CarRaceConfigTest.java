package config;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRaceConfigTest {

    @Test
    @DisplayName("사용자가 자동차 이름을 입력 한 값을 상태로 관리한다 ")
    void test_게임_설정값_차_이름_검증() {
        CarRaceConfig carRaceConfig = CarRaceConfig.of("a,b", 5);
        assertThat(carRaceConfig.getCarNames()).isEqualTo("a,b");
    }

    @Test
    @DisplayName("사용자가 자동차 이름을 입력 한 값을 상태로 관리한다 ")
    void test_게임_설정값_진행_횟수_검증() {
        CarRaceConfig carRaceConfig = CarRaceConfig.of("a,b", 5);
        assertThat(carRaceConfig.getLabCount()).isEqualTo(5);
    }
}
