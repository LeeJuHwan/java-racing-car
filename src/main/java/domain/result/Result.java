package domain.result;

import domain.car.Car;
import domain.car.Cars;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private final int runningLap;
    private final Cars cars;

    public static Result of(int runningLap, Cars cars) {
        return new Result(runningLap, cars);
    }

    public List<String> getResult() {
        return cars.getCars().stream()
                .map(car -> car.getCarName() + " : " + convertPositionNumberToEmoji(car))
                .collect(Collectors.toList());
    }

    public int getRunningLap() {
        return runningLap;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars.getCars());
    }

    private Result(int runningLap, Cars cars) {
        this.runningLap = runningLap;
        this.cars = cars;
    }

    private String convertPositionNumberToEmoji(Car car) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }

        return String.valueOf(sb);
    }

}
