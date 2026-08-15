package com.mycompany.postfix;

public class PostFix {

    private Stack St = new Stack(5);
    private String output = "";

    public String Check(String value) {
        output = output + value;
        return output;
    }

    public String deleteLast() {
        if (output.length() > 0) {
            output = output.substring(0, output.length() - 1);
        }
        return output;
    }
}
