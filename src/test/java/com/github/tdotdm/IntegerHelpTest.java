package com.github.tdotdm;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IntegerHelpTest {
    @Test
    public void constructor_ShouldThrowException_WhenGivenNullValue() {
        //then
        assertThatThrownBy(() -> new IntegerHelp(null))
                .isInstanceOf(HelpException.class);
    }
}