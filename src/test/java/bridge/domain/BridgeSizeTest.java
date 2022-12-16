package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeTest {

    @DisplayName("다리 길이가 3이상, 20이하가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 2, 21, 100})
    void createBridgeSizeOverRange(int input) {
        Assertions.assertThatThrownBy(() -> BridgeSize.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}