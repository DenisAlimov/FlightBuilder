package com.gridnine.testing;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class MoreThanTwoHoursWaitingFilter implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(this::waitingTimeTwoHoursMore)
                .collect(Collectors.toList());
    }

    public boolean waitingTimeTwoHoursMore(Flight flight) {
        long flyTime = 0;
        int size = flight.getSegments().size();

        for (Segment segment : flight.getSegments()) {
            flyTime += Math.abs(ChronoUnit.MINUTES.between(segment.getArrivalDate(), segment.getDepartureDate()));
        }
        long wayTime = Math.abs(ChronoUnit.MINUTES.between(flight.getSegments().get(0).getDepartureDate(),
                flight.getSegments().get(size - 1).getArrivalDate()));

        return wayTime - flyTime < 120;
    }
}
