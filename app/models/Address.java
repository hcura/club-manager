package models;

/**
 * Address
 */
public class Address extends Entity {

    private String street;
    private String code;
    private String city;
    private String state;
    private Country country;
    private Type type;
    private boolean prefered;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isPrefered() {
        return prefered;
    }

    public void setPrefered(boolean prefered) {
        this.prefered = prefered;
    }

    public enum Type {
        HOME,
        WORK
    }
}
