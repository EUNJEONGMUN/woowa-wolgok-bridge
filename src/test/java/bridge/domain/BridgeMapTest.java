package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeMapTest {

    @DisplayName("다리를 건너는데 성공했을 경우")
    @ParameterizedTest
    @CsvSource(value = {"U:[ O ]:[   ]", "D:[   ]:[ O ]"}, delimiter = ':')
    void crossSuccessBridge(String direction, String topMap, String bottomMap) {
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.addBridgeMap(Direction.from(direction), GameState.CONTINUE);
        Assertions.assertThat(bridgeMap.getBridgeMap()).isEqualTo(topMap + "\n" + bottomMap);
    }

    @DisplayName("다리를 건너는데 실패했을 경우")
    @ParameterizedTest
    @CsvSource(value = {"U:[ X ]:[   ]", "D:[   ]:[ X ]"}, delimiter = ':')
    void crossFailBridge(String direction, String topMap, String bottomMap) {
        BridgeMap bridgeMap = new BridgeMap();
        bridgeMap.addBridgeMap(Direction.from(direction), GameState.FAIL);
        Assertions.assertThat(bridgeMap.getBridgeMap()).isEqualTo(topMap + "\n" + bottomMap);
    }
}