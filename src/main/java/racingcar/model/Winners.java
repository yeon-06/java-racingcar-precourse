package racingcar.model;

import java.util.List;

public class Winners {
    private List<String> winners;

    public Winners(List<String> winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        return String.join(",", winners);
    }
}
