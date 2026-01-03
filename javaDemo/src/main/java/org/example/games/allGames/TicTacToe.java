package org.example.games.allGames;

import org.example.games.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe extends JFrame implements ActionListener, Game {
    @Override
    public void start(Scanner sc) {
        System.out.println("running TicTacToe...");
        TicTacToe ticTacToe = new TicTacToe();


    }
    JButton[][] buttons = new JButton[3][3];
    JButton resetButton;
    JLabel scoreLabel;
    JComboBox<String> modeBox;
    char currentPlayer = 'X';   // Human = X, AI = O
    boolean gameOver = false;

    int xScore = 0;
    int oScore = 0;
    boolean vsAI = true;
    Random random = new Random();

    public TicTacToe() {
        System.out.println("running.........");
        setTitle("Tic Tac Toe - AI");
        setSize(500, 550);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Score Label
        scoreLabel = new JLabel("X: 0   O: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(scoreLabel, BorderLayout.NORTH);

        //top panel(mode + score)
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        modeBox = new JComboBox<>(new String[]{
                "Player vs Computer",
                "Player vs Player"
        });
        modeBox.setFont(new Font("Arial", Font.BOLD, 16));
        modeBox.addActionListener(e -> switchMode());
        topPanel.add(modeBox);

        scoreLabel = new JLabel("X: 0   O: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(scoreLabel);

        add(topPanel, BorderLayout.NORTH);
        // Game Board
        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        Font font = new Font("Arial", Font.BOLD, 60);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(font);
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                boardPanel.add(buttons[i][j]);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        // Reset Button
        resetButton = new JButton("Reset Game");
        resetButton.setFont(new Font("Arial", Font.BOLD, 16));
        resetButton.addActionListener(e -> resetBoard());
        add(resetButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        JButton clicked = (JButton) e.getSource();

        if (!clicked.getText().equals("")) return;

        makeMove(clicked, currentPlayer);

        if (checkGameEnd()) return;

        switchPlayer();
        if(vsAI && currentPlayer == '0'){
            aiMove();
        }
    }
    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private void makeMove(JButton button, char player) {
        button.setText(String.valueOf(player));
        button.setForeground(player == 'X' ? Color.BLUE : Color.RED);
    }

    private void aiMove() {
        if (gameOver) return;

        JButton move = findBestMove();
        makeMove(move, 'O');

        checkGameEnd();
        switchPlayer();
    }

    private JButton findBestMove() {
        // Try to win
        JButton winMove = findWinningMove('O');
        if (winMove != null) return winMove;

        // Try to block
        JButton blockMove = findWinningMove('X');
        if (blockMove != null) return blockMove;

        // Random move
        while (true) {
            int r = random.nextInt(3);
            int c = random.nextInt(3);
            if (buttons[r][c].getText().equals(""))
                return buttons[r][c];
        }
    }

    private JButton findWinningMove(char player) {
        for (int i = 0; i < 3; i++) {
            // Rows
            JButton b = checkLineForWin(player, buttons[i][0], buttons[i][1], buttons[i][2]);
            if (b != null) return b;

            // Columns
            b = checkLineForWin(player, buttons[0][i], buttons[1][i], buttons[2][i]);
            if (b != null) return b;
        }

        JButton b = checkLineForWin(player, buttons[0][0], buttons[1][1], buttons[2][2]);
        if (b != null) return b;

        return checkLineForWin(player, buttons[0][2], buttons[1][1], buttons[2][0]);
    }

    private JButton checkLineForWin(char player, JButton b1, JButton b2, JButton b3) {
        int count = 0;
        JButton empty = null;

        if (b1.getText().equals(String.valueOf(player))) count++;
        else if (b1.getText().equals("")) empty = b1;

        if (b2.getText().equals(String.valueOf(player))) count++;
        else if (b2.getText().equals("")) empty = b2;

        if (b3.getText().equals(String.valueOf(player))) count++;
        else if (b3.getText().equals("")) empty = b3;

        return (count == 2 && empty != null) ? empty : null;
    }

    private boolean checkGameEnd() {
        if (checkWin('X')) {
            xScore++;
            showResult("Player X Wins!");
            return true;
        } else if (checkWin('O')) {
            oScore++;
            showResult("Player O Wins!");
            return true;
        } else if (isBoardFull()) {
            showResult("It's a Draw!");
            return true;
        }
        return false;
    }

    private boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (checkLine(player, buttons[i][0], buttons[i][1], buttons[i][2])) return true;
            if (checkLine(player, buttons[0][i], buttons[1][i], buttons[2][i])) return true;
        }
        return checkLine(player, buttons[0][0], buttons[1][1], buttons[2][2]) ||
                checkLine(player, buttons[0][2], buttons[1][1], buttons[2][0]);
    }

    private boolean checkLine(char player, JButton b1, JButton b2, JButton b3) {
        return b1.getText().equals(String.valueOf(player)) &&
                b2.getText().equals(String.valueOf(player)) &&
                b3.getText().equals(String.valueOf(player));
    }

    private boolean isBoardFull() {
        for (JButton[] row : buttons)
            for (JButton b : row)
                if (b.getText().equals("")) return false;
        return true;
    }

    private void showResult(String message) {
        gameOver = true;
        updateScore();
        JOptionPane.showMessageDialog(this, message);
        resetBoard();
    }

    private void updateScore() {
        scoreLabel.setText("X: " + xScore + "   O: " + oScore);
    }
    private void switchMode() {
        vsAI = modeBox.getSelectedIndex() == 0;
        resetBoard();
    }

    private void resetBoard() {
        for (JButton[] row : buttons)
            for (JButton b : row)
                b.setText("");

        gameOver = false;
        currentPlayer = 'X';
    }
}
