package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.ArrayList;
import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "bank")
    private Collection<CreditCard> ownedCards = new ArrayList<>();

    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<CreditCard> getOwnedCards() {
        return ownedCards;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Adder for ownedCards
    public void addCreditCard(CreditCard creditCard) {
        ownedCards.add(creditCard);
        creditCard.setOwningBank(this);
    }
}
