package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a filter that returns flights
 * in which the total time spent on the ground does not exceed two hours.
 * (Этот класс представляет фильтр, который возвращает полёты, в которых
 * общее время, проведённое на земле не превышает два часа)
 */

public class ExcludeTransferMoreTwoHours implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println("Полёты, в которых общее время, проведённое на земле не превышает два часа: ");
        List<Flight> list = new ArrayList<>();
        flightList.forEach(flight -> {
            int size = flight.getSegments().size();
            if (size > 1) {
                int countHours = 0;
                for (int i = 1; i < size; i++) {
                    countHours += transferTime(flight.getSegments().get(i - 1).getArrivalDate(),
                            flight.getSegments().get(i).getDepartureDate());
                }
                if (countHours <= 2) {
                    list.add(flight);
                }
            } else {
                list.add(flight);
            }
        });
        return list;
    }

    public int transferTime(LocalDateTime arrival, LocalDateTime departure) {
        return (int) ChronoUnit.HOURS.between(arrival, departure);
    }
}
