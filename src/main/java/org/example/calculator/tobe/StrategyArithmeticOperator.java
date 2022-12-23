package org.example.calculator.tobe;

import org.example.calculator.domain.PositiveNumber;

public interface StrategyArithmeticOperator {
    boolean supports(String operator);
    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
