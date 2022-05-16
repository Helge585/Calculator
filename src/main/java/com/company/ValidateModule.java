package com.company;

import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateModule {
    static public void validateOperationsOrder(String infixExp) throws infixExpErrorException {

        if (infixExp.isEmpty()) {
            throw new infixExpErrorException("Пустая строка");
        }
        Matcher matcher = Pattern.compile("[^.()+\\-*/0-9]").matcher(infixExp);
        if (matcher.find()) {
            throw new infixExpErrorException("Введены недопустимые символ(ы): " +
                    infixExp.substring(matcher.start(), matcher.end()));
        }
        matcher = Pattern.compile("\\.\\d+\\.").matcher(infixExp);
        if (matcher.find()) {
            throw new infixExpErrorException("Неверный формат числа: " +
                    infixExp.substring(matcher.start(), matcher.end()));
        }
        matcher = Pattern.compile("\\)\\(").matcher(infixExp);
        if (matcher.find()) {
            throw new infixExpErrorException("Выражения в скобках не соединены операцией: " +
                    infixExp.substring(matcher.start(), matcher.end()));
        }
        matcher = Pattern.compile("^[+*/).]").matcher(infixExp);
        if (matcher.find()) {
            throw new infixExpErrorException("Недопустимый символ в начале выражения: " +
                    infixExp.substring(matcher.start(), matcher.end()));
        }
        matcher = Pattern.compile("[+\\-*/(.]$").matcher(infixExp);
        if (matcher.find()) {
            throw new infixExpErrorException("Недопустимый символ в конце выражения: " +
                    infixExp.substring(matcher.start(), matcher.end()));
        }
        matcher = Pattern.compile("[.+\\-*/][.)+\\-*/]|[(][+*/.]").matcher(infixExp);
        if (matcher.find()) {
            throw new infixExpErrorException("Неверный формат записи операций: " +
                    infixExp.substring(matcher.start(), matcher.end()));
        }
    }

    static public void validateParenthesesOrder(String infixExp) throws infixExpErrorException {
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        if (infixExp.isEmpty()) {
            throw new infixExpErrorException("Пустая строка");
        }
        for (int i = 0; i < infixExp.length(); ++i) {
            char ch = infixExp.charAt(i);
            if (ch == '(') {
                stack.addLast(ch);
            } else if (ch == ')') {
                if (stack.pollLast() == null) {
                    throw new infixExpErrorException("Неверный формат скобок");
                }
            }
        }
        if (stack.pollLast() != null) {
            throw new infixExpErrorException("Неверный формат скобок");
        }
    }
}
