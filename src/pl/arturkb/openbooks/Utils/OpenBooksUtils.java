package pl.arturkb.openbooks.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO comments
 */
public class OpenBooksUtils {

    /**
     * Prepare string with date format.
     *
     * @param milliseconds the milliseconds
     * @return string as MMM dd,yyyy HH:mm
     */
    static public String calcDate(long milliseconds) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultDate = new Date(milliseconds);
        return dateFormat.format(resultDate);
    }

}
