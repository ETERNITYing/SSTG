package main.java;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException,InstantiationException,IllegalAccessException,UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new main.java.display.mainFrame();
    }
}