package xiii.gb.ticTacToeGui.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
            int[] turnCoords;
            int x, y;
            do {
                if (Game.getHARD_MODE()) {
                    turnCoords = AiMode.hardAI(board);
                    x = turnCoords[0];
                    y = turnCoords[1];
                } else {
                    turnCoords = AiMode.easyAI(board);
                    x = turnCoords[0];
                    y = turnCoords[1];
                }
            } while (!board.isTurnable(x, y));
            System.out.println(x + " " + y);
            board.updateGameField(x, y);
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
}


