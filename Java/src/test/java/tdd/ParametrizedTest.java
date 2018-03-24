package tdd;

import junitparams.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.*;
import org.junit.runner.*;

@RunWith(JUnitParamsRunner.class)
public class ParametrizedTest {

    @Test
    @Parameters({
            "2|2|4",
            "1|1|2",
            "1|9|10"
    })
    public void parametrizedAddTest(int p1, int p2, int p3) {
        System.out.println("p1 = [" + p1 + "], p2 = [" + p2 + "], p3 = [" + p3 + "]");
        int sum = Calculator.add(p1, p2);
        assertThat(sum).isEqualTo(p3);
    }

    @Test
    @FileParameters("src/test/resources/test.csv")
    public void parametrizedAddTestFromFile(int p1, int p2, int p3) {
        System.out.println("p1 = [" + p1 + "], p2 = [" + p2 + "], p3 = [" + p3 + "]");
        int sum = Calculator.add(p1, p2);
        assertThat(sum).isEqualTo(p3);
    }

    @Test
    @Parameters({"10,2,5", "20,5,4"})
    public void parametrizedDivideTest(int p1, int p2, int p3) {
        int ratio = Calculator.divide(p1, p2);
        assertThat(ratio).isEqualTo(p3);
    }

    @Test
    public void divideByZeroTest() {
        assertThatThrownBy(() -> { Calculator.divide(10, 0); }).hasMessage("/ by zero");
    }

}
