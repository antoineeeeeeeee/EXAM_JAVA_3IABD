package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Partie2 {

    private static final Function<Trip, String> groupByCity = trip -> trip.city();
    private static final Function<Trip, String> groupByDriver = trip -> trip.driverId();
    private static final ToDoubleFunction<Trip> getPrice = trip -> trip.price();
    private static final ToDoubleFunction<Trip> getDuration = trip -> trip.durationMin();

    public static Map<String, Long> countByCity(List<Trip> trips) {
        // coder ici
        return trips.stream().collect(Collectors.groupingBy(groupByCity, Collectors.counting()));
    }

    public static Map<String, Double> revenueByDriver(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(groupByDriver, Collectors.summingDouble(getPrice)));
    }

    public static Map<String, Double> avgDurationByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(groupByCity, Collectors.averagingDouble(getDuration)));
    }

    public static Map<String, Double> run(List<Trip> trips) {
        return avgDurationByCity(trips);
    }
}
