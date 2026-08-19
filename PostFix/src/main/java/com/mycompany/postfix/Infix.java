package com.mycompany.postfix;

public class Infix {

    private String output = "";

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^") || s.equals("%");
    }

    private boolean closeparenThesis() {
        int count = 0;

        for (int i = 0; i < output.length(); i++) {
            char c = output.charAt(i);

            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
        }

        return count > 0;
    }

    public String Check(String value) {
        if (output.length() >= 50) {
            return output;
        }
        if (output.isEmpty()) {
            if (isOperator(value) || value.equals(")")) {
                return output;
            }
        } else {
            String last = String.valueOf(output.charAt(output.length() - 1));
            if (isOperator(value) && isOperator(last)) {
                return output;
            }
            if (value.equals(")") && last.equals("(")) {
                return output;
            }
            if (value.equals(")") && isOperator(last)) {
                return output;
            }
            if (last.equals(")") && (value.equals("(") || value.matches("[0-9]"))) {
                return output;
            }
            if (last.matches("[0-9]") && value.equals("(")) {
                return output;
            }
            if (value.equals(")") && !closeparenThesis()) {
                return output;
            }
            if (value.matches("[0-9]")) {
                if (output.equals("0")) {
                    output = value;
                    return output;
                }
                if (output.length() >= 2) {
                    String prev = String.valueOf(output.charAt(output.length() - 2));
                    if (last.equals("0") && (isOperator(prev) || prev.equals("("))) {
                        output = output.substring(0, output.length() - 1) + value;
                        return output;
                    }
                }
            }
        }
        output = output + value;
        return output;
    }

    public String deleteLast() {
        if (output.length() > 0) {
            output = output.substring(0, output.length() - 1);
        }
        return output;
    }

    public String getFormattedOutput() {
        StringBuilder result = new StringBuilder();
        StringBuilder currentNumber = new StringBuilder();

        for (int i = 0; i < output.length(); i++) {
            char c = output.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber.append(c);
            } else {

                if (currentNumber.length() > 0) {
                    result.append(addCommas(currentNumber.toString()));
                    currentNumber.setLength(0);
                }
                result.append(c);
            }
        }

        if (currentNumber.length() > 0) {
            result.append(addCommas(currentNumber.toString()));
        }

        return result.toString();
    }

    private String addCommas(String numStr) {
        StringBuilder formatted = new StringBuilder();
        int count = 0;

        for (int i = numStr.length() - 1; i >= 0; i--) {
            if (count == 3) {
                formatted.insert(0, ",");
                count = 0;
            }
            formatted.insert(0, numStr.charAt(i));
            count++;
        }
        return formatted.toString();
    }

    public String getOutput() {
        return output;
    }
}
