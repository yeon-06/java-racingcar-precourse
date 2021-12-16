package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void 자동차_상태_문자열() {
        Car car = new Car("a",3);
        assertEquals("a : ---", car.toString());
    }
}