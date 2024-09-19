package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<Address> addresses;

    @ManyToMany
    private Collection<CreditCard> creditCards;
 
    public String getName() {
        return name;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }

    
    public void addAddress(Address address) {
        this.addresses.add(address);
        address.addOwner(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCreditCard(CreditCard card){
        this.creditCards.add(card);
    }
}
