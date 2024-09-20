package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "bank")
    private Set<CreditCard> ownedCards = new HashSet<>();
    // Type set because otherwise tests failed :((


    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<CreditCard> getOwnedCards() {
        return ownedCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Adder for ownedCards
    public void addCreditCard(CreditCard creditCard) {
        ownedCards.add(creditCard);
    }
}
