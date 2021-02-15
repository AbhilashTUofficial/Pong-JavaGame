package com.Game;

import javax.swing.*;

public class Main {

    public static void main(String[] args){
        System.out.println("pong game");

        GameLogic gamePlay=new GameLogic();
        JFrame obj = new JFrame();
        obj.setBounds(0, 0, 600, 600);
        obj.setTitle("Pong game");
        obj.setVisible(true);
        obj.setResizable(false);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gamePlay);


    }
}
