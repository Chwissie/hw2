package co2123.hw2.model;

import java.util.List;

public class Bakery {
    private int ID;
    private String address;
    private List<Bread> breads;
    private Bread newest;

    public int getID() {return ID;}
    public String getAddress() {return address;}
    public List<Bread> getBreads() {return breads;}
    public Bread getNewest() {return newest;}

    public void setID(int ID) {this.ID = ID;}
    public void setAddress(String address) {this.address = address;}
    public void setBreads(List<Bread> breads) {this.breads = breads;}
    public void setNewest(Bread newest) {this.newest = newest;}




}