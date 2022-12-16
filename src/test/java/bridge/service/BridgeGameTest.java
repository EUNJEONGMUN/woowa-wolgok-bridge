package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        Bridge bridge = Bridge.from(List.of("U", "D", "U"));
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("다리 건너기 성공 이동 테스트")
    @Test
    void createSuccessMove() {
        Direction direction = Direction.from("U");
        bridgeGame.move(direction);
        Assertions.assertThat(bridgeGame.canMove()).isTrue();
    }

    @DisplayName("다리 건너기 실패 이동 테스트")
    @Test
    void createWrongMove() {
        Direction direction = Direction.from("D");
        bridgeGame.move(direction);
        Assertions.assertThat(bridgeGame.canMove()).isFalse();
    }


    @DisplayName("다리를 끝까지 건너면 isFinish 메서드가 true 반환한다.")
    @Test
    void createFinishMove() {
        bridgeGame.move(Direction.from("U"));
        bridgeGame.move(Direction.from("D"));
        bridgeGame.move(Direction.from("U"));

        Assertions.assertThat(bridgeGame.isFinish()).isTrue();
    }

    @DisplayName("다리를 끝까지 건너지 않으면 isFinish 메서드가 false를 반환한다.")
    @Test
    void createNotFininshMove() {
        bridgeGame.move(Direction.from("U"));
        bridgeGame.move(Direction.from("D"));

        Assertions.assertThat(bridgeGame.isFinish()).isFalse();
    }
}