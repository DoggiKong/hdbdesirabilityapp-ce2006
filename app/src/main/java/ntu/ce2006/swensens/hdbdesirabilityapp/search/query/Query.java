package com.example.jonathan.local_2006_test;

/**
 * Created by Jonathan on 29-Mar-17.
 */
import java.util.ArrayList;
import java.util.List;


/**
 * Query in builder pattern
 *
 * Example Construction
 * Query query = new Query.Builder().locations(locationList).sizes(sizesList).price(0, 100)
 *          .areas(0,4).amenities(amenitiesList).build();
 *
 * Created by Swensens on 20/03/17.
 */

public class Query {

    private int id_key;

    //String Identifier
    private String desc;

    // A list of location filters
    private List<Location> locationFilters;

    // A list of size filters
    private List<Size> sizeFilters;

    // Price range: [minimum, maximum]
    private int[] priceFilters;

    // A list of amenity filters
    private List<Amenities> amenitiesFilters;

    /**
     * Builder Class
     */
    public static class Builder {
        // Optional Parameters
        private int id_key = 0;

        //String identifier
        private String desc = "Default";

        // A list of location filters
        private List<Location> locationFilters = new ArrayList<>();

        // A list of size filters
        private List<Size> sizeFilters = new ArrayList<>();

        // Price range: [minimum, maximum]
        private int[] priceFilters = new int[2];

        // A list of amenity filters
        private List<Amenities> amenitiesFilters = new ArrayList<>();

        public Builder idDB(int id){
            id_key = id;
            return this;
        }

        public Builder desc(String desc){
            desc = desc;
            return this;
        }

        public Builder locations(ArrayList<Location> locations) {
            locationFilters = locations;
            return this;
        }

        public Builder size(ArrayList<Size> sizes) {
            sizeFilters = sizes;
            return this;
        }

        public Builder price(int[] arr) {
            priceFilters[0] = arr[0];
            priceFilters[1] = arr[1];
            return this;
        }

        public Builder amenities(ArrayList<Amenities> amenities) {
            amenitiesFilters = amenities;
            return this;
        }

        public Query build() {
            return new Query(this);
        }
    }

    private Query(Builder builder) {
        id_key = builder.id_key;
        desc = builder.desc;
        locationFilters = builder.locationFilters;
        sizeFilters = builder.sizeFilters;
        priceFilters = builder.priceFilters;
        amenitiesFilters = builder.amenitiesFilters;
    }

    public int getId_key() {
        return id_key;
    }

    public String getDesc(){return desc;}

    public List<Location> getLocationFilters() {
        return locationFilters;
    }

    public List<Size> getSizeFilters() {
        return sizeFilters;
    }

    public int[] getPriceFilters() {
        return priceFilters;
    }

    public List<Amenities> getAmenitiesFilters() {
        return amenitiesFilters;
    }

    public boolean isLocationEmpty() {
        return locationFilters.size() == 0;
    }

    public boolean isSizeEmpty() {
        return locationFilters.size() == 0;
    }

    public boolean isPriceEmpty() {
        return priceFilters[0] == 0 && priceFilters[1] == 0;
    }

    public boolean isAmenitiesEmpty() {
        return amenitiesFilters.size() == 0;
    }


}
