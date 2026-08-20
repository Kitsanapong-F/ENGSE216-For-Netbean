package com.mycompany.postfix;

public class Process {

    private StringBuilder log = new StringBuilder();

    public void startNewLog() {
        log.setLength(0);
        log.append("=========================================================================\n");
        log.append(String.format("%-10s | %-35s | %s\n", "Input", "Postfix Output", "Stack"));
        log.append("=========================================================================\n");
    }

    public void addRow(String input, String postfix, String stack) {
        log.append(String.format("%-10s | %-35s | %s\n", input, postfix, stack));
    }

    public void finishLog() {
        log.append("=========================================================================\n");
    }

    public String getLogData() {
        return log.toString();
    }
}
