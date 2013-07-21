package org.junit.extention.matcher;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * {@link Date}の年月日についての検証を行う{@link Matcher}。
 * 
 * @author naotake
 */
public class IsSameDate extends TypeSafeMatcher<Date> {

    private static final FastDateFormat FORMAT = FastDateFormat.getInstance("yyyy/MM/dd");

    private Date expect;

    private IsSameDate(Date expect) {
        this.expect = expect;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(FORMAT.format(expect));
    }

    @Override
    protected void describeMismatchSafely(Date actual, Description mismatchDescription) {
        mismatchDescription.appendText(FORMAT.format(actual));
    }

    @Override
    protected boolean matchesSafely(Date actual) {
        Date ignoreTimeActual = DateUtils.truncate(actual, Calendar.DAY_OF_MONTH);
        return ignoreTimeActual.equals(expect);
    }

    public static IsSameDate isSameDate(int year, int month, int date) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, date);

        return new IsSameDate(DateUtils.truncate(cal, Calendar.DAY_OF_MONTH).getTime());
    }
}
