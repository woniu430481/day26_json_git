package junit;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

//    public static void test1(){
//        Calculator cal = new Calculator();
//        int sum = cal.add(3, 4);
//        System.out.println("sum:"+sum);
//
//    }
//
//    public static void test2(){
//        Calculator cal = new Calculator();
//        int sub = cal.sub(5, 6);
//        System.out.println("sub:"+sub);
//    }
//
//    public static void main(String[] args) {
//        test2();
//
//
//    }



    /*

    java.lang.AssertionError:
    Expected :6
    Actual   :7


     */
    @Test
    public void test1(){
        Calculator cal = new Calculator();
        int sum = cal.add(3, 4);
        //System.out.println("sum:"+sum);

        //断言：就是说拿期望的值和实际的值比较
        Assert.assertEquals(6,sum);


    }




}
