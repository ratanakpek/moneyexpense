package com.example.tdd;



import static junit.framework.TestCase.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PositiveNumberValidatorTest {

    PositiveNumberValidator SUT;

    @Before
    public void setUp() {
        SUT = new PositiveNumberValidator();
    }

    @Test
    public void testNegativeOne(){
        boolean result = SUT.isPositive(-1);
        assertEquals(false, result);
    }

    @Test
    public void testZero(){
        boolean result = SUT.isPositive(0);
        assertEquals(false, result);
    }

    @Test
    public void testOne(){
        boolean result = SUT.isPositive(1);
        assertEquals(true, result);
    }
}