package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DiapFunctionsTest  {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = DiapFunctions.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenQudraticalFunctionThenQudraticalResults() {
        List<Double> result = DiapFunctions.diapason(5, 8, x -> 2 * x * x + 1);
        List<Double> expected = Arrays.asList(51D, 73D, 99D);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenQRTFunctionThenQRTResults() {
        List<Double> result = DiapFunctions.diapason(5, 8, x -> Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(33D, 65D, 129D);
        assertThat(result).isEqualTo(expected);
    }
}