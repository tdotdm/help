package com.github.tdotdm;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class LoggerAdapterTest {
    private static final String TEST_LOG_MESSAGE = "Test Log Message";

    private final Logger logger = mock(Logger.class);

    private void givenLoggerDebugEnabledIs(final boolean isEnabled) {
        //given
        when(logger.isDebugEnabled()).thenReturn(isEnabled);
    }

    @Test
    public void debug_ShouldLogMessage_WhenDebugIsEnabled() {
        //given
        givenLoggerDebugEnabledIs(true);

        //when
        LoggerAdapter.debug(logger, TEST_LOG_MESSAGE);

        //then
        Mockito.verify(logger, times(1)).debug(any());
    }

    @Test
    public void debug_ShouldNotLogMessage_WhenDebugIsNotEnabled() {
        //given
        givenLoggerDebugEnabledIs(false);

        //when
        LoggerAdapter.debug(logger, TEST_LOG_MESSAGE);

        //then
        Mockito.verify(logger, times(0)).debug(any());
    }
}