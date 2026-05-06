package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Partie4 {

    private static final ToDoubleFunction<Trip> getPrice = trip -> trip.price();
    private static final Function<Trip, String> toCity = trip -> trip.city();
    private static final Predicate<Trip> isPremium = trip -> trip.price() > 30 && trip.rating() > 4;

    private static final Collector<Trip, ?, Double> summingPrice = Collectors.summingDouble(getPrice);

    public static double totalRevenueSequential(List<Trip> trips) {
        return trips.stream()
                .collect(summingPrice);
    }

    public static double totalRevenueParallel(List<Trip> trips) {
        return trips.parallelStream()
                .collect(summingPrice);
    }

    public static Map<String, Long> countByCityParallel(List<Trip> trips) {
        return trips.parallelStream()
                .collect(Collectors.groupingByConcurrent(toCity, Collectors.counting()));
    }

    public static List<Trip> premiumTripsParallel(List<Trip> trips) {
        return trips.parallelStream()
                .filter(isPremium)
                .toList();
    }

    public static void run(List<Trip> trips) {
        long start = System.currentTimeMillis();

        double sequential = totalRevenueSequential(trips);
        double parallel = totalRevenueParallel(trips);
        Map<String, Long> countByCity = countByCityParallel(trips);
        List<Trip> premiumTrips = premiumTripsParallel(trips);

        long end = System.currentTimeMillis();
        System.out.println("Revenu sequentiel : " + sequential);
        System.out.println("Revenu parallele : " + parallel);
        System.out.println("Temps : " + (end - start) + " ms");
        countByCity.forEach((city, count) -> System.out.println(city + " : " + count));
        premiumTrips.forEach(System.out::println);
    }
}