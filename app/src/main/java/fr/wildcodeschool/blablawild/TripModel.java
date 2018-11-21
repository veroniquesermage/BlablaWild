package fr.wildcodeschool.blablawild;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TripModel {

    String firstName;
    String lastName;
    Date date;
    int price;

    public TripModel (String firstName, String lastName, Date date, int price ){
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.date       = date;
        this.price      = price;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDate() {
        SimpleDateFormat dateNew = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
        return dateNew.format(this.date);
    }
    public int getPrice() {
        return price;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setPrice(int price) {
        this.price = price;
    }

}
