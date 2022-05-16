package com.company;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ValidateModuleTest {

    @Tag("NegativeTest")
    @ParameterizedTest
    @MethodSource("com.company.Providers#validateModuleValidateOperationsOrderIncorrectProvider")
    @DisplayName("Тест метода ValidateOperationsOrder incorrect operations order")
    public void testValidateOperationsOrderIncorrect(String infixExp) {
        assertThrows(com.company.infixExpErrorException.class, () -> {
            ValidateModule.validateOperationsOrder(infixExp);
        });
    }

    @Tag("NegativeTest")
    @ParameterizedTest
    @MethodSource("com.company.Providers#validateModuleValidateParenthesesOrderIncorrectProvider")
    @DisplayName("Тест метода ValidateOperationsOrder incorrect parentheses order")
    public void testValidateParenthesesOrderIncorrect(String infixExp) {
        assertThrows(com.company.infixExpErrorException.class, () -> {
            ValidateModule.validateParenthesesOrder(infixExp);
        });
    }

    @Tag("PositiveTest")
    @ParameterizedTest
    @MethodSource("com.company.Providers#validateModuleValidateOperationsOrderCorrectProvider")
    @DisplayName("Тест метода ValidateOperationsOrder correct operations order")
    public void testValidateOperationsOrderCorrect(String infixExp) {
        try {
            ValidateModule.validateOperationsOrder(infixExp);
        } catch (infixExpErrorException e) {
            fail(e);
        }
    }

    @Tag("PositiveTest")
    @ParameterizedTest
    @MethodSource("com.company.Providers#validateModuleValidateParenthesesOrderCorrectProvider")
    @DisplayName("Тест метода ValidateOperationsOrder correct parentheses order")
    public void testValidateParenthesesOrderCorrect(String infixExp) {
        try {
            ValidateModule.validateParenthesesOrder(infixExp);
        } catch (infixExpErrorException e) {
            fail(e);
        }
    }
}