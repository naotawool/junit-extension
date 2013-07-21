package org.junit.extention;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class TestUtils {

    /**
     * インスタンス化を抑制。
     */
    private TestUtils() {
        // NOP
    }

    public static Date createDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);

        return DateUtils.truncate(cal, Calendar.DAY_OF_MONTH).getTime();
    }
}
