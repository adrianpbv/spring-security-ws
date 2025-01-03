package com.adrianj.springsec11.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static Date getDateFromNow(int days, int hours, int seconds) {
        // Get the current date and time
        Calendar calendar = Calendar.getInstance();

        // Add the specified days, hours, and seconds
        calendar.add(Calendar.DAY_OF_MONTH, days);
        calendar.add(Calendar.HOUR, hours);
        calendar.add(Calendar.SECOND, seconds);

        // Return the calculated date
        return calendar.getTime();
    }
}
