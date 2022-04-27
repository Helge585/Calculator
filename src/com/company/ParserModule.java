package com.company;

import java.util.ArrayDeque;

public class ParserModule {
    static public String getPostfixExp(String infixExp) {
        String postfixExp = "";
        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < infixExp.length(); ) {
            char currentSymbol = infixExp.charAt(i);
            if (currentSymbol == '(') {
                ++i;
                stack.addLast(currentSymbol);
            } else if (Character.isDigit(currentSymbol)) {
                String nextNumber = getNextNumber(infixExp, i);
                i += nextNumber.length();
                postfixExp += nextNumber + " ";
            } else if (currentSymbol == ')') {
                Character item = stack.pollLast();
                while (item != null && item != '(') {
                    postfixExp += item + " ";
                    item = stack.pollLast();
                }
                ++i;
            } else if (MathModule.isOperation(currentSymbol)) {
                if (currentSymbol == '-' && (i == 0 || infixExp.charAt(i - 1) == '(')) {
                    currentSymbol = '~';
                }
                Character op = stack.peekLast();
                while (op != null && MathModule.getPriority(op) >= MathModule.getPriority(currentSymbol)) {
                    postfixExp += stack.pollLast() + " ";
                    op = stack.peekLast();
                }
                stack.addLast(currentSymbol);
                ++i;
            }
        }
        Character op = stack.pollLast();
        while (op != null) {
            postfixExp += op + " ";
            op = stack.pollLast();
        }
        return postfixExp;
    }

    static private String getNextNumber(String inputStr, int i) {
        String resultNumber = "";
        boolean isAfterPoint = false;
        for ( ; i < inputStr.length(); ++i) {
            char buf = inputStr.charAt(i);
            if (Character.isDigit(buf)) {
                resultNumber += buf;
            } else if (buf == '.' && !isAfterPoint) {
                resultNumber += buf;
                isAfterPoint = true;
            } else {
                break;
            }
        }
        return resultNumber;
    }
}
