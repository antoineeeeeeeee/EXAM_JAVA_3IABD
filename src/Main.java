import factory.TripFactory;
import models.Trip;

import exo.Partie1;
import exo.Partie2;
import exo.Partie3;
import exo.Partie4;

void main() {
    List<Trip> trips = TripFactory.generateTrips(100);

    // PARTIE 1
    //List<Trip> part1 = Partie1.run(trips);
    //part1.forEach(System.out::println);

    // PARTIE 2
    //Map<String, Double> part2 = Partie2.run(trips);
    //part2.forEach((city, count) -> System.out.println(city + " : " + count));


    // appeler les méthodes des exos ici
    // pour tester si ça marche bien, générer une liste de 10 éléments et afficher le résultat
}