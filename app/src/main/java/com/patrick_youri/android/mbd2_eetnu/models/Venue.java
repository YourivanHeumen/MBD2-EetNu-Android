/**
 * Created by Youri on 7-4-2015.
 */
public class Venue {

    private int id;
    private String name;
    private String category;
    private String website_url;
    private String telephone;
    private Address address;
    private Geolocation geolocation;
    private double distance;

    public Venue(int id, String name, String category, String website_url, String telephone, Address address, Geolocation geolocation, double distance) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.website_url = website_url;
        this.telephone = telephone;
        this.address = address;
        this.geolocation = geolocation;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
