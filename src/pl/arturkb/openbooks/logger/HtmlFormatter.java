package pl.arturkb.openbooks.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Custom formatter formats parts of a log record to a single line
 *
 * @author Artur Barczynski
 * @since 0.1
 */
public class HtmlFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        StringBuilder buffer = new StringBuilder(1024);
        buffer.append("<tr>\n");

        // colorize any levels >= WARNING in red
        if (record.getLevel().intValue() >= Level.WARNING.intValue()) {
            buffer.append("\t<td style=\"color:red\">");
            buffer.append("<b>");
            buffer.append(record.getLevel());
            buffer.append("</b>");
        } else {
            buffer.append("\t<td>");
            buffer.append(record.getLevel());
        }

        buffer.append("</td>\n");
        buffer.append("\t<td>");
        buffer.append(calcDate(record.getMillis()));
        buffer.append("</td>\n");
        buffer.append("\t<td>");
        buffer.append(formatMessage(record));
        buffer.append("</td>\n");
        buffer.append("</tr>\n");

        return buffer.toString();
    }

    /**
     * Prepare string with date format.
     *
     * @param milliseconds the milliseconds
     * @return string as MMM dd,yyyy HH:mm
     */
    private String calcDate(long milliseconds) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultDate = new Date(milliseconds);
        return dateFormat.format(resultDate);
    }

    @Override
    public String getHead(Handler h) {
        return "<!DOCTYPE html>\n<head>\n<style "
                + "type=\"text/css\">\n"
                + "table { width: 100% }\n"
                + "th { font:bold 10pt Tahoma; }\n"
                + "td { font:normal 10pt Tahoma; }\n"
                + "h1 {font:normal 11pt Tahoma;}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>" + (new Date()) + "</h1>\n"
                + "<table border=\"0\" cellpadding=\"5\" cellspacing=\"3\">\n"
                + "<tr align=\"left\">\n"
                + "\t<th style=\"width:10%\">Loglevel</th>\n"
                + "\t<th style=\"width:15%\">Time</th>\n"
                + "\t<th style=\"width:75%\">Log Message</th>\n"
                + "</tr>\n";
    }

    @Override
    public String getTail(Handler h) {
        return "</table>\n</body>\n</html>";
    }
}
