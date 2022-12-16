package bridge.domain;

import java.util.Arrays;

public enum Direction {

    DOWN(0, "D"),
    UP(1, "U");

    private final int code;
    private final String mark;

    Direction(int code, String mark) {
        this.code = code;
        this.mark = mark;
    }

    public static Direction from(String mark) {
        return Arrays.stream(Direction.values()).filter(direction -> direction.mark.equals(mark))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바른 이동 방향을 입력해주세요."));
    }

    public static String findMarkByCode(int code) {
        return Arrays.stream(Direction.values()).filter(direction -> direction.code == code)
                .findAny()
                .get()
                .mark;
    }
}