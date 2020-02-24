package com.github.tdotdm;

import org.junit.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class HelpTest {
    @Test
    public void help_ShouldReturnStringHelp_WhenGivenString() {
        //when
        final StringHelp result = Help.help("string");

        //then
        assertThat(result).isNotNull();
    }

    @Test
    public void help_ShouldReturnSetHelp_WhenGivenSet() {
        //when
        final SetHelp result = Help.help(new HashSet<>());

        //then
        assertThat(result).isNotNull();
    }
}
