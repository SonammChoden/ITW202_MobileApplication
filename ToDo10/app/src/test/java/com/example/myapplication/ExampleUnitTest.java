package com.example.myapplication;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

/*SmallTest
 * Example local unit test, which will execute on the development machine (host).
 *org
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class  ExampleUnitTest {
    private Calculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    @Test
    public void addTwoNumber(){
        double result = mCalculator.add(1d, 2d);
        assertThat(result, is(equalTo(3d)));
    }
    @Test
    public void addTwoNumberForNegatives(){
        double result = mCalculator.add(-2d, 2d);
        assertThat(result, is(equalTo(0d)));
    }
    @Test
    public void addTwoNumberFloats(){
        double result = mCalculator.add(1.111f, 1.111f);
        assertThat(result, is(closeTo(2.222d, 0.01)));
    }
    @Test
    public void subTwoNumbers(){
        double result = mCalculator.sub(2d, 1d);
        assertThat(result, is(equalTo(1d)));
    }
    @Test
    public void subWorksWithNegativeResult(){
        double result = mCalculator.sub(1d, 2d);
        assertThat(result, is(equalTo(-1d)));
    }
    @Test
    public void subNegative(){
        double result = mCalculator.sub(-3d, 10d);
        assertThat(result, is(equalTo(-13d)));
    }
    @Test
    public void subTwoNegativeValues(){
        double result = mCalculator.sub(-2d, -3d);
        assertThat(result, is(equalTo(1d)));
    }
    @Test
    public void mulTwoNumbers(){
        double result = mCalculator.mul(1d, 2d);
        assertThat(result, is(equalTo(2d)));
    }
    @Test
    public void mulTwoNumbersZero(){
        double result = mCalculator.mul(0d, 2d);
        assertThat(result, is(equalTo(0d)));
    }
    @Test
    public void divTwoNumbersExact(){
        double result = mCalculator.div(10d, 5d);
        assertThat(result, is(equalTo(2d)));
    }
    @Test
    public void divTwoNumbersWithNotExact(){
        double result = mCalculator.div(10d, 4d);
        assertThat(result, is(closeTo(2,0.5d)));
    }
    @Test
    public void divTwoNumbersZero(){
        double result = mCalculator.div(2d, 0d);
        assertThat(result, is(equalTo(Double.POSITIVE_INFINITY)));
    }
}