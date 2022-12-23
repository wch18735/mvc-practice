package org.example.calculator.domain;

import java.util.Arrays;

public enum EnumArithmeticOperator {
    ADDITION("+"){
        @Override
        public int arithmeticCalculate(PositiveNumber operand1, PositiveNumber operand2) {
            return operand1.toInt() + operand2.toInt();
        }
    }, SUBTRACTION("-"){
        @Override
        public int arithmeticCalculate(PositiveNumber operand1, PositiveNumber operand2) {
            return operand1.toInt() - operand2.toInt();
        }
    }, MULTIPLICATION("*"){
        @Override
        public int arithmeticCalculate(PositiveNumber operand1, PositiveNumber operand2) {
            return operand1.toInt() * operand2.toInt();
        }
    }, DIVISION("/"){
        @Override
        public int arithmeticCalculate(PositiveNumber operand1, PositiveNumber operand2) {
            return operand1.toInt() / operand2.toInt();
        }
    };

    private final String _operator;

    EnumArithmeticOperator(String operator) {
        this._operator = operator;
    }

    public abstract int arithmeticCalculate(final PositiveNumber operand1, final PositiveNumber operand2);

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2){
        EnumArithmeticOperator arithmeticOperator = Arrays.stream(values())
                .filter(v -> v._operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다"));

        return arithmeticOperator.arithmeticCalculate(operand1, operand2);
    }
}
