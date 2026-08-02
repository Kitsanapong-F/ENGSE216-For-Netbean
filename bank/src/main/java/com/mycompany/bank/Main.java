package com.mycompany.bank;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            Ui myWindow = new Ui();
            myWindow.setVisible(true);
        });
    }
}
