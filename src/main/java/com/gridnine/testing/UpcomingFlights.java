package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents a filter that outputs upcoming flights to the console,
 * i.e. flights up to the current time are excluded.
 * (Этот класс представляет фильтр, который выводит в консоль предстоящие полеты,
 * то есть полеты до текущего времени исключены)
 */
public class UpcomingFlights implements Filter {
    private final LocalDateTime now = LocalDateTime.now();

    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println("Предстоящие полеты, то есть исключены полеты до текущего времени: ");
        List<Flight> list = new ArrayList<>();
        flightList.forEach(flight -> flight.getSegments().stream().
                filter(segment -> segment.getDepartureDate().isAfter(now)).limit(1).
                forEach(segment -> list.add(flight)));
        return list;
    }
}