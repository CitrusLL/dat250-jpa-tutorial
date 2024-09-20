package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "addresses")
    private Set<Customer> residents = new HashSet<>();
    // Type set because otherwise tests failed :(( 

    private String street;
    private Integer number;

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public Set<Customer> getOwners() {
        return residents;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void addOwner(Customer resident) {
        this.residents.add(resident);
    }
}
