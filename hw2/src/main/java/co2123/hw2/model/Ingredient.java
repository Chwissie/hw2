package co2123.hw2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingredient{

    @Id
    private int identifier;
    private int amount;

    @ManyToOne
    @JoinColumn(name = "name")
    private Bread bread;

    public int getIdentifier() {return identifier;}
    public int getAmount() {return amount;}

    public void setIdentifier(int identifier) {this.identifier = identifier;}
    public void setAmount(int amount) {this.amount = amount;}

    public String toString(){
        return identifier + " " + amount;
    }
}