package com.adrianj.springsec11.utils;

import org.junit.jupiter.api.Test;

import java.util.Date;

class DateUtilsTest {

    @Test
    void getDateFromNow() {
        Date date = DateUtils.getDateFromNow(5, 0, 0);
        System.out.println(date);
    }
}