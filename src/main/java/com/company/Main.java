package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражения состоящее из следуюих элементов: 0-9, '.', '+', '-', '*', '/'. '(', ')'");
        System.out.println("'q' - выход");
        while (true) {
            String infixExp = scanner.nextLine().replace(" ", "");
            if (infixExp.equals("q")) {
                break;
            }
            try {
                ValidateModule.validateOperationsOrder(infixExp);
                ValidateModule.validateParenthesesOrder(infixExp);

                String postfixExp = ParserModule.getPostfixExp(infixExp);
                System.out.println(MathModule.calculatePostfixExp(postfixExp));
            } catch (infixExpErrorException e) {
                System.out.println(e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Недопустимая операция: деление на ноль");
            }
        }
    }
}
