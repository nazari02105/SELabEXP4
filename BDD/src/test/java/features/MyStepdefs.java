package features;

import calculator.Calculator;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs {
    private Calculator calculator;
    private int value1;
    private int value2;
    private double value3;
    private int resultInt;
    private double resultDouble;

    @Before
    public void before() {
        calculator = new Calculator();
    }

    @Given("^Two input values, (-?\\d+) and (-?\\d+)$")
    public void twoInputValuesAnd(int arg0, int arg1) {
        value1 = arg0;
        value2 = arg1;
    }

    @When("^I add the two values$")
    public void iAddTheTwoValues() {
        resultInt = calculator.add(value1, value2);
        System.out.print(resultInt);
    }

    @Then("^I expect the result (\\d+)$")
    public void iExpectTheResult(int arg0) {
        Assert.assertEquals(arg0, resultInt);
    }

    @When("^I divide the two values$")
    public void iDivideTheTwoValues() {
        resultDouble = calculator.divide(value1, value2);
        System.out.print(resultDouble);
    }

    @Then("^The result should be (\\d+(?:\\.\\d+)?)$")
    public void theResultShouldBe(double arg0) {
        Assert.assertEquals(arg0, resultDouble, 0.001);
    }

    @Given("^One input value, (\\d+(?:\\.\\d+)?)$")
    public void oneInputValue(int arg0) {
        value3 = arg0;
    }

    @When("^I calculate the square root of the number$")
    public void iCalculateTheSquareRootOfTheNumber() {
        resultDouble = calculator.sqrt(value3);
        System.out.print(resultDouble);
    }

    @When("^I calculate the square root of the division of two numbers$")
    public void iCalculateTheSquareRootOfTheDivisionOfTwoNumbers() {
        resultDouble = calculator.sqrt_division(value1, value2);
        System.out.print(resultDouble);
    }
}
