package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.Address;
import no.hvl.dat250.jpa.tutorial.creditcards.Bank;
import no.hvl.dat250.jpa.tutorial.creditcards.CreditCard;
import no.hvl.dat250.jpa.tutorial.creditcards.Customer;
import no.hvl.dat250.jpa.tutorial.creditcards.Pincode;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {

    Customer max = new Customer();
    max.setName("Max Mustermann");

    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);

    max.addAddress(address);
    address.addOwner(max);

    CreditCard c1 = new CreditCard();
    c1.setNumber(12345);
    c1.setBalance(-5000);
    c1.setCreditLimit(-10000);
    CreditCard c2 = new CreditCard();
    c2.setNumber(123);
    c2.setBalance(1);
    c2.setCreditLimit(2000);

    Pincode pin = new Pincode();
    pin.setCode("123");
    pin.setCount(1);

    c1.setPincode(pin);
    c2.setPincode(pin);

    Bank bank = new Bank();
    bank.setName("Pengebank");
    bank.addCreditCard(c1);
    bank.addCreditCard(c2);

    c1.setOwningBank(bank);
    c2.setOwningBank(bank);

    // Persist the objects
    em.persist(max);
    em.persist(address);
    em.persist(c1);
    em.persist(c2);
    em.persist(pin);
    em.persist(bank);
  }
}
