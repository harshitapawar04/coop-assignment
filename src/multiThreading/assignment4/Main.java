package multiThreading.assignment4;

import java.util.concurrent.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int MAX = 50;

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<String>> futures = new ArrayList<>();

        for (int i = 1; i <= MAX; i++) {
            futures.add(executorService.submit(new ImageProcessor.ImageTask(i)));
        }

        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // in milliseconds
        System.out.println("Total execution time: " + duration + " ms");
    }
}
