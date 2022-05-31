package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDepartureFilter implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight
                        .getSegments().stream()
                        .anyMatch(segment -> segment.getDepartureDate()
                                .isBefore(segment.getArrivalDate()))
                )
                .collect(Collectors.toList());
    }
}
