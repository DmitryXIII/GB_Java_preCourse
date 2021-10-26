package xiii.gb.ticTacToeGui.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class GameActionListener implements ActionListener {
    private int row;
    private int cell;
    private GameButton button;

    public GameActionListener(int row, int cell, GameButton gButton) {
        this.row = row;
        this.cell = cell;
        this.button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        if (board.isTurnable(row, cell)) {
            updateByPlayersData(board);
            if (board.isFull()) {
                board.getGame().showMessage("Ничья!");
                board.getGame().passTurn();
                board.emptyField();
            } else {
                updateByAiData(board);
            }
        } else {
            board.getGame().showMessage("Ячейка уже занята");
        }
    }

    private void updateByPlayersData(GameBoard board) {
        board.updateGameField(row, cell);
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));
        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Победа!");
            board.emptyField();
        } else {
            board.getGame().passTurn();
        }
    }

    private void updateByAiData(GameBoard board) {
        if (!board.isEmpty()) {
            int x, y;
            //Random rnd = new Random();
            do {
                x = getTurnCoords(board)[0];
                y = getTurnCoords(board)[1];
            } while (!board.isTurnable(x, y));

            board.updateGameField(x, y);
            System.out.println(x + " " + y);
            int cellIndex = GameBoard.dimension * x + y;
            board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

            if (board.checkWin()) {
                button.getBoard().getGame().showMessage("Компьютер выиграл!");
                board.getGame().passTurn();
                board.emptyField();

            } else {
                board.getGame().passTurn();
            }
        }
    }

    private int[] getTurnCoords(GameBoard board) {
        int x = 0, y = 0;
        int isTurnDone = 0;
        int[] turnCoords = new int[2];
        Random rnd = new Random();
        while (true) {
//ход в центр
            if (board.getGameField(1, 1) == GameBoard.getNullSymbol()) {
                x = 1;
                y = 1;
                break;
            }
            /**
             * проверка строк на победные комбинации
             */
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
            /**
             * проверка диагонали 1 на победные комбинации
             */
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

            /**
             * проверка диагонали 2 на победные комбинации
             */
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

            //случайный ход
            if (isTurnDone == 1) break;
            x = rnd.nextInt(GameBoard.dimension);
            y = rnd.nextInt(GameBoard.dimension);
            break;

        }

        turnCoords[0] = x;
        turnCoords[1] = y;
        return turnCoords;
    }
}


