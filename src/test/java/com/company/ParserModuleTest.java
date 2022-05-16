package com.company;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ParserModuleTest {


    @Tag("PositiveTest")
    @ParameterizedTest
    @MethodSource("com.company.Providers#parserModuleGetPostfixExpProvider")
    @DisplayName("Тест метода getPostfixExp")
    public void testGetPostfixExp(String infixExp, String expected) {
        assertThat(expected, equalTo(ParserModule.getPostfixExp(infixExp)));
    }

}