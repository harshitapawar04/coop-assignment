package multiThreading.assginment1;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Logger {
    private final BlockingQueue<LogMessage> queue = new LinkedBlockingQueue<>();
    private final AtomicBoolean running = new AtomicBoolean(true);
    private final Thread worker;

    public Logger() {
        worker = new Thread(() -> {
            while (running.get() || !queue.isEmpty()) {
                try {
                    flushLogs(); // print logs
                    Thread.sleep(5000); // wait 5 seconds
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        worker.start();
    }

    public void log(LogLevel level, String message) {
        queue.offer(new LogMessage(level, message));
    }

    public void shutdown() {
        running.set(false); // signal stop
        try {
            worker.join(); // wait for thread to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void flushLogs() {
        LogMessage msg;
        while ((msg = queue.poll()) != null) {
            System.out.println(msg);
        }
    }
}
