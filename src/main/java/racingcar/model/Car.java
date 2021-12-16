package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int STANDARD_NUMBER = 4;
    private static final int START_POSITION = 0;
    private static final String STATUS_BAR = "-";
    private static final String SEPARATOR = " : ";

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

    public void go() {
        int random = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (isBiggerThanStandard(random)) {
            position++;
        }
        System.out.println(this);
    }

    public boolean isWinner(int cnt) {
        return position == cnt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(SEPARATOR);

        for (int i = 0; i < position; i++) {
            sb.append(STATUS_BAR);
        }
        return sb.toString();
    }

    private boolean isBiggerThanStandard(int num) {
        return STANDARD_NUMBER <= num;
    }
}
