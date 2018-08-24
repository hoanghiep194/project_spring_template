package jp.co.run.api.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    /**
     * Convert Date to String
     * @param date
     * @param pattern
     * @return
     */
    public static String convertDateToString (Date date, String pattern) {
        String result = Constants.CONST_STRING_EMPTY;
        if(date != null && !pattern.isEmpty() ) {
            SimpleDateFormat sfd = new SimpleDateFormat(pattern);
            result = sfd.format(date);
        }
        return result;
    }

    public static Date convertStringToDate(String date, String pattern) {
        Date result = null;
        if(date != null && !pattern.isEmpty() ) {
            SimpleDateFormat sfd = new SimpleDateFormat(pattern);
            try {
                result = sfd.parse(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * Check password with confirm password
     *
     * @param password the password
     * @param confirmPassword the confirm password
     * @return true, if successful
     */
    public static boolean checkPassword(String password, String confirmPassword) {

        if(password == null || confirmPassword == null) {
            return false;
        } else {
            if(password.equals(confirmPassword)) {
                return true;
            }
        }
        return false;
    }
}
