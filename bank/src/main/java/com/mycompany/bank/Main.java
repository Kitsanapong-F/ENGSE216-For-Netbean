package com.mycompany.bank;

public class Main {

    public static void main(String[] args) {
        System.setProperty("awt.useSystemAAFontSettings", "off");
        java.awt.EventQueue.invokeLater(() -> {
            Ui myWindow = new Ui();
            myWindow.setVisible(true);
        });
    }
}
