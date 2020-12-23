package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Filter {

    public static void apply(Segment segment, Predicate<LocalDateTime> check) {
        if (check.test(segment.getDepartureDate())) {
            System.out.println(segment);
        }
    }

    public static void apply(List<Segment> segmentList, BiPredicate<LocalDateTime, LocalDateTime> check) {
        for (Segment segment : segmentList) {
            int index = segmentList.indexOf(segment) + 1;
            if (index < segmentList.size()) {
                Segment nextFlight = segmentList.get(index);
                if (check.test(nextFlight.getDepartureDate(), segment.getArrivalDate())) {
                    System.out.println(segment);
                }
            }
        }
    }

}
