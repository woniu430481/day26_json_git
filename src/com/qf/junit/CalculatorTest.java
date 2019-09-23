package com.qf.junit;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {


    @Test
    public void testAdd(){
        Calculator cal  =new Calculator();
        int result = cal.add(3, 2);
        Assert.assertEquals(5,result);
    }
}
