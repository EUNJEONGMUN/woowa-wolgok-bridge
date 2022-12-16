package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String READ_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String READ_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String READ_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final String NOT_NUMBER_ERROR = "숫자를 입력해야 합니다.";

    public static int readBridgeSize() {
        System.out.println(START_GAME_MESSAGE);
        System.out.println(READ_BRIDGE_SIZE_MESSAGE);
        String bridgeSize = Console.readLine();
        validIsNumber(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public static String readMoving() {
        System.out.println(READ_MOVING_MESSAGE);
        return Console.readLine();
    }

    public static String readGameCommand() {
        System.out.println(READ_GAME_COMMAND_MESSAGE);
        return Console.readLine();
    }

    public static void validIsNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
    }
}