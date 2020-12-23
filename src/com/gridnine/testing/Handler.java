package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class Handler {

    public static void filterDepartureUntilNow(List<Flight> list) {
        System.out.println();
        System.out.println("This is a list of flights whose departure date is earlier than the current time.");
        System.out.println("The current time: " + LocalDateTime.now());
        for (Flight flight : list) {
            List<Segment> listSegments = flight.getSegments();
            for (Segment segment : listSegments) {
                Filter.apply(segment, l -> l.isBefore(LocalDateTime.now()));
            }
        }
    }

    public static void filterDepartureAfterArrive(List<Flight> list) {
        System.out.println();
        System.out.println("This is a list of flights whose arrival date is earlier than the departure date.");
        for (Flight flight : list) {
            List<Segment> listSegments = flight.getSegments();
            for (Segment segment : listSegments) {
                Filter.apply(segment, l -> l.isAfter(segment.getArrivalDate()));
            }
        }
    }

    public static void filterMoreThanTwoHoursOnTheGround(List<Flight> list) {
        System.out.println();
        System.out.println("This is a list of flights that have spent more than two hours on the ground.");
        for (Flight flight : list) {
            List<Segment> listSegments = flight.getSegments();
            Filter.apply(listSegments, (l, l2) -> l.getHour() - l2.getHour() >= 2);
        }
    }

}
