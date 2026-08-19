package com.mycompany.postfix;
public class Main {

    public static void main(String[] args) {
        System.setProperty("awt.useSystemAAFontSettings", "off");
        java.awt.EventQueue.invokeLater(() -> {
            Ui udUi = new Ui();
            udUi.setVisible(true);
        });
    }
}