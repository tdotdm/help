package com.github.tdotdm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BooleanHelpTest {
    @Test
    public void constructor_ShouldThrowException_WhenGivenNullValue() {
        //then
        assertThatThrownBy(() -> new BooleanHelp(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void byReturning_ShouldReturnTrueValue_WhenValueIsTrue() {
        //given
        final String trueValue = "test_true_value";
        final String falseValue = "test_false_value";
        final BooleanHelp target = new BooleanHelp(Boolean.TRUE);

        //when
        final String result = target.byReturning(trueValue, falseValue);

        //then
        assertThat(result).isEqualTo(trueValue);
    }

    @Test
    public void byReturning_ShouldThrowException_WhenTrueValueIsNull() {
        //given
        final String trueValue = null;
        final String falseValue = "test_false_value";
        final BooleanHelp target = new BooleanHelp(Boolean.TRUE);

        //then
        assertThatThrownBy(() -> target.byReturning(trueValue, falseValue))
                .isInstanceOf(HelpException.class);
    }

    @Test
    public void byReturning_ShouldReturnFalseValue_WhenValueIsFalse() {
        //given
        final String trueValue = "test_true_value";
        final String falseValue = "test_false_value";
        final BooleanHelp target = new BooleanHelp(Boolean.FALSE);

        //when
        final String result = target.byReturning(trueValue, falseValue);

        //then
        assertThat(result).isEqualTo(falseValue);
    }

    @Test
    public void byReturning_ShouldThrowException_WhenFalseValueIsNull() {
        //given
        final String trueValue = "test_true_value";
        final String falseValue = null;
        final BooleanHelp target = new BooleanHelp(Boolean.FALSE);

        //then
        assertThatThrownBy(() -> target.byReturning(trueValue, falseValue))
                .isInstanceOf(HelpException.class);
    }
}