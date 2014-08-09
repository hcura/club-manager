package com.bwu.cm.models;

import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * Address
 */
@Entity
@Table(name = "address")
public class Address extends BaseEntity {

    @Constraints.Required
    private String street;
    @Constraints.Required
    private String code;
    @Constraints.Required
    private String city;
    private String state;
    @Constraints.Required
    private String country;
    @Enumerated(EnumType.STRING)
    private Category category;
    private int preference;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPreference() {
        return preference;
    }

    public void setPreference(int preference) {
        this.preference = preference;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", code='" + code + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", category=" + category +
                ", preference=" + preference +
                "} " + super.toString();
    }

    public enum Category {
        HOME,
        WORK,
        BILLING
    }
}
