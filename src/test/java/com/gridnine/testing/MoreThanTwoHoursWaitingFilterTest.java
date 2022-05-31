package com.gridnine.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoreThanTwoHoursWaitingFilterTest {
    @Test
    public void testFilter() {
        LocalDateTime today = LocalDateTime.now();
        Filter moreThanTwoHoursWaiting = new MoreThanTwoHoursWaitingFilter();

        //act
        List<Flight> result = moreThanTwoHoursWaiting.filter(new ArrayList<>(Arrays.asList(
                FlightBuilder.createFlight(
                        today.plusHours(2), today.plusHours(3),
                        today.plusHours(5), today.plusHours(6)),
                FlightBuilder.createFlight(
                        today.plusHours(2), today.plusHours(3),
                        today.plusHours(4).plusMinutes(50), today.plusHours(5),
                        today.plusHours(5).plusMinutes(10), today.plusHours(6)), //+10 минут должно проходить(1:50:00 + 0:10:00 = 2:00:00), +9 - не должно
                FlightBuilder.createFlight(
                        today.plusDays(2), today.plusDays(3),
                        today.plusDays(4), today.plusDays(4).plusHours(2))))
        );

        //assert
        Assert.assertTrue(result.isEmpty());
    }
}