package pl.arturkb.openbooks.logger;

import java.io.IOException;
import java.util.logging.*;

/**
 * Class with extra logging formatting.
 *
 * @author Artur Barczyński
 * @since 0.1
 */
public class ExtraLogger {

    /**
     * Text file handler.
     */
    static private FileHandler fileTxt;

    /**
     * Simply text formatter.
     */
    static private SimpleFormatter formatterTxt;

    /**
     * Html file handler.
     */
    static private FileHandler fileHTML;

    /**
     * Html formatter {@link pl.arturkb.openbooks.logger.HtmlFormatter
     */
    static private Formatter formatterHTML;

    /**
     * Setup logger.
     *
     * @throws IOException
     */
    static public void setup() throws IOException {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.setLevel(Level.INFO);
        fileTxt = new FileHandler("Logging.txt");
        fileHTML = new FileHandler("Logging.html");

        // create a TXT formatter
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);

        // create an HTML formatter
        formatterHTML = new HtmlFormatter();
        fileHTML.setFormatter(formatterHTML);
        logger.addHandler(fileHTML);
    }

}
