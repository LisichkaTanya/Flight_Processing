package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        printFlightList(flights);

        Filter filter1 = new UpcomingFlights();
        Filter filter2 = new ExcludeArrivalBeforeDeparture();
        Filter filter3 = new ExcludeTransferMoreTwoHours();

        printFlightList(filter1.filter(flights));
        printFlightList(filter2.filter(flights));
        printFlightList(filter3.filter(flights));
    }
    public static void printFlightList(List<Flight> list) {
        list.forEach(System.out::println);
        System.out.println("-----------------------");
    }
}
