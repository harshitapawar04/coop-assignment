package multiThreading.assignment4;

import java.util.concurrent.Callable;

public class ImageProcessor {
    public static class ImageTask implements Callable<String>{
        private final int imageId;

        public ImageTask(int imageId) {
            this.imageId = imageId;
        }

        @Override
        public String call() throws InterruptedException {
            Thread.sleep(300);
            return "Image " + imageId + "processed";
        }

    }
}
