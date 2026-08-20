package com.mycompany.postfix;

public class PostFix {

    private Stack St = new Stack(50);
    private Process log = new Process();

    private int stackPriority(char operator) {
        if (operator == '^') {
            return 3;
        }
        if (operator == '*' || operator == '/' || operator == '%') {
            return 2;
        }
        if (operator == '+' || operator == '-') {
            return 1;
        }
        if (operator == '(') {
            return 0;
        }
        return -1;
    }

    private int inputPriority(char operator) {
        if (operator == '^' || operator == '(') {
            return 4;
        }
        if (operator == '*' || operator == '/' || operator == '%') {
            return 2;
        }
        if (operator == '+' || operator == '-') {
            return 1;
        }
        return -1;
    }

    public String getProcessLog() {
        return log.getLogData();
    }

    public String toPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        StringBuilder number = new StringBuilder();
        StringBuilder visualStack = new StringBuilder();

        log.startNewLog();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                if (number.length() > 0) {
                    postfix.append(number.toString()).append(" ");
                    log.addRow(number.toString(), postfix.toString(), visualStack.toString());
                    number.setLength(0);
                }

                if (c == '(') {
                    St.push(c);
                    visualStack.append(c);
                    log.addRow(String.valueOf(c), postfix.toString(), visualStack.toString());
                } else if (c == ')') {
                    log.addRow(String.valueOf(c), postfix.toString() + " (Start Pop)", visualStack.toString());
                    while (!St.isEmpty() && (char) St.top() != '(') {
                        char popOp = (char) St.pop();
                        postfix.append(popOp).append(" ");
                        visualStack.deleteCharAt(visualStack.length() - 1);
                        log.addRow(" Pop " + popOp, postfix.toString(), visualStack.toString());
                    }
                    if (!St.isEmpty()) {
                        St.pop();
                        visualStack.deleteCharAt(visualStack.length() - 1);
                        log.addRow(" Pop (", postfix.toString(), visualStack.toString());
                    }
                } else {
                    while (!St.isEmpty() && (char) St.top() != '(' && inputPriority(c) <= stackPriority((char) St.top())) {
                        char popOp = (char) St.pop();
                        postfix.append(popOp).append(" ");
                        visualStack.deleteCharAt(visualStack.length() - 1);
                        log.addRow(" Pop " + popOp, postfix.toString(), visualStack.toString());
                    }
                    St.push(c);
                    visualStack.append(c);
                    log.addRow(String.valueOf(c), postfix.toString(), visualStack.toString());
                }
            }
        }

        if (number.length() > 0) {
            postfix.append(number.toString()).append(" ");
            log.addRow(number.toString(), postfix.toString(), visualStack.toString());
        }

        while (!St.isEmpty()) {
            char leftover = (char) St.pop();
            visualStack.deleteCharAt(visualStack.length() - 1);
            if (leftover != '(' && leftover != ')') {
                postfix.append(leftover).append(" ");
                log.addRow(" Pop " + leftover, postfix.toString(), visualStack.toString());
            }
        }

        log.finishLog();

        return postfix.toString().trim();
    }
}
