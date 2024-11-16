package domain.car;

import exception.GameException;
import java.util.List;
import java.util.stream.Collectors;
import messages.ErrorMessage;

public class CarFactory {

    private final List<String> carNames;

    public static Cars from(String carNames) {
        return new CarFactory(carNames).createCars();

    }

    private CarFactory(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new GameException(ErrorMessage.invalidCarName);
        }

        this.carNames = splitByComma(carNames);
    }

    private List<String> splitByComma(String carNameString) {
        return List.of(carNameString.split(","));
    }

    private Cars createCars() {
        return Cars.from(carNames.stream()
                .map(String::trim)
                .map(Car::from)
                .collect(Collectors.toList()));
    }

}
