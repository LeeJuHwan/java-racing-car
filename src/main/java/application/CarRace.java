package application;

import config.CarRaceConfig;
import domain.car.CarFactory;
import domain.car.Cars;
import domain.result.Result;
import domain.result.Results;
import io.ConsoleOutputHandler;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.RandomUtil;

public class CarRace {

    public static final int BOUND = 9;
    private static final ConsoleOutputHandler outputHandler = new ConsoleOutputHandler();
    private final RandomUtil randomUtil = new RandomUtil();
    private final Cars cars;
    private final int lap;


    public static CarRace from(CarRaceConfig config) {
        Cars cars = CarFactory.from(config.getCarNames());
        return new CarRace(cars, config.getLabCount());
    }

    private CarRace(Cars cars, int lap) {
        this.cars = cars;
        this.lap = lap;
    }

    public void raceStart() {
        Results raceResult = Results.from(IntStream.range(1, lap + 1)
                .mapToObj(this::runOneLab)
                .peek(outputHandler::printScreenCarRaceResult)
                .collect(Collectors.toList()));

        outputHandler.printRaceResult(raceResult.getWinner());
    }


    private Result runOneLab(int runningLab) {
        return Result.of(runningLab, Cars.from(
                        cars.getCars()
                                .stream()
                                .peek(car -> car.moveForward(getRunOneLapMoveNumber()))
                                .collect(Collectors.toList())
                )
        );

    }

    public Cars getCars() {
        return cars;
    }

    public int getLap() {
        return lap;
    }

    public int getRunOneLapMoveNumber() {
        return randomUtil.getRandomNumber(BOUND);
    }

}
