package com.gridnine.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UpcomingFlightsTest.class,
        ExcludeArrivalBeforeDepartureTest.class,
        ExcludeTransferMoreTwoHoursTest.class
})
public class AllFilterTest {
}
