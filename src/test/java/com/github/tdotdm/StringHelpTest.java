package com.github.tdotdm;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringHelpTest {

    @Test
    public void constructor_ShouldThrowException_WhenGivenNullValue() {
        //then
        assertThatThrownBy(() -> new StringHelp(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void byRemovingWhitespace_ShouldRemoveAllWhitespace() {
        //given
        final String value = "Monday Tuesday Wednesday Thursday Friday Saturday Sunday !";
        final StringHelp target = new StringHelp(value);

        //when
        final String result = target.byRemovingWhitespace();

        //then
        assertThat(result).isEqualTo("MondayTuesdayWednesdayThursdayFridaySaturdaySunday!");
    }

    @Test
    public void byConvertingToInteger_ShouldReturnEmptyOptional_WhenGivenInvalidInteger() {
        //given
        final String value = "one";
        final StringHelp target = new StringHelp(value);

        //when
        final Optional<Integer> result = target.byConvertingToInteger();

        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void byConvertingToInteger_ShouldReturnInteger_WhenGivenValidInteger() {
        //given
        final String value = "1";
        final StringHelp target = new StringHelp(value);

        //when
        final Optional<Integer> optionalInteger = target.byConvertingToInteger();
        final Integer result = optionalInteger.get();

        //then
        assertThat(result).isEqualTo(1);
    }
}