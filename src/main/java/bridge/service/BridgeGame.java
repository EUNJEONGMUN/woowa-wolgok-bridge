package bridge.service;

import bridge.domain.*;

public class BridgeGame {
    private final Bridge bridge;
    private BridgeMap bridgeMap = new BridgeMap();
    private Player player = new Player();
    private GameState gameState = GameState.CONTINUE;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public void move(Direction direction) {
        updateState(player, direction);
        bridgeMap.addBridgeMap(direction, gameState);
        player.moveForward();
    }

    private void updateState(Player player, Direction direction) {
        if (!bridge.canMove(player, direction)) {
            gameState = GameState.FAIL;
        }
    }

    public boolean canMove() {
        return gameState.isContinue();
    }

    public boolean isFinish() {
        return bridge.isFinish(player);
    }

    public void retry() {
        bridgeMap.init();
        player.addTryCount();
        gameState = GameState.CONTINUE;
    }

    public String getBridgeMap() {
        return bridgeMap.getBridgeMap();
    }

    public int getTryCount() {
        return player.getTryCount();
    }
}
