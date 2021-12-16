package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Winners;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinnersTest {
    @Test
    void toString메소드_테스트() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(new Winners(list).toString(), "A,B,C");
    }
}