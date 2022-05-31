package com.gridnine.testing;

public class Main {

    public static void main(String[] args) {

        Filter pastDateDeparture = new PastDateDepartureFilter();
        Filter arrivalBeforeDeparture = new ArrivalBeforeDepartureFilter();
        Filter moreThanTwoHoursWaiting = new MoreThanTwoHoursWaitingFilter();

        System.out.println("Before filtering:");
        System.out.println(FlightBuilder.createFlights() + "\n");

        System.out.println("1. Departure not earlier than today:");
        System.out.println(pastDateDeparture.filter(FlightBuilder.createFlights()) + "\n");

        System.out.println("2. No segments with arriving before departure time:");
        System.out.println(arrivalBeforeDeparture.filter(FlightBuilder.createFlights()) + "\n");

        System.out.println("3. Waiting time between segments less than 2 hours:");
        System.out.println(moreThanTwoHoursWaiting.filter(FlightBuilder.createFlights()) + "\n");
    }
}
