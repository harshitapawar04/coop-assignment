package multiThreading.assignment3;

class OddThread implements Runnable {
    private final Printer printer;

    public OddThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        try {
            printer.printOdd();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
