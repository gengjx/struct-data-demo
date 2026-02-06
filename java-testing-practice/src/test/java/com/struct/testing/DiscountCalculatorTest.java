package com.struct.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiscountCalculatorTest {

    private final DiscountCalculator calculator = new DiscountCalculator();

    @Test
    void finalPrice_shouldApplyDiscount() {
        int price = calculator.finalPrice(100, 20);
        Assertions.assertEquals(80, price);
    }

    @Test
    void finalPrice_shouldThrowWhenRateInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.finalPrice(100, 101));
    }
}
