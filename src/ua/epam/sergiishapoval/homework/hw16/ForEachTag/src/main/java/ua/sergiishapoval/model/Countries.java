package ua.sergiishapoval.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Сергей on 18.12.2014.
 */
public class Countries {
    String[] countries;




    Collection<?> collection = new ArrayList<String>(){{
        add("first element");
        add("second element");
        add("third element");
    }};

    public Collection<?> getCollection() {
        return collection;
    }

    public void setCollection(Collection<?> collection) {
        this.collection = collection;
    }

    public String[] getCountries() {
        return countries;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }
}
