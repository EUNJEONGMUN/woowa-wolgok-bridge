package bridge.view;

public class OutputView {
    private static final String PREFIX_ERROR_MESSAGE = "[ERROR] ";
    private static final String END_GAME_MESSAGE = "최종 게임 결과";
    private static final String GAME_SUCCESS_MESSAGE = "게임 성공 여부: 성공";
    private static final String GAME_FAIL_MESSAGE = "게임 성공 여부: 실패";
    private static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: %d";

    public static void printMap(String bridgeMap) {
        System.out.println(bridgeMap);
    }

    public static void printResult(String bridgeMap, boolean isSuccess, int tryCount) {
        System.out.println(END_GAME_MESSAGE);
        printMap(bridgeMap);
        System.out.println(getSuccessMessage(isSuccess));
        System.out.println(String.format(TRY_COUNT_MESSAGE, tryCount));
    }

    private static String getSuccessMessage(boolean isSuccess) {
        if (isSuccess) {
            return GAME_SUCCESS_MESSAGE;
        }
        return GAME_FAIL_MESSAGE;
    }

    public static void printErrorMessage(String message) {
        System.out.println(PREFIX_ERROR_MESSAGE + message);
    }
}