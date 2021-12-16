package racingcar.model;

import racingcar.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String NOW_CARS_SENTENCE = " (현재 자동차 목록 = ";
    private static final String CLOSE_BRACKET = ")";

    private List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public void addNewCar(Car car) {
        cars.add(car);
    }

    public void racing() {
        cars.forEach(Car::go);
    }

    public String getNowCarList() {
        StringBuilder sb = new StringBuilder(NOW_CARS_SENTENCE);
        sb.append(getNamesString())
                .append(CLOSE_BRACKET);
        return sb.toString();
    }

    public boolean haveWinner(int cnt) {
        return cars.stream()
                .anyMatch(car -> car.isWinner(cnt));
    }

    public List<String> getWinners(int cnt) {
        return cars.stream()
                .filter(car -> car.isWinner(cnt))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<String> getNameList() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private String getNamesString() {
        List<String> names = getNameList();
        return StringUtil.joinStringList(names);
    }
}
