package com.gridnine.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PastDateDepartureFilterTest {

    @Test
    public void testFilter() {
        LocalDateTime today = LocalDateTime.now();
        Filter pastDateDeparture = new PastDateDepartureFilter();

        //act
        List<Flight> result = pastDateDeparture.filter(new ArrayList<>(Arrays.asList(
                FlightBuilder.createFlight(today.minusHours(1), today.plusHours(4)),
                FlightBuilder.createFlight(today.minusDays(1), today.minusDays(1).plusHours(1)),
                FlightBuilder.createFlight(today.minusMinutes(1), today.plusHours(2))))
        );

        //assert
        Assert.assertTrue(result.isEmpty());
    }
}
