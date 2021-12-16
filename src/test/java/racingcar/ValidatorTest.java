package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.utils.Validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {
    private Validator system;
    private Cars cars;

    @BeforeEach
    void initial() {
        system = new Validator();
        cars = new Cars();
    }

    @Test
    void 자동차_입력_예외_발생() {
        assertThrows(IllegalArgumentException.class,
                () -> system.checkValidName("A,B,", cars)
        );
    }

    @Test
    void 올바른_자동차_입력() {
        assertDoesNotThrow(() -> system.checkValidName("car1,car2,car3", cars));
    }

    @Test
    void 숫자_입력_예외_발생() {
        assertThrows(IllegalArgumentException.class,
                () -> system.checkNumber("12A")
        );
    }

    @Test
    void 올바른_숫자_입력() {
        assertDoesNotThrow(() -> system.checkNumber("123"));
    }
}