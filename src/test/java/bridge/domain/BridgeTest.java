package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeTest {
    private Bridge bridge;

    @BeforeEach
    void setUp() {
        bridge = Bridge.from(List.of("U", "D"));
    }

    @DisplayName("다리 건너기 성공 테스트")
    @Test
    void createSuccessMove() {
        Player player = new Player();
        Direction firstMove = Direction.from("U");
        Assertions.assertThat(bridge.canMove(player, firstMove)).isTrue();
    }

    @DisplayName("다리 건너기 실패 테스트")
    @Test
    void createWrongMove() {
        Player player = new Player();
        Direction firstMove = Direction.from("D");
        Assertions.assertThat(bridge.canMove(player, firstMove)).isFalse();
    }
}