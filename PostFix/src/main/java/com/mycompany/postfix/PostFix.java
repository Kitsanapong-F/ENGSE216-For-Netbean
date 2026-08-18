package com.mycompany.postfix;

public class PostFix {

    private Stack St = new Stack(50);

    private int temp = -1;

    private int priority(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/' || operator == '%') {
            return 2;
        } else if (operator == '^') {
            return 3;
        } else if (operator == '(' || operator == ')') {
            return 0;
        }
        return -1;
    }

    public String toPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                if (number.length() > 0) {
                    postfix.append(number.toString()).append(" ");
                    number.setLength(0);
                }

                if (c == '(') {
                    St.push(c);
                } else if (c == ')') {
                    while (!St.isEmpty() && (char) St.top() != '(') {
                        postfix.append((char) St.pop()).append(" ");
                    }
                    if (!St.isEmpty()) {
                        St.pop();
                    }
                } else {
                    while (!St.isEmpty() && (char) St.top() != '(' && priority((char) St.top()) >= priority(c)) {
                        postfix.append((char) St.pop()).append(" ");
                    }
                    St.push(c);
                }
            }
        }

        if (number.length() > 0) {
            postfix.append(number.toString()).append(" ");
        }
        while (!St.isEmpty()) {
            postfix.append((char) St.pop()).append(" ");
        }

        return postfix.toString().trim();
    }
}
