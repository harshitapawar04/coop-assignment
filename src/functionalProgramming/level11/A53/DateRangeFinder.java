package functionalProgramming.level11.A53;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DateRangeFinder {
    public static void main(String[] args) {
        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2023, 5, 20),
                LocalDate.of(2022, 12, 31),
                LocalDate.of(2024, 1, 1),
                LocalDate.of(2021, 7, 15)
        );

        // Custom Comparator (natural order)
        Comparator<LocalDate> comparator = Comparator.naturalOrder();

        Optional<LocalDate> earliest = dates.stream().min(comparator);
        Optional<LocalDate> latest = dates.stream().max(comparator);

        earliest.ifPresent(date -> System.out.println("Earliest Date: " + date));
        latest.ifPresent(date -> System.out.println("Latest Date: " + date));
    }
}
