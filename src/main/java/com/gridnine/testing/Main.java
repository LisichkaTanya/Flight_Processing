package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter flightFilter = new FlightFilter();
        flightFilter.setFlights(flights);
        printFlightList(flights);

        flightFilter.setFilter(new UpcomingFlights());
        printFlightList(flightFilter.executeFilter());

        flightFilter.setFilter(new ExcludeArrivalBeforeDeparture());
        printFlightList(flightFilter.executeFilter());

        flightFilter.setFilter(new ExcludeTransferMoreTwoHours());
        printFlightList(flightFilter.executeFilter());
    }

    /**
     * This method displays a flight list
     * @param list, that you want to display on the screen
     */
    public static void printFlightList(List<Flight> list) {
        list.forEach(System.out::println);
        System.out.println("-----------------------");
    }
}
