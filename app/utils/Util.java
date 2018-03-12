package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {

    private static DateFormat sdfBirthday = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

    public static Date parseBirthdayFromString(String strBirthday) {
        try {
            return sdfBirthday.parse(strBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
