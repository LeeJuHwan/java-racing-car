package io;

import domain.result.Result;
import domain.result.Winners;
import messages.GameMessage;

public class ConsoleOutputHandler {

    public void printScreenCarRaceResult(Result result) {
        System.out.println("Lab: " + result.getRunningLap());
        result.getResult().forEach(System.out::println);
    }

    public void printRaceResult(Winners winners) {
        System.out.println(getWinnerNames(winners));
    }

    private String getWinnerNames(Winners winners) {
        return String.join(", ", winners.getWinners()) + GameMessage.finalWinnerSuffix;
    }

}
