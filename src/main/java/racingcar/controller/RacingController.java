package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.model.Car;
import racingcar.model.Winners;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private InputView inputSystem = new InputView();
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
        System.out.println("최종 우승자 : " + winners.toString());
    }

    private void setWinners(List<String> winnerList) {
        this.winners = new Winners(winnerList);
    }
}
