package com.company;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Providers {

    public static Stream<Arguments> mathModuleCalculatePostfixTestProvider() {
        return Stream.of(
                arguments("4 6 +", 10),
                arguments("5 6 -", -1),
                arguments("10 8 *", 80),
                arguments("40 4 /", 10),
                arguments("7 ~", -7)
        );
    }

    public static Stream<Arguments> validateModuleValidateParenthesesOrderIncorrectProvider() {
        return Stream.of(
                arguments("(6/9))"),
                arguments("((7*9)"),
                arguments("((7+10)))*(7-9)")
        );
    }

    public static Stream<Arguments> validateModuleValidateOperationsOrderIncorrectProvider() {
        return Stream.of(
                arguments(""),
                arguments("a+x"),
                arguments("5.6.6"),
                arguments("(7*9)(8+9)"),
                arguments("*9+9"),
                arguments("7+9+"),
                arguments("8*9("),
                arguments("8++9")
        );
    }

    public static Stream<Arguments> validateModuleValidateParenthesesOrderCorrectProvider() {
        return Stream.of(
                arguments("(6/9)"),
                arguments("((7*9))"),
                arguments("((7+10))*(7-9)")
        );
    }

    public static Stream<Arguments> validateModuleValidateOperationsOrderCorrectProvider() {
        return Stream.of(
                arguments("5+5"),
                arguments("5.6"),
                arguments("(7*9)+(8+9)"),
                arguments("-9+9"),
                arguments("7+9+9"),
                arguments("(8*9)"),
                arguments("8+(-9)")
        );
    }

    public static Stream<Arguments> parserModuleGetPostfixExpProvider() {
        return Stream.of(
                arguments("5+5", "5 5 + "),
                arguments("7*(9-8)", "7 9 8 - * ")
        );
    }
}
