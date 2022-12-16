package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CommandTest {

    @DisplayName("Q는 게임 종료를 의미한다.")
    @Test
    void createQuitCommand() {
        Command command = Command.from("Q");
        boolean result = command.isQuit();
        Assertions.assertThat(result).isTrue();
    }

    @DisplayName("R 또는 Q가 아닐 경우 예외처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D", "ABC"})
    void createInvalidCommand(String input) {
        Assertions.assertThatThrownBy(() -> Command.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("R(재시작) 또는 Q(종료)를 입력해주세요.");
    }

    @DisplayName("R 또는 Q를 입력할 경우 정상적으로 Command 객체를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"R:RETRY", "Q:QUIT"}, delimiter = ':')
    void createValidCommand(String input, Command expected) {
        Command result = Command.from(input);
        Assertions.assertThat(result).isEqualTo(expected);
    }
}