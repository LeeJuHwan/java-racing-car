package config;

public class CarRaceConfig {

    private final String carNames;
    private final int labCount;

    private CarRaceConfig(String carNames, int labCount) {
        this.carNames = carNames;
        this.labCount = labCount;
    }

    public static CarRaceConfig of(String carNames, int labCount) {
        return new CarRaceConfig(carNames, labCount);
    }

    public String getCarNames() {
        return carNames;
    }

    public int getLabCount() {
        return labCount;
    }
}
