package ua.epam.sergiishapoval.projects.xmlxsd;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;

/**
 * Created by Сергей on 16.02.2015.
 */
public class XmlErrorHandler implements ErrorHandler {
    private Logger logger;
    private boolean isValid = true;

    public XmlErrorHandler(String log) throws IOException {
        logger = Logger.getLogger("error");
        logger.addAppender(new FileAppender(new SimpleLayout(), log));
    }

    public boolean isValid() {
        return isValid;
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        logger.warn(getLineAddress(exception) + "-" + exception.getMessage());
        isValid = false;
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        logger.error(getLineAddress(exception) + " - " + exception.getMessage());
        isValid = false;
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        logger.fatal(getLineAddress(exception) + " - " + exception.getMessage());
        isValid = false;
    }

    private String getLineAddress(SAXParseException e) {
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }

}
