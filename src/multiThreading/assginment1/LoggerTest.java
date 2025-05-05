package multiThreading.assginment1;

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger = new Logger();

        int threadCount = 100;
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int id = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    logger.log(LogLevel.INFO, "Thread " + id + " - Message " + j);
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Shutdown logger
        logger.shutdown();
    }
}

