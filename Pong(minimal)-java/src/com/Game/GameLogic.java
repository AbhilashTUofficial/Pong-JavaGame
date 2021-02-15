package com.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameLogic extends JPanel implements ActionListener, KeyListener {
    private int delay = 8;
    private Timer time;
    private int screenWidth = 600;
    private int screenHeight = 600;
    private int paddleWidth = 20;
    private int paddleHeight = 100;
    private int paddleAX = 20;
    private int paddleBX = 540;
    private int paddleAY = 230;
    private int paddleBY = 230;
    private int ballX = 300;
    private int ballY = 300;
    private int balldX = 2;
    private int balldY = 2;
    private boolean play = false;
    private int boarderHeight = 10;
    private int boarderWidth = screenWidth;
    private int ballSize = 20;
    private int boarderTopX = 0;
    private int boarderBottomX = 0;
    private int boarderTopY = 0;
    private int boarderBottomY = 550;
    private int scoreA;
    private int scoreB;
    private boolean startPage = true;
    private boolean playPage = false;
    private boolean gameOver = false;


    public GameLogic() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(delay, this);
        time.start();


    }

    public void paint(Graphics g) {

        //Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, screenWidth, screenHeight);


        //Boarder
        //top
        g.setColor(Color.ORANGE);
        g.fillRect(boarderTopX, boarderTopY, boarderWidth, boarderHeight);
        //bottom
        g.setColor(Color.ORANGE);
        g.fillRect(boarderBottomX, boarderBottomY, boarderWidth, boarderHeight);

        //Paddle A
        g.setColor(Color.GREEN);
        g.fillRect(paddleAX, paddleAY, paddleWidth, paddleHeight);

        //Paddle B
        g.setColor(Color.RED);
        g.fillRect(paddleBX, paddleBY, paddleWidth, paddleHeight);

        //Ball
        g.setColor(Color.white);
        g.fillOval(ballX, ballY, ballSize, ballSize);

        //score board
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("" + scoreB, 550, 30);
        g.drawString("" + scoreA, 30, 30);

        g.dispose();
        time.start();
        repaint();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Collision with the paddle
        if (new Rectangle(ballX, ballY, ballSize, ballSize).intersects(new Rectangle(paddleAX, paddleAY, paddleWidth, paddleHeight))) {
            scoreA++;
            balldX = balldX * -1;
        }
        if (new Rectangle(ballX, ballY, ballSize, ballSize).intersects(new Rectangle(paddleBX, paddleBY, paddleWidth, paddleHeight))) {
            scoreB++;
            balldX = balldX * -1;
        }

        //Collision with the boarder
        if (new Rectangle(ballX, ballY, ballSize, ballSize).intersects(new Rectangle(boarderTopX, boarderTopY, boarderWidth, boarderHeight))) {
            balldY = balldY * -1;
        }
        if (new Rectangle(ballX, ballY, ballSize, ballSize).intersects(new Rectangle(boarderBottomX, boarderBottomY, boarderWidth, boarderHeight))) {
            balldY = balldY * -1;
        }


        if (paddleAY < 10) {
            paddleAY = 10;
        }
        if (paddleBY < 10) {
            paddleBY = 10;
        }
        if (paddleAY > 450) {
            paddleAY = 450;
        }
        if (paddleBY > 450) {
            paddleBY = 450;
        }
        if (play) {
            ballX = ballX + balldX;
            ballY = ballY + balldY;
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


        if (e.getKeyCode() == KeyEvent.VK_L) {
            play = true;
            paddleBY = paddleBY + 20;
        }
        if (e.getKeyCode() == KeyEvent.VK_O) {
            play = true;
            paddleBY = paddleBY - 20;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            play = true;
            paddleAY = paddleAY + 20;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            play = true;
            paddleAY = paddleAY - 20;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
