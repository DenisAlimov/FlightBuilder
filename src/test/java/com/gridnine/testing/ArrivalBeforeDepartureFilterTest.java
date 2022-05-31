package com.gridnine.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrivalBeforeDepartureFilterTest {

    @Test
    public void testFilter() {
        LocalDateTime today = LocalDateTime.now();
        Filter arrivalBeforeDeparture = new ArrivalBeforeDepartureFilter();

        //act
        List<Flight> result = arrivalBeforeDeparture.filter(new ArrayList<>(Arrays.asList(
                FlightBuilder.createFlight(today.plusHours(2), today.plusHours(1)),
                FlightBuilder.createFlight(today.plusDays(4), today.plusDays(4).minusMinutes(1)),
                FlightBuilder.createFlight(today.plusDays(2), today)))
        );

        //assert
        Assert.assertTrue(result.isEmpty());
    }
}
