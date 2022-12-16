package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class DirectionTest {

    @DisplayName("0을 입력하면 D, 1을 입력하면 U를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:D", "1:U"}, delimiter = ':')
    void findMarkByCode(int code, String expected) {
        String result = Direction.findMarkByCode(code);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("U 또는 D가 아닐 경우 예외처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q", "ABC"})
    void createInvalidCommand(String input) {
        Assertions.assertThatThrownBy(() -> Direction.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 이동 방향을 입력해주세요.");
    }

    @DisplayName("U 또는 D를 입력할 경우 정상적으로 Direction 객체를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"U:UP", "D:DOWN"}, delimiter = ':')
    void createValidCommand(String input, Direction expected) {
        Direction result = Direction.from(input);
        Assertions.assertThat(result).isEqualTo(expected);
    }
}