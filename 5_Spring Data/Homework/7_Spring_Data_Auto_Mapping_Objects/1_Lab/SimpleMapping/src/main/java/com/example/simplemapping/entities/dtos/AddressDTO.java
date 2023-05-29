package com.example.simplemapping.entities.dtos;

public class AddressDTO {
    private String country;
    private String city;

    public AddressDTO(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "CreateAddressDTO{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
