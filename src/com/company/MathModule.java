package com.company;

import java.util.ArrayDeque;
import java.util.HashMap;

public class MathModule {
    static private HashMap<Character, Integer> operationPriority = new HashMap<Character, Integer>();
    static {
        //operationPriority.put(')', 0);
        operationPriority.put('(', 0);
        operationPriority.put('+', 1);
        operationPriority.put('-', 1);
        operationPriority.put('*', 2);
        operationPriority.put('/', 2);
        operationPriority.put('~', 3);
    }
    static public Double calculatePostfixExp(String postfixExr) {
        ArrayDeque<Double> stack = new ArrayDeque<Double>();

        for (String item : postfixExr.split(" ")) {
            if (MathModule.isOperation(item.charAt(0))) {
                double calculateResult = 0;
                double secondOperand;
                double firstOperand;
                switch (MathModule.getOperandsCount(item.charAt(0))) {
                    case 1:
                        firstOperand = stack.pollLast();
                        calculateResult = MathModule.calculateOperation(
                                item.charAt(0), firstOperand);
                        break;
                    case 2:
                        secondOperand = stack.pollLast();
                        firstOperand = stack.pollLast();
                        calculateResult = MathModule.calculateOperation(
                                item.charAt(0), firstOperand, secondOperand);
                }
                stack.addLast(calculateResult);
            } else if (Character.isDigit(item.charAt(0))) {
                stack.addLast(Double.valueOf(item));
            }
        }
        return stack.pollLast();
    }

    static private double calculateOperation(char op, double first, double second) {
        switch (op) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                if (second == 0) {
                    throw new ArithmeticException();
                }
                return first / second;
            default:
                throw new IllegalArgumentException();
        }
    }
    static private double calculateOperation(char op, double first) {
        switch (op) {
            case '~':
                return -first;
            default:
                throw new IllegalArgumentException();
        }
    }

    static public boolean isOperation(char op) {
        return op != '(' && operationPriority.containsKey(op);
    }

    static public int getPriority(char op) {
        if (operationPriority.containsKey(op)) {
            return operationPriority.get(op);
        } else {
            throw new IllegalArgumentException();
        }
    }

    static public int getOperandsCount(char op) {
        switch (op) {
            case '+':
            case '-':
            case '*':
            case '/':
                return 2;
            case '~':
                return 1;
            default:
                throw new IllegalArgumentException();
        }
    }
}
