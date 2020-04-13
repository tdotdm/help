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

    @Test
    public void byConfirmingQueryIsIndependentlyPresent_ShouldReturnTrue_WhenValueIsPresent() {
        //given
        final StringHelp target = new StringHelp("Women is plural for woman.");
        final String query = "woman";

        //when
        final boolean result = target.byConfirmingQueryIsIndependentlyPresent(query);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void byConfirmingQueryIsIndependentlyPresent_ShouldReturnFalse_WhenValueIsNotPresent() {
        //given
        final StringHelp target = new StringHelp("Women is plural for woman.");
        final String query = "men";

        //when
        final boolean result = target.byConfirmingQueryIsIndependentlyPresent(query);

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void byConfirmingQueryIsIndependentlyPresent_ShouldReturnFalse_WhenValueHasDifferentCase() {
        //given
        final StringHelp target = new StringHelp("Women is plural for woman.");
        final String query = "women";

        //when
        final boolean result = target.byConfirmingQueryIsIndependentlyPresent(query);

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void byConfirmingQueryIsIndependentlyPresentIgnoringCase_ShouldReturnTrue_WhenValueIsPresent() {
        //given
        final StringHelp target = new StringHelp("Women is plural for woman.");
        final String query = "woman";

        //when
        final boolean result = target.byConfirmingQueryIsIndependentlyPresentIgnoringCase(query);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void byConfirmingQueryIsIndependentlyPresentIgnoringCase_ShouldReturnFalse_WhenValueIsNotPresent() {
        //given
        final StringHelp target = new StringHelp("Women is plural for woman.");
        final String query = "men";

        //when
        final boolean result = target.byConfirmingQueryIsIndependentlyPresentIgnoringCase(query);

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void byConfirmingQueryIsIndependentlyPresentIgnoringCase_ShouldReturnTrue_WhenValueHasDifferentCase() {
        //given
        final StringHelp target = new StringHelp("Women is plural for woman.");
        final String query = "women";

        //when
        final boolean result = target.byConfirmingQueryIsIndependentlyPresentIgnoringCase(query);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void byFormattingTimestamp_ShouldThrowException_WhenFirstArgumentIsNull() {
        //given
        final StringHelp target = new StringHelp("2020-01-23T12:51:50.217");

        //then
        assertThatThrownBy(() -> target.byFormattingTimestamp(null, "yyyy-MM-dd'T'HH:mm:ss"))
                .isInstanceOf(HelpException.class);
    }

    @Test
    public void byFormattingTimestamp_ShouldThrowException_WhenSecondArgumentIsNull() {
        //given
        final StringHelp target = new StringHelp("2020-01-23T12:51:50.217");

        //then
        assertThatThrownBy(() -> target.byFormattingTimestamp("yyyy-MM-dd'T'HH:mm:ss.SSS", null))
                .isInstanceOf(HelpException.class);
    }

    @Test
    public void byFormattingTimestamp_ShouldReturnExpectedFormat() {
        //given
        final StringHelp target = new StringHelp("2020-01-23T12:51:50.217");

        //when
        final String result = target.byFormattingTimestamp("yyyy-MM-dd'T'HH:mm:ss.SSS", "yyyy-MM-dd'T'HH:mm:ss");

        //then
        assertThat(result).isEqualTo("2020-01-23T12:51:50");
    }

    @Test
    public void byFormattingTimestamp_ShouldReturnValue_WhenMismatchingArguments() {
        //given
        final StringHelp target = new StringHelp("2020-01-23T12:51:50");

        //when
        final String result = target.byFormattingTimestamp("yyyy-MM-dd'T'HH:mm:ss.SSS", "yyyy-MM-dd");

        //then
        assertThat(result).isEqualTo("2020-01-23T12:51:50");
    }

    @Test
    public void byFormattingTimestamp_ShouldReturnValue_WhenValueIsNotATimestamp() {
        //given
        final StringHelp target = new StringHelp("not-a-timestamp-value");

        //when
        final String result = target.byFormattingTimestamp("yyyy-MM-dd'T'HH:mm:ss.SSS", "yyyy-MM-dd");

        //then
        assertThat(result).isEqualTo("not-a-timestamp-value");
    }
}