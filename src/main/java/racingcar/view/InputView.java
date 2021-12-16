package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.regex.Pattern;

public class InputView {
    private static final String INPUT_CAR_SENTENCE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ERROR_CAR_SENTENCE = "[ERROR] 올바른 자동차 이름을 입력하세요.";
    private static final String INPUT_CNT_SENTENCE = "시도할 회수는 몇회인가요?";
    private static final String ERROR_CNT_SENTENCE = "[ERROR] 올바른 숫자를 입력하세요.";
    private static final String SEPARATOR = ",";
    private static final String NUMBER_REGAX = "^[0-9]*$";
    private static final int MAX_LENGTH = 5;
    private static final int NEGATIVE_NUMBER = -1;

    public InputView() {
    }

    public void inputCarName(Cars cars) {
        String input = write(INPUT_CAR_SENTENCE);
        try {
            checkValidName(input, cars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputCarName(cars);
        }
    }

    public int inputTryCnt() {
        String input = write(INPUT_CNT_SENTENCE);
        try {
            checkNumber(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputTryCnt();
        }
    }

    public void checkNumber(String input) {
        if (!isNumber(input) || !isUnderMax(input)) {
            throw new IllegalArgumentException(ERROR_CNT_SENTENCE);
        }
    }

    public void checkValidName(String input, Cars cars) {
        String[] nameArray = input.split(SEPARATOR, NEGATIVE_NUMBER);
        for (String name : nameArray) {
            if (isInvalidName(name, cars)) {
                throw new IllegalArgumentException(ERROR_CAR_SENTENCE + cars.getNowCarList());
            }
            cars.addNewCar(new Car(name));
        }
    }

    private String write(String sentence) {
        System.out.println(sentence);
        return Console.readLine();
    }

    private boolean isNumber(String str) {
        return Pattern.matches(NUMBER_REGAX, str);
    }

    private boolean isUnderMax(String str) {
        return Long.parseLong(str) <= Integer.MAX_VALUE;
    }

    private boolean isInvalidName(String name, Cars cars) {
        return isDuplicated(name, cars)
                || isOverMaxCnt(name)
                || isEmptyString(name);
    }

    private boolean isDuplicated(String name, Cars cars) {
        for (String carName : cars.getNameList()) {
            if (name.equals(carName)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOverMaxCnt(String name) {
        return name.length() > MAX_LENGTH;
    }

    private boolean isEmptyString(String name) {
        return name == null || "".equals(name);
    }

}
