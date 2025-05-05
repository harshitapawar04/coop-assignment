package multiThreading.assginment1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogMessage {
    private final LocalDateTime time = LocalDateTime.now();
    private final LogLevel level;
    private final String message;

    public LogMessage(LogLevel level, String message) {
        this.level = level;
        this.message = message;
    }

    public String toString() {
        return "[" + time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "] [" + level + "] " + message;
    }
}
