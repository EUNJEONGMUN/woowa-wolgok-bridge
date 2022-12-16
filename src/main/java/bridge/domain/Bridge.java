package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Bridge {

    private final List<Direction> bridge;

    private Bridge(List<String> bridge) {
        this.bridge = bridge.stream()
                .map(Direction::from)
                .collect(Collectors.toUnmodifiableList());
    }

    public static Bridge from(List<String> bridge) {
        return new Bridge(bridge);
    }

    public boolean canMove(Player player, Direction direction) {
        return bridge.get(player.getPosition()).equals(direction);
    }

    public boolean isFinish(Player player) {
        return bridge.size() == player.getPosition();
    }
}