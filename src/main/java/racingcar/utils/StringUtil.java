package racingcar.utils;

import java.util.List;

public class StringUtil {
    public static String joinStringList(List<String> list) {
        return String.join(", ", list);
    }
}
