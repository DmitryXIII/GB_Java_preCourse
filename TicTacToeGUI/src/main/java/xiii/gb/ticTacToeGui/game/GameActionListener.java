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

            if (board.getGameField(1, 1) == GameBoard.getNullSymbol()) {
                x = 1;
                y = 1;
                isTurnDone = 1;
            }
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


