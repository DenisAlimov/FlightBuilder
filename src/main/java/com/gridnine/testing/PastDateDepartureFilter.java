package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PastDateDepartureFilter implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight
                        .getSegments()
                        .stream().anyMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now()))
                )
                .collect(Collectors.toList());
    }
}
