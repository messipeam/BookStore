

import java.util.Scanner;

public class Book {

    private String title; 
    private double price; 
    private int quantity; 

    public Book(String title, double price, int quantity) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int amount) { 
        quantity += amount;
    }

    public void buy(int amount) { 
        quantity -= amount;
    }

    @Override
    public String toString() {
        return "\nTitle : " + title + "   \t" + "Price : " + price + " baht"+"\t" + "InStock : " + quantity + " book"+"\n-----------------------------------------------------";

    }

}
