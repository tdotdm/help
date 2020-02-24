package com.github.tdotdm;

import org.junit.Test;

import java.util.Optional;

import static com.github.tdotdm.Help.help;
import static org.assertj.core.api.Assertions.assertThat;

public class StringHelpTest {
    @Test
    public void byRemovingWhitespace_ShouldRemoveAllWhitespace() {
        //given
        final String value = "Monday Tuesday Wednesday Thursday Friday Saturday Sunday !";

        //when
        final String result = help(value).byRemovingWhitespace();

        //then
        assertThat(result).isEqualTo("MondayTuesdayWednesdayThursdayFridaySaturdaySunday!");
    }

    @Test
    public void byConvertingToInteger_ShouldReturnEmptyOptional_WhenGivenInvalidInteger() {
        //given
        final String value = "one";

        //when
        final Optional<Integer> result = help(value).byConvertingToInteger();

        //then
        assertThat(result).isEmpty();
    }

    @Test
    public void byConvertingToInteger_ShouldReturnInteger_WhenGivenValidInteger() {
        //given
        final String value = "1";

        //when
        final Optional<Integer> optionalInteger = help(value).byConvertingToInteger();
        final Integer result = optionalInteger.get();

        //then
        assertThat(result).isEqualTo(1);
    }
}