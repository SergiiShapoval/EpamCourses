package ua.epam.sergiishapoval.projects.xmlxsd;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

/**
 * Created by Сергей on 16.02.2015.
 */
public class XmlValidator {

    public static boolean isValidXml(String filename) {
        DOMParser parser = new DOMParser();
        try {
            XmlErrorHandler errorHandler = new XmlErrorHandler("log.txt");
            parser.setErrorHandler(errorHandler);
            parser.setFeature("http://xml.org/sax/features/validation", true);
            parser.setFeature("http://apache.org/xml/features/validation/schema", true);
            parser.parse(filename);
            return errorHandler.isValid();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
