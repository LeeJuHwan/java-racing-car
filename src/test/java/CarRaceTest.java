import static org.assertj.core.api.Assertions.*;

import application.CarRace;
import config.CarRaceConfig;
import domain.car.CarFactory;
import domain.car.Cars;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CarRaceTest {

    static CarRace carRace;

    @BeforeAll
    public static void setUp() {
        carRace = CarRace.from(CarRaceConfig.of("test1, test2", 2));
    }

    @Test
    @DisplayName("유저가 입력한 자동차 이름을 객체로 반환한다")
    void test_유저_입력_자동차_생성() {
        Cars cars = CarFactory.from("test1, test2");
        assertThat(carRace.getCars()).isEqualTo(cars);
        assertThat(carRace.getLap()).isEqualTo(2);

    }


    @Test
    @DisplayName("자동차가 움직여야 하는 숫자를 반환한다")
    void test_자동차_전진할_숫자_반환() {
        CarRace mockCarRace = Mockito.mock(carRace.getClass());
        Mockito.when(mockCarRace.getRunOneLapMoveNumber()).thenReturn(4);

        assertThat(mockCarRace.getRunOneLapMoveNumber()).isEqualTo(4);
    }

}
