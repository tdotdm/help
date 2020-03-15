package com.github.tdotdm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class HelpFactoryTest {
    @Test
    public void help_ShouldReturnBooleanHelp_WhenGivenBoolean() {
        //when
        final BooleanHelp result = HelpFactory.help(Boolean.TRUE);

        //then
        assertThat(result).isNotNull();
    }

    @Test
    public void help_ShouldReturnStringHelp_WhenGivenString() {
        //when
        final StringHelp result = HelpFactory.help("string");

        //then
        assertThat(result).isNotNull();
    }

    @Test
    public void help_ShouldReturnListHelp_WhenGivenSet() {
        //when
        final ListHelp result = HelpFactory.help(new ArrayList<>());

        //then
        assertThat(result).isNotNull();
    }

    @Test
    public void help_ShouldReturnSetHelp_WhenGivenSet() {
        //when
        final SetHelp result = HelpFactory.help(new HashSet<>());

        //then
        assertThat(result).isNotNull();
    }

    @Test
    public void help_ShouldReturnIntegerHelp_WhenGivenInteger() {
        //when
        final IntegerHelp result = HelpFactory.help(-1);

        //then
        assertThat(result).isNotNull();
    }
}
