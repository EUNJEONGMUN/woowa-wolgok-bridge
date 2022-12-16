package bridge.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @DisplayName("숫자가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest()
    @ValueSource(strings = {"*", "!", "3*"})
    void validIsNumber(String input) {
        Assertions.assertThatThrownBy(() -> InputView.validIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해야 합니다.");
    }
}