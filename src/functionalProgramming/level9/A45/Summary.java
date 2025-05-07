package functionalProgramming.level9.A45;

public class Summary {
    private long count;
    private double averageRating;
    private double totalPrice;

    public Summary(long count, double averageRating, double totalPrice) {
        this.count = count;
        this.averageRating = averageRating;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "count=" + count +
                ", averageRating=" + averageRating +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
