package ua.epam.sergiishapoval.projects.xmlxsd;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.epam.sergiishapoval.projects.xmlxsd.voucher.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Сергей on 16.02.2015.
 */
public class SaxHandler extends DefaultHandler implements SaxConst {
    List<TouristVoucher> vouchers = new ArrayList<>();
    TouristVoucher currentVoucher;
    HotelProps currentHotelProps;
    Price currentPrice = new Price();
    int position = -1;

    public List<TouristVoucher> getVouchers() {
        return vouchers;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Parsing started " + new Date());
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Parsing ended " + new Date());
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        switch (qName){
            case "touristVoucher":
                currentVoucher = new TouristVoucher();
                currentVoucher.setId(attributes.getValue(0));
                break;
            case "type": position = TYPE; break;
            case "country": position = COUNTRY; break;
            case "numberDaysNights": position = NUMBER_DAYS_NIGHTS; break;
            case "transport": position = TRANSPORT; break;
            case "hotelProps": currentHotelProps = new HotelProps(); break;
            case "stars": position = STARS; break;
            case "meals": position = MEALS; break;
            case "roomPlaces": position = ROOM_PLACES; break;
            case "condition": position = CONDITION; break;
            case "TV": position = TV; break;
            case "WIFI": position = WIFI; break;
            case "freeParking": position = FREE_PARKING; break;
            case "cost":
                currentPrice = new Price();
                currentPrice.setCurrency(Currency.valueOf(attributes.getValue(0)));
                position = COST;
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "touristVoucher": vouchers.add(currentVoucher); break;
            case "cost": currentVoucher.setCost(currentPrice); break;
            case "hotelProps": currentVoucher.setHotelProps(currentHotelProps); break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        switch (position) {
            case TYPE: currentVoucher.setType(Type.valueOf(value.toUpperCase())); position=-1; break;
            case COUNTRY: currentVoucher.setCountry(value); position=-1; break;
            case NUMBER_DAYS_NIGHTS: currentVoucher.setNumberDaysNights(new BigInteger(value)); position=-1; break;
            case TRANSPORT: currentVoucher.setTransport(Transport.valueOf(value.toUpperCase())); position=-1; break;
            case STARS: currentHotelProps.setStars(new Integer(value)); position=-1; break;
            case MEALS: currentHotelProps.setMeals(Meals.valueOf(value.toUpperCase())); position=-1; break;
            case ROOM_PLACES: currentHotelProps.setRoomPlaces(new Integer(value)); position=-1; break;
            case CONDITION: currentHotelProps.setCondition(value); position=-1; break;
            case TV: currentHotelProps.setTV(value); position=-1; break;
            case WIFI: currentHotelProps.setWIFI(value); position=-1; break;
            case FREE_PARKING: currentHotelProps.setFreeParking(value); position=-1; break;
            case COST: currentPrice.setValue(new BigDecimal(value)); position=-1; break;
        }
    }

    public static void main(String[] args) {
        try {
            SAXParser parser =
                    SAXParserFactory.newInstance().newSAXParser();
            SaxHandler saxHandler = new SaxHandler();
            String fileAddress = "C:\\Dropbox\\epam\\EpamCoursesCode\\src\\ua\\epam\\sergiishapoval\\projects\\xmlxsd\\voucher.xml";
            if (!XmlValidator.isValidXml(fileAddress)){
                System.out.println("File is not valid, please, provide valid xml file");
                return;
            }
            parser.parse(fileAddress, saxHandler);

            List<TouristVoucher> voucherList = saxHandler.getVouchers();
            for (TouristVoucher voucher : voucherList){
                System.out.println(voucher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
