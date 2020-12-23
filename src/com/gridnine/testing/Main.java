package com.gridnine.testing;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> listFlights = FlightBuilder.createFlights();
        Handler.filterDepartureUntilNow(listFlights);
        Handler.filterDepartureAfterArrive(listFlights);
        Handler.filterMoreThanTwoHoursOnTheGround(listFlights);
    }

}
