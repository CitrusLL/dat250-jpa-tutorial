package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pinCode;
    private Integer count;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return pinCode;
    }

    public Integer getCount() {
        return count;
    }


    public void setCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
