package de.kisters.app;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ak on 14.02.2017.
 */
@Data
@Entity
@Table(name= "address")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String street;
    private String house;
    private String zip;
    private String city;
    private String country;

    public Address(){
        super();
    }


    public Address(String street, String house, String zip, String city, String country) {
        super();
        this.street = street;
        this.house = house;
        this.zip = zip;
        this.country = country;
    }

}
