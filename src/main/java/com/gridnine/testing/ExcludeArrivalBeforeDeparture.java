package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a filter that returns flights
 * that exclude flights with an arrival date earlier than the departure date.
 * (Этот класс представляет фильтр, который возвращает полёты,
 * в которых исключены полёты с датой прилёта раньше даты вылета)
 */
public class ExcludeArrivalBeforeDeparture implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println("Полёты, без сегментов с датой прилёта раньше даты вылета: ");
        List<Flight> list = new ArrayList<>();
        flightList.forEach(flight -> flight.getSegments().stream().
                filter(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())).limit(1).
                forEach(segment -> list.add(flight)));
        return list;
    }
}

