package bridge.domain;

public class Player {
    private int tryCount = 1;
    private int position = 0;

    public void moveForward() {
        position++;
    }

    public void addTryCount() {
        this.position = 0;
        tryCount++;
    }

    public int getPosition() {
        return position;
    }

    public int getTryCount() {
        return tryCount;
    }
}