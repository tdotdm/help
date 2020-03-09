package com.github.tdotdm;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SetHelpFactoryTest {
    @Test
    public void constructor_ShouldThrowException_WhenGivenNullValue() {
        //then
        assertThatThrownBy(() -> new SetHelp(null))
                .isInstanceOf(HelpException.class);
    }

    @Test
    public void byChangingToList_ShouldReturnList() {
        //given
        final Set<String> stringSet = new HashSet<>();
        Collections.addAll(stringSet, "a", "b", "c", "d");
        final SetHelp target = new SetHelp(stringSet);

        //when
        final List<?> result = target.byChangingToList();

        //then
        assertThat(result.size()).isEqualTo(stringSet.size());
    }
}
