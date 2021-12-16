package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;
import racingcar.utils.Validator;

public class InputView {
    private static final String INPUT_CAR_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_CNT_SENTENCE = "시도할 회수는 몇회인가요?";
    private static final Validator validator = new Validator();

    public InputView() {
    }

    public void inputCarName(Cars cars) {
        String input = write(INPUT_CAR_SENTENCE);
        try {
            validator.checkValidName(input, cars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputCarName(cars);
        }
    }

    public int inputTryCnt() {
        String input = write(INPUT_CNT_SENTENCE);
        try {
            validator.checkNumber(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputTryCnt();
        }
    }

    private String write(String sentence) {
        System.out.println(sentence);
        return Console.readLine();
    }
}