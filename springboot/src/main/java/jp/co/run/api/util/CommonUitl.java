package jp.co.run.api.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import jp.co.run.api.common.Constants;

/**
 * The Class CommonUitl.
 */
public class CommonUitl {

    /**
     * Gets the current date.
     *
     * @param pattern
     *            the pattern
     * @return the current date
     */
    public static String getCurrentDate(String pattern) {

        String currentDate = Constants.CONST_STRING_EMPTY;
        if (pattern != null && !pattern.isEmpty()) {
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(Constants.CONST_TIMEZONE_JP));
            SimpleDateFormat sfd = new SimpleDateFormat(pattern);
            sfd.setTimeZone(TimeZone.getTimeZone(Constants.CONST_TIMEZONE_JP));
            currentDate = sfd.format(cal.getTime());
        }
        return currentDate;
    }
}
