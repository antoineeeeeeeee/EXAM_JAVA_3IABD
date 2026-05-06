package exo;

import models.Trip;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Partie3 {

    private static final Comparator<Trip> byRating = (t1, t2) -> Double.compare(t1.rating(), t2.rating());
    private static final Comparator<Trip> byPrice = (t1, t2) -> Double.compare(t1.price(), t2.price());

    public static List<Trip> top10ExpensiveTrips(List<Trip> trips) {
        // coder ici
        return trips.stream()
                .sorted(byPrice.reversed())
                .limit(10)
                .toList();
    }

    public static Optional<Trip> bestTrip(List<Trip> trips) {
        // coder ici
        return trips.stream().max(byRating);
    }

    public static void run(List<Trip> trips) {
        top10ExpensiveTrips(trips).forEach(System.out::println);
        System.out.println("\n");
        bestTrip(trips).ifPresent(System.out::println);
    }
}
