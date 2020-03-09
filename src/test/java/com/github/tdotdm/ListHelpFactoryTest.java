package com.github.tdotdm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ListHelpFactoryTest {
    @Test
    public void constructor_ShouldThrowException_WhenGivenNullValue() {
        //then
        assertThatThrownBy(() -> new ListHelp(null))
                .isInstanceOf(HelpException.class);
    }

    @Test
    public void byRemovingDuplicates_ShouldRemoveDuplicates() {
        //given
        final List<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c", "d", "d");
        final ListHelp target = new ListHelp(list);

        //when
        final List<?> result = target.byRemovingDuplicates();

        //then
        assertThat(result.size()).isEqualTo(4);
    }
}