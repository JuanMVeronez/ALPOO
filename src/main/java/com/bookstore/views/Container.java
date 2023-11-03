package com.bookstore.views;

import javax.swing.JFrame;

public class Container {
    public void open() {
        JFrame jFrame = new JFrame("Bookstore");
        jFrame.setSize(700, 500);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jFrame.setVisible(true);
    }
}
