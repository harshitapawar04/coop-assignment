package multiThreading.assignment3;

class EvenThread implements Runnable {
    private final Printer printer;

    public EvenThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        try {
            printer.printEven();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
