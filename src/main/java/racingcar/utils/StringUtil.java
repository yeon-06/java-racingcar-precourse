package racingcar.utils;

import java.util.List;

public class StringUtil {
    private static final String DELIMITER = ", ";

    public static String joinStringList(List<String> list) {
        return String.join(DELIMITER, list);
    }
}
