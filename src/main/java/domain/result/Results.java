package domain.result;

import domain.car.Car;
import exception.GameException;
import java.util.List;
import java.util.stream.Collectors;
import messages.ErrorMessage;

public class Results {

    private final List<Result> results;

    public static Results from(List<Result> results) {
        return new Results(results);
    }

    public Winners getWinner() {

        List<Car> cars = getFinalScore().getCars();
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new GameException(ErrorMessage.CarsNotFound));

        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());

        return Winners.from(winners.stream().map(Car::getCarName).collect(Collectors.toList()));
    }

    private Results(List<Result> results) {
        this.results = results;
    }

    private Result getFinalScore() {
        return results.get(results.size() - 1);
    }


}
