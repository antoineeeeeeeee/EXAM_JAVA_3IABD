package exo;

import models.Trip;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Partie1 {

    private static final Predicate<Trip> byDistance = trip -> trip.distanceKm()>10;
    private static final Predicate<Trip> byPrix = trip -> trip.price()>20;
    private static final Predicate<Trip> isBad = trip -> trip.rating()<3;
    private static final Predicate<Trip> today = trip -> trip.endTime().toLocalDate().equals(LocalDate.now());
    private static final Predicate<Trip> yesterday = trip -> trip.endTime().toLocalDate().equals(LocalDate.now().minusDays(1));


    public static List<Trip> longAndExpensiveTrips(List<Trip> trips) {
        // distance > 10km et prix > 20€
        return trips.stream().filter(byDistance.and(byPrix)).toList();
    }

    public static List<Trip> badTrips(List<Trip> trips) {
        // rating < 3
        return trips.stream().filter(isBad).toList();
    }

    public static List<Trip> recentTrips(List<Trip> trips) {
        // aujourd’hui ou hier
        return trips.stream().filter(today.or(yesterday)).toList();
    }

    public static List<Trip> run(List<Trip> trips) {

        return recentTrips(badTrips(longAndExpensiveTrips(trips)));
    }
}
