package fi.iki.jst.cgitest1.model;

import javax.validation.constraints.*;
import javax.validation.Valid;

public class Person {
    private long id;

    @Pattern(regexp = "^[0-9]{6}[-+aA][0-9]{3}[0-9a-zA-Z]$", message = "Invalid personal identification number")
    private String personalIdentificationNumber;

    @NotEmpty(message = "Surname is required")
    private String surName;

    @NotEmpty(message = "First names are required")
    private String firstNames;

    @Email(message = "Invalid email address")
    private String email;

    @NotEmpty(message = "Telephone is required")
    private String telephone;

    @Valid
    private Address address;

    // Constructor
    public Person(long id,
        String personalIdentificationNumber,
        String surName,
        String firstNames,
        String email,
        String telephone,
        String streetAddress,
        String zipCode,
        String postalDistrict,
        String country) {
            this.id = id;
            this.personalIdentificationNumber = personalIdentificationNumber;
            this.surName = surName;
            this.firstNames = firstNames;
            this.email = email;
            this.telephone = telephone;
            this.address = new Address(streetAddress, zipCode, postalDistrict, country);
        }

    // Getters & Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPersonalIdentificationNumber()  {
        return this.personalIdentificationNumber;
    }

    public void setPersonalIdentificationNumber(String personalIdentificationNumber) {        
        this.personalIdentificationNumber = personalIdentificationNumber;
    }

    public String getSurName() {
        return surName;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }
    public String getFirstNames() {
        return firstNames;
    }
    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStreetAddress() {
        return address.getStreetAddress();
    }
    public void setStreetAddress(String streetAddress) {
        address.setStreetAddress(streetAddress);
    }

    public String getZipCode() {
        return address.getZipCode();
    }
    public void setZipCode(String zipCode) {
        address.setZipCode(zipCode);
    }

    public String getPostalDistrict() {
        return address.getPostalDistrict();
    }
    public void setPostalDistrict(String postalDistrict) {
        address.setPostalDistrict(postalDistrict);
    }

    public String getCountry() {
        return address.getCountry();
    }
    public void setCountry(String country) {
        address.setCountry(country);
    }

    // copy themselves
    public Person copy() {
        return new Person(id,
            personalIdentificationNumber,
            surName,
            firstNames,
            email,
            telephone,
            address.getStreetAddress(),
            address.getZipCode(),
            address.getPostalDistrict(),
            address.getCountry()
        );
    }

    // example method for maintaining business logic

    // Is person adult?
    public boolean isAdult() {
        // Not implemented, returns always true
        return true;
    }

    // Compare themselves to other domain objects of the same type
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if (id != person.id) return false;
        if (!personalIdentificationNumber.equals(person.personalIdentificationNumber)) return false;
        if (!surName.equals(person.surName)) return false;
        if (!firstNames.equals(person.firstNames)) return false;
        if (!email.equals(person.email)) return false;
        if (!telephone.equals(person.telephone)) return false;
        if (!address.equals(person.address)) return false;
        return true;
    }

    // Facilitate other objects that choose to print or display them
    public String toString() {
        return "Person{" +
            "id=" + id +
            ", personalIdentificationNumber='" + personalIdentificationNumber + '\'' +
            ", surName='" + surName + '\'' +
            ", firstNames='" + firstNames + '\'' + 
            ", email='" + email + '\'' +
            ", telephone='" + telephone + '\'' +
            ", address='" + address + "'}";
    }
}
