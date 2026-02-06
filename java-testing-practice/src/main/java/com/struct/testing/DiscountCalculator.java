package com.struct.testing;

public class DiscountCalculator {

    public int finalPrice(int originPrice, int discountRate) {
        if (originPrice < 0) {
            throw new IllegalArgumentException("originPrice must be >= 0");
        }
        if (discountRate < 0 || discountRate > 100) {
            throw new IllegalArgumentException("discountRate must be in [0, 100]");
        }
        return originPrice * (100 - discountRate) / 100;
    }
}
