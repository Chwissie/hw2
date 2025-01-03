package co2123.hw2.model;

import jakarta.persistence.*;

@Entity
public class Ingredient{

    @Id
    @GeneratedValue
    private int identifier;
    private int amount;

    public int getIdentifier() {return identifier;}
    public int getAmount() {return amount;}

    public void setIdentifier(int identifier) {this.identifier = identifier;}
    public void setAmount(int amount) {this.amount = amount;}

    @Override
    public String toString() {
        return "Ingredient{" +
                "identifier=" + identifier +
                ", amount=" + amount +
                '}';
    }
}