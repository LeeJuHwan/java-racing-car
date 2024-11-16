import application.CarRace;
import config.CarRaceConfig;
import io.ConsoleInputHandler;

public class CarRaceApplication {

    private static final ConsoleInputHandler inputHandler = new ConsoleInputHandler();

    public static void main(String[] args) {
        CarRaceConfig config = inputHandler.userInputGameConfig();
        CarRace carRaceGame = CarRace.from(config);
        carRaceGame.raceStart();
    }

}
