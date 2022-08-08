import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = null;
    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    void shouldReturnSumOfTwoNumbers2And5As7(){

        int sum = calculator.add(2,5);
        Assertions.assertEquals(7, sum);
    }

    @Test
    void shouldReturnDivisionofTwoNumbers6and3As2(){

        double division = calculator.divide(6,2);
        Assertions.assertEquals(3.0,division);
    }

    @Test
    void shoudlReturnArithmeticExceptionWhenDividedby0(){

        ArithmeticException arithmeticException = Assertions.assertThrows(ArithmeticException.class, ()->calculator.divide(10,0));
        Assertions.assertEquals("Can't divide by zero", arithmeticException.getMessage());
    }
}
