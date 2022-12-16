package bridge.domain;

public class BridgeSize {
    private static final int BRIDGE_SIZE_MIN = 3;
    private static final int BRIDGE_SIZE_MAX = 20;
    private static final String BRIDGE_SIZE_ERROR = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    private final int size;

    private BridgeSize(int size) {
        validateBridgeSize(size);
        this.size = size;
    }

    public static BridgeSize from(int size) {
        return new BridgeSize(size);
    }

    public int getSize() {
        return size;
    }

    private void validateBridgeSize(int size) {
        if (size < BRIDGE_SIZE_MIN || size > BRIDGE_SIZE_MAX) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
    }
}