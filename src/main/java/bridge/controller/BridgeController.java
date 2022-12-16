package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeSize;
import bridge.domain.Command;
import bridge.domain.Direction;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class BridgeController {

    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;

    public void run() {
        initBridge();
        while (true) {
            repeatGame();
            if (bridgeGame.canMove() || isQuit()) {
                endGame();
                break;
            }
            bridgeGame.retry();
        }
    }

    private boolean isQuit() {
        Command command = read(Command::from, InputView::readGameCommand);
        return command.isQuit();
    }

    private void initBridge() {
        BridgeSize bridgeSize = read(BridgeSize::from, InputView::readBridgeSize);
        Bridge bridge = makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridge);
    }

    private void repeatGame() {
        do {
            Direction direction = read(Direction::from, InputView::readMoving);
            bridgeGame.move(direction);
            OutputView.printMap(bridgeGame.getBridgeMap());
        } while (bridgeGame.canMove() && !bridgeGame.isFinish());
    }

    private Bridge makeBridge(BridgeSize size) {
        List<String> bridge = bridgeMaker.makeBridge(size.getSize());
        return Bridge.from(bridge);
    }

    private void endGame() {
        OutputView.printResult(bridgeGame.getBridgeMap(), bridgeGame.canMove(), bridgeGame.getTryCount());
    }

    private <T, R> R read(Function<T, R> object, Supplier<T> input) {
        try {
            return object.apply(input.get());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return read(object, input);
        }
    }
}