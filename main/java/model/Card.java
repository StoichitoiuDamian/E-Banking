package model;

import java.util.Objects;
import java.util.Random;

public class Card {
    private int id;
    private int idClient;
    private int number;
    private String expDate;
    private String name;
    private int cvv;
    private int val;

    public Card(int id, int idClient,  String expDate, String name, int val) {
        Random rand = new Random();
        this.id = id;
        this.idClient = idClient;
        this.number = rand. nextInt(9000000) + 1000000;
        this.expDate = expDate;
        this.name = name;
        this.cvv = rand. nextInt(900) + 100;
        this.val = val;
    }

    public Card(){} //only for jpa


    public int getId() {
        return id;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getNumber() {
        return number;
    }

    public String getExpDate() {
        return expDate;
    }

    public String getName() {
        return name;
    }

    public int getCvv() {
        return cvv;
    }

    public int getVal() {
        return val;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(this.number, card.number) && Objects.equals(this.cvv, card.cvv);
    }
}
