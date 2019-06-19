package model.people;

public class UserAddress {
    String country;
    String city;
    String street;
    String houseNumber;


    public String getStreet() {
        return street;
    }

    public UserAddress withStreet(String street) {
        this.street = street;
        return this;
    }

    public UserAddress withHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public UserAddress withCity(String city) {
        this.city = city;
        return this;
    }

    public UserAddress withCountry(String country) {
        this.country = country;
        return this;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public UserAddress(String streetNew, String houseNumberNew, String cityNew, String counrtyNew) {
        street = streetNew;
        houseNumber = houseNumberNew;
        city = cityNew;
        country = counrtyNew;

    }
}
