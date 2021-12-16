package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Winners;
import racingcar.view.InputView;

import java.util.List;

public class RacingController {
    private static final String WINNER_SENTENCE = "최종 우승자 : ";
    private static final InputView inputSystem = new InputView();

    private Cars cars = new Cars();
    private Winners winners;
    private int cnt = 0;

    public RacingController() {
    }

    public void input() {
        inputSystem.inputCarName(cars);
        cnt = inputSystem.inputTryCnt();
    }

    public void racingStart() {
        while (!cars.haveWinner(cnt)) {
            cars.racing();
            System.out.println();
        }
        setWinners(cars.getWinners(cnt));
    }

    public void printWinners() {
        System.out.println(WINNER_SENTENCE + winners.toString());
    }

    private void setWinners(List<String> winnerList) {
        this.winners = new Winners(winnerList);
    }
}
