package utils;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {

    private static DateFormat sdfBirthday = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

    public static ObjectNode createResponse(Object response, boolean ok) {
        ObjectNode result = Json.newObject();
        result.put("isSuccessfull", ok);
        if (response instanceof String) {
            result.put("body", (String) response);
        } else {
            result.putPOJO("body", response);
        }
        return result;
    }

    public static Date parseBirthdayFromString(String strBirthday) {
        try {
            return sdfBirthday.parse(strBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
