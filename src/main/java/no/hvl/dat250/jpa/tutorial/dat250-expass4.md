# Task 4

## Exp. 1 - Setup
I think it all worked as intended

## Exp. 2 - Establish relationships
see files

: The questions are kinda ambigious
### Q1: 
wdym how/when?

### Q2:
Creating a table matching that of customer

```SQL
CREATE TABLE Customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- The relationships cannot be modeled as lists within Customer
-- So we need discreete relationship tables

CREATE TABLE Customer_Address (
    customer_id BIGINT,
    address_id BIGINT,

    PRIMARY KEY (customer_id, address_id),
    FOREIGN KEY (customer_id)   REFERENCES Customer(id) ON DELETE CASCADE,
    FOREIGN KEY (address_id)    REFERENCES Address(id) ON DELETE CASCADE
);


CREATE TABLE Customer_CreditCard (
    customer_id BIGINT,
    creditcard_id BIGINT,

    PRIMARY KEY (customer_id, creditcard_id),
    FOREIGN KEY (customer_id)   REFERENCES Customer(id) ON DELETE CASCADE,
    FOREIGN KEY (creditcard_id) REFERENCES CreditCard(id) ON DELETE CASCADE
);

```

### Q3:
I edited the persistence.xml file to have show_sql: True
And added the java classes with their path using <class>

I got all the tables listed out as SQL in the terminal.

I do not really know what expectations i had. 
But i expected that you had to explicitly define primary and foreign keys within the tables themselves.

There were also a lot of hibernate expressions with something about constraints and foregin keys.

The execution would also fail because of some TODO refferances in main. 

