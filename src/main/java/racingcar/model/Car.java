package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int STANDARD_NUMBER = 4;
    private static final int START_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, START_POSITION);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void go() {
        int random = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (isBiggerThanStandard(random)) {
            position++;
        }
        System.out.println(getCarStatus());
    }

    public boolean isWinner(int cnt) {
        return position == cnt;
    }

    public String getCarStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");

        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public String getWinnersName(int cnt) {
        if (position == cnt) {
            return name;
        }
        return null;
    }

    private boolean isBiggerThanStandard(int num) {
        return STANDARD_NUMBER <= num;
    }
}