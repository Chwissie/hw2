package co2123.hw2.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Bakery {
    @Id
    private int id;
    private String address;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Bread> breads;
    @ManyToOne
    private Bread newest;

    public int getID() {return id;}
    public String getAddress() {return address;}
    public List<Bread> getBreads() {return breads;}
    public Bread getNewest() {return newest;}

    public void setID(int ID) {this.id = ID;}
    public void setAddress(String address) {this.address = address;}
    public void setBreads(List<Bread> breads) {this.breads = breads;}
    public void setNewest(Bread newest) {this.newest = newest;}

    public String toString(){
        return id + " " + address + " " + breads + " " + newest;
    }


}