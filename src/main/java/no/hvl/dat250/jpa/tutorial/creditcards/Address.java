package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "addresses")
    private Collection<Customer> residents;

    private String street;
    private Integer number;

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public Collection<Customer> getOwners() {
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
        resident.addAddress(this);
    }
}
