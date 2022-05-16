package com.company;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MathModuleTest {

    @ParameterizedTest
    @Tag("PositiveTest")
    @MethodSource("com.company.Providers#mathModuleCalculatePostfixTestProvider")
    @DisplayName("Тест метода calculatePostfixExp(String postfixExr) арифмет. операции")
    public void testCalculatePostfix(String postfixExp, double expected) {
        assertThat(expected, equalTo(MathModule.calculatePostfixExp(postfixExp)));
    }

    @Tag("NegativeTest")
    @Test
    @DisplayName("Тест метода calculatePostfixExp(String postfixExr) деление на ноль")
    public void testCalculatePostfixDivByZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            MathModule.calculatePostfixExp("2 0 /");
        });
    }
}