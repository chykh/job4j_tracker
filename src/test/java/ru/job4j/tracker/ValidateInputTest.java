package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"one", "1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"4"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(4);
    }

    @Test
    public void whenValidInputs() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"1", "2", "2"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu 1:");
        assertThat(selected).isEqualTo(1);
        int selected2 = input.askInt("Enter menu 2:");
        assertThat(selected2).isEqualTo(2);
        int selected3 = input.askInt("Enter menu 3:");
        assertThat(selected3).isEqualTo(2);
    }

    @Test
    public void whenMinusInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[] {"-5"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-5);
    }
}