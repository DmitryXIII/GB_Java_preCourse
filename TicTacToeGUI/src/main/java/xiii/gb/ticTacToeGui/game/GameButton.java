package xiii.gb.ticTacToeGui.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameButton extends JButton {
    private int buttonIndex;
    private GameBoard board;

    public GameButton(int gameButtonIndex, GameBoard currentGameBoard) {
        this.buttonIndex = gameButtonIndex;
        this.board = currentGameBoard;

        int rowNum = this.buttonIndex / GameBoard.dimension;
        int cellNum = this.buttonIndex % GameBoard.dimension;

        setSize(GameBoard.cellSize - 5, GameBoard.cellSize - 5);
        addActionListener(new GameActionListener(rowNum, cellNum, this));
    }

    public GameBoard getBoard() {
        return board;
    }
}

