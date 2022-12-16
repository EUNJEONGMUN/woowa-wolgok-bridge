package bridge.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Command {
    RETRY("R"),
    QUIT("Q");

    private final String mark;

    Command(String mark) {
        this.mark = mark;
    }

    private String getMark() {
        return mark;
    }

    private static final Map<String, Command> commands =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Command::getMark, Function.identity())));

    public static Command from(String input) {
        return Optional.ofNullable(commands.get(input)).orElseThrow(
                () -> new IllegalArgumentException("R(재시작) 또는 Q(종료)를 입력해주세요."));
    }

    public boolean isQuit() {
        return this.equals(QUIT);
    }
}