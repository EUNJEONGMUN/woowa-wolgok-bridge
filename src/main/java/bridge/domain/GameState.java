package bridge.domain;

public enum GameState {
    CONTINUE, FAIL;

    public boolean isContinue() {
        return this.equals(CONTINUE);
    }
}
