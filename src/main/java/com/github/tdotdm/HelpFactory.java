package com.github.tdotdm;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.Set;

/**
 * The core access point of Help.
 *
 * @author Darryn McGaw
 * @since 2.0.0
 */
@SuppressWarnings("MultipleStringLiterals")
public abstract class HelpFactory {
    private static final Logger LOGGER = Logger.getLogger(HelpFactory.class);

    private static String createLogMessage(final String helpIdentifier,
                                           final Object helpValue) {
        return "Returning new instance of '" + helpIdentifier + "' with value '" + helpValue + "'.";
    }

    /**
     * Return a new instance of BooleanHelp.
     *
     * @param value The value to instantiate BooleanHelp with.
     * @return A new instance of BooleanHelp.
     */
    public static BooleanHelp help(final Boolean value) {
        final String logMessage = createLogMessage(BooleanHelp.IDENTIFIER, value);
        LoggerAdapter.debug(LOGGER, logMessage);

        return new BooleanHelp(value);
    }

    /**
     * Return a new instance of IntegerHelp.
     *
     * @param value The value to instantiate IntegerHelp with.
     * @return A new instance of IntegerHelp.
     */
    public static IntegerHelp help(final Integer value) {
        final String logMessage = createLogMessage(IntegerHelp.IDENTIFIER, value);
        LoggerAdapter.debug(LOGGER, logMessage);

        return new IntegerHelp(value);
    }

    /**
     * Return a new instance of ListHelp.
     *
     * @param value The value to instantiate ListHelp with.
     * @return A new instance of ListHelp.
     */
    public static ListHelp help(final List<?> value) {
        final String logMessage = createLogMessage(ListHelp.IDENTIFIER, value);
        LoggerAdapter.debug(LOGGER, logMessage);

        return new ListHelp(value);
    }

    /**
     * Return a new instance of SetHelp.
     *
     * @param value The value to instantiate SetHelp with.
     * @return A new instance of SetHelp.
     */
    public static SetHelp help(final Set<?> value) {
        final String logMessage = createLogMessage(SetHelp.IDENTIFIER, value);
        LoggerAdapter.debug(LOGGER, logMessage);

        return new SetHelp(value);
    }

    /**
     * Return a new instance of StringHelp.
     *
     * @param value The value to instantiate StringHelp with.
     * @return A new instance of StringHelp.
     */
    public static StringHelp help(final String value) {
        final String logMessage = createLogMessage(StringHelp.IDENTIFIER, value);
        LoggerAdapter.debug(LOGGER, logMessage);

        return new StringHelp(value);
    }
}
