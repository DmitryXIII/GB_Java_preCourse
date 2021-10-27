package xiii.gb.ticTacToeGui.game;

import java.util.Random;

public class AiMode {

    private static Random RND = new Random();

    public static int[] easyAI(GameBoard board) {
        int[] turnCoords = new int[2];
        turnCoords[0] = RND.nextInt(GameBoard.dimension);
        turnCoords[1] = RND.nextInt(GameBoard.dimension);
        return turnCoords;
    }

    public static int[] hardAI(GameBoard board) {
        int x = 0, y = 0;
        int isTurnDone = 0;
        int[] turnCoords = new int[2];
        while (true) {
            //ход в центр
            if (board.getGameField(1, 1) == GameBoard.getNullSymbol()) {
                x = 1;
                y = 1;
                break;
            }

            //проверка строк на победные комбинации
            for (int i = 0; i < 3; i++) {
                int lineAIWeight = 0;
                for (int j = 0; j < 3; j++) {
                    if (board.getGameField(i, j) == board.getGame().getCurrentPlayer().getPlayerSign()) {
                        lineAIWeight++;
                        if (lineAIWeight == 2) {
                            for (int k = 0; k < 3; k++) {
                                if (board.getGameField(i, k) == GameBoard.getNullSymbol()) {
                                    x = i;
                                    y = k;
                                    isTurnDone = 1;
                                    break;
                                }
                            }
                        }
                    }
                    if (isTurnDone == 1) break;
                }
                if (isTurnDone == 1) break;
            }

            //проверка колонок на победные комбинации
            for (int i = 0; i < 3; i++) {
                int columnAIWeight = 0;
                for (int j = 0; j < 3; j++) {
                    if (board.getGameField(j, i) == board.getGame().getCurrentPlayer().getPlayerSign()) {
                        columnAIWeight++;
                        if (columnAIWeight == 2) {
                            for (int k = 0; k < 3; k++) {
                                if (board.getGameField(k, i) == GameBoard.getNullSymbol()) {
                                    x = k;
                                    y = i;
                                    isTurnDone = 1;
                                    break;
                                }
                            }
                        }
                    }
                    if (isTurnDone == 1) break;
                }
                if (isTurnDone == 1) break;
            }

            //проверка диагонали 1 на победные комбинации
            int diagonal_1_AIWeight = 0;
            for (int i = 0; i < 3; i++) {
                if (board.getGameField(i, i) == board.getGame().getCurrentPlayer().getPlayerSign()) {
                    diagonal_1_AIWeight++;
                    if (diagonal_1_AIWeight == 2) {
                        for (int j = 0; j < 3; j++) {
                            if (board.getGameField(j, j) == GameBoard.getNullSymbol()) {
                                x = j;
                                y = j;
                                isTurnDone = 1;
                                break;
                            }
                        }
                    }
                }
                if (isTurnDone == 1) break;
            }
            if (isTurnDone == 1) break;

            //проверка диагонали 2 на победные комбинации
            int diagonal_2_AIWeight = 0;
            for (int i = 0; i < 3; i++) {
                if (board.getGameField(i, (2 - i)) == board.getGame().getCurrentPlayer().getPlayerSign()) {
                    diagonal_2_AIWeight++;
                    if (diagonal_2_AIWeight == 2) {
                        for (int j = 0; j < 3; j++) {
                            if (board.getGameField(j, 2 - j) == GameBoard.getNullSymbol()) {
                                x = j;
                                y = 2 - j;
                                isTurnDone = 1;
                                break;
                            }
                        }
                    }
                }
                if (isTurnDone == 1) break;
            }
            if (isTurnDone == 1) break;

            // проверка строк на необходимость закрыть победную комбинацию соперника
            for (int i = 0; i < 3; i++) {
                int lineUserWeight = 0;
                for (int j = 0; j < 3; j++) {
                    if (board.getGameField(i, j) == 'X') {
                        lineUserWeight++;
                        if (lineUserWeight == 2) {
                            for (int k = 0; k < 3; k++) {
                                if (board.getGameField(i, k) == GameBoard.getNullSymbol()) {
                                    x = i;
                                    y = k;
                                    isTurnDone = 1;
                                    break;
                                }
                            }
                        }
                    }
                    if (isTurnDone == 1) break;
                }
                if (isTurnDone == 1) break;
            }
            if (isTurnDone == 1) break;

            // проверка колонок на необходимость закрыть победную комбинацию соперника
            for (int i = 0; i < 3; i++) {
                int columnUserWeight = 0;
                for (int j = 0; j < 3; j++) {
                    if (board.getGameField(j, i) == 'X') {
                        columnUserWeight++;
                        if (columnUserWeight == 2) {
                            for (int k = 0; k < 3; k++) {
                                if (board.getGameField(k, i) == GameBoard.getNullSymbol()) {
                                    x = k;
                                    y = i;
                                    isTurnDone = 1;
                                    break;
                                }
                            }
                        }
                    }
                    if (isTurnDone == 1) break;
                }
                if (isTurnDone == 1) break;
            }
            if (isTurnDone == 1) break;

            // проверка диагонали 1 на необходимость закрыть победную комбинацию соперника
            int diagonal_1_UserWeight = 0;
            for (int i = 0; i < 3; i++) {
                if (board.getGameField(i, i) == 'X') {
                    diagonal_1_UserWeight++;
                    if (diagonal_1_UserWeight == 2) {
                        for (int j = 0; j < 3; j++) {
                            if (board.getGameField(j, j
                            ) == GameBoard.getNullSymbol()) {
                                x = j;
                                y = j;
                                isTurnDone = 1;
                                break;
                            }
                        }
                    }
                }
                if (isTurnDone == 1) break;
            }
            if (isTurnDone == 1) break;

            // проверка диагонали 2 на необходимость закрыть победную комбинацию соперника
            int diagonal_2_UserWeight = 0;
            for (int i = 0; i < 3; i++) {
                if (board.getGameField(i, 2 - i) == 'X') {
                    diagonal_2_UserWeight++;
                    if (diagonal_2_UserWeight == 2) {
                        for (int j = 0; j < 3; j++) {
                            if (board.getGameField(j, 2 - j) == GameBoard.getNullSymbol()) {
                                x = j;
                                y = 2 - j;
                                isTurnDone = 1;
                                break;
                            }
                        }
                    }
                }
                if (isTurnDone == 1) break;
            }
            if (isTurnDone == 1) break;

            //ход в угол
            if (board.getGameField(0, 0) == GameBoard.getNullSymbol()) {
                x = 0;
                y = 0;
                break;
            } else if (board.getGameField(0, 2) == GameBoard.getNullSymbol()) {
                x = 0;
                y = 2;
                break;
            } else if (board.getGameField(2, 2) == GameBoard.getNullSymbol()) {
                x = 2;
                y = 2;
                break;
            }
        }

        turnCoords[0] = x;
        turnCoords[1] = y;
        return turnCoords;
    }
}
