package com.github.tdotdm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IntegerHelpFactoryTest {
    @Test
    public void constructor_ShouldThrowException_WhenGivenNullValue() {
        //then
        assertThatThrownBy(() -> new IntegerHelp(null))
                .isInstanceOf(HelpException.class);
    }

    @Test
    public void byCheckingNotExceedingBoundary_ShouldThrowException_WhenLowerIsGreaterThanUpper() {
        //given
        final IntegerHelp target = new IntegerHelp(5);

        //then
        assertThatThrownBy(() -> target.byCheckingNotExceedingBoundary(2, 1))
                .isInstanceOf(HelpException.class);
    }

    @Test
    public void byCheckingNotExceedingBoundary_ShouldReturnTrue_WhenValueIsInBoundary() {
        //given
        final IntegerHelp target = new IntegerHelp(5);

        //when
        final boolean result = target.byCheckingNotExceedingBoundary(1, 10);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void byCheckingNotExceedingBoundary_ShouldReturnFalse_WhenValueIsOutBoundary() {
        //given
        final IntegerHelp target = new IntegerHelp(-5);

        //when
        final boolean result = target.byCheckingNotExceedingBoundary(1, 10);

        //then
        assertThat(result).isFalse();
    }
}