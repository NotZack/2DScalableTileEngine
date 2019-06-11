package logging;

import logging.LoggerImplementations.DebugLogger;
import logging.LoggerImplementations.UserEventLogger;

public class LoggerHandler {

    private static DebugLogger debugLog = new DebugLogger();
    private static UserEventLogger userLog = new UserEventLogger();

    public static void logEvent(Object event, String eventPlainText) {
        if (event instanceof Exception)
            debugLog.logEvent(eventPlainText);

    }
}
