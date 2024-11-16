package domain.result;

import java.util.List;

public class Winners {

    private final List<String> winners;

    public static Winners from(List<String> winners) {
        return new Winners(winners);
    }

    public List<String> getWinners() {
        return winners;
    }

    private Winners(List<String> winners) {
        this.winners = winners;
    }
}
