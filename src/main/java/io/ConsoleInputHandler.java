package io;

import config.CarRaceConfig;
import java.util.Scanner;
import messages.GameMessage;

public class ConsoleInputHandler {

    Scanner scanner = new Scanner(System.in);

    public CarRaceConfig userInputGameConfig() {
        System.out.println(GameMessage.userInputCarNames);
        String carNames = scanner.nextLine();

        System.out.println(GameMessage.userInputFinalLabs);
        int finalLab = scanner.nextInt();

        return CarRaceConfig.of(carNames, finalLab);
    }

}
