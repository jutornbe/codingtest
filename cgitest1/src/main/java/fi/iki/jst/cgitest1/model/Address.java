package fi.iki.jst.cgitest1.model;

import javax.validation.constraints.*;

public class Address {

    @NotEmpty(message = "Street address is required.")
    private String streetAddress;

    @Pattern(regexp = "\\d{5}", message = "Zip code must consist of exactly 5 digits")
    private String zipCode;

    @NotEmpty(message = "Postal district is required")
    private String postalDistrict;

    @NotEmpty(message = "Country is required")
    private String country;

    // Constuctor
    public Address (String streetAddress,
        String zipCode,
        String postalDistrict,
        String country) {

        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.postalDistrict = postalDistrict;
        this.country = country;
    }

    // Getters & Setters
    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPostalDistrict() {
        return postalDistrict;
    }
    public void setPostalDistrict (String postalDistrict) {
        this.postalDistrict = postalDistrict;
    }

    public String getCountry() {
        return country;        
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address copy() {
        return new Address(streetAddress, zipCode, postalDistrict, country);
    }

    // Checks if address is valid:
    // Not implemented. Returns always true.
    public boolean isValidAddress() {
        return true;
    }

    // Compare themselves to other domain objects of the same type
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        if (!streetAddress.equals(address.streetAddress)) return false;
        if (!zipCode.equals(address.zipCode)) return false;
        if (!postalDistrict.equals(address.postalDistrict)) return false;
        if (!country.equals(address.country)) return false;
        return true; 
    }

    // Facilitate other objects that choose to print or display them
    public String toString() {
        return "Address{" +
            "streetAddress='" + streetAddress + '\'' +
            ", zipCode='" + zipCode + '\'' +
            ", postalDistrict='" + postalDistrict + '\'' +
            ", country='" + country + "'}";
    }
}   
