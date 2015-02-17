package ua.epam.sergiishapoval.projects.xmlxsd;


import org.jdom.Attribute;
import org.jdom.Content;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import ua.epam.sergiishapoval.projects.xmlxsd.voucher.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 16.02.2015.
 */
public class DomHandler {

    public static void main(String[] args) {

        String fileName = "C:\\Dropbox\\epam\\EpamCoursesCode\\src\\ua\\epam\\sergiishapoval\\projects\\xmlxsd\\voucher.xml";
        if (!XmlValidator.isValidXml(fileName)) {
            System.out.println("File is not valid, please, provide valid xml file");
            return;
        }
        try {
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(fileName);
            Element root = document.getRootElement();
            List<TouristVoucher> vouchers = getTouristVouchers(root);
            for (TouristVoucher touristVoucher : vouchers){
                System.out.println(touristVoucher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static List<TouristVoucher> getTouristVouchers(Element root) {
        List<TouristVoucher> vouchers = new ArrayList<>();
        for (Element element : (List<Element>) root.getChildren()){
            TouristVoucher currentVoucher = new TouristVoucher();
            currentVoucher.setId(getSoleAttrValue(element));
            setType(element, currentVoucher);
            setCountry(element, currentVoucher);
            setNumberDaysNights(element, currentVoucher);
            setTransport(element, currentVoucher);
            setHotelProps(element, currentVoucher);
            setCost(element, currentVoucher);
            vouchers.add(currentVoucher);
        }
        return vouchers;
    }

    private static void setHotelProps(Element element, TouristVoucher currentVoucher) {
        HotelProps currentHotelProps = new HotelProps();
        Element hotelElement = element.getChild("hotelProps");
        String stars = getSoleContentValueByTagName(hotelElement, "stars");
        currentHotelProps.setStars(Integer.valueOf(stars));
        String meals = getSoleContentValueByTagName(hotelElement, "meals");
        currentHotelProps.setMeals(Meals.valueOf(meals.toUpperCase()));
        String roomPlaces = getSoleContentValueByTagName(hotelElement, "roomPlaces");
        currentHotelProps.setRoomPlaces(Integer.valueOf(roomPlaces));
        String condition = getSoleContentValueByTagName(hotelElement, "condition");
        currentHotelProps.setCondition(condition);
        String TV = getSoleContentValueByTagName(hotelElement, "TV");
        currentHotelProps.setTV(TV);
        String WIFI = getSoleContentValueByTagName(hotelElement, "WIFI");
        currentHotelProps.setWIFI(WIFI);
        String freeParking = getSoleContentValueByTagName(hotelElement, "freeParking");
        currentHotelProps.setFreeParking(freeParking);
        currentVoucher.setHotelProps(currentHotelProps);
    }

    private static void setCost(Element element, TouristVoucher currentVoucher) {
        Price currentPrice = new Price();
        currentPrice.setCurrency(Currency.valueOf(getSoleAttrValue(element.getChild("cost"))));
        String cost = getSoleContentValueByTagName(element, "cost");
        currentPrice.setValue(new BigDecimal(cost));
        currentVoucher.setCost(currentPrice);
    }

    private static void setTransport(Element element, TouristVoucher currentVoucher) {
        String transport = getSoleContentValueByTagName(element, "transport");
        currentVoucher.setTransport(Transport.valueOf(transport.toUpperCase()));
    }

    private static void setNumberDaysNights(Element element, TouristVoucher currentVoucher) {
        String numberDaysNights = getSoleContentValueByTagName(element, "numberDaysNights");
        currentVoucher.setNumberDaysNights(new BigInteger(numberDaysNights));
    }

    private static void setCountry(Element element, TouristVoucher currentVoucher) {
        String country = getSoleContentValueByTagName(element, "country");
        currentVoucher.setCountry(country);
    }

    private static void setType(Element element, TouristVoucher currentVoucher) {
        String type = getSoleContentValueByTagName(element, "type");
        currentVoucher.setType(Type.valueOf(type.toUpperCase()));
    }

    private static String getSoleContentValueByTagName(Element element, String tagName) {
        return  element.getChild(tagName).getContent(0).getValue();
    }

    private static String getSoleAttrValue(Element element) {
        return ((Attribute) element.getAttributes().get(0)).getValue();
    }
}
