

import java.util.Scanner;
/**<h1>Book class</h1>
 * 
 * @author spide
 */
public class Book {
    /**
     * The title of the book
     */
    private String title; 
    /**
     * The price of the book
     */
    private double price;
    /**
     * The quantity of the book
     */
    private int quantity; 
    /**
     * 
     * @param title Set the books title
     * @param price Set the books price
     * @param quantity Set the books quantity
     */
    public Book(String title, double price, int quantity) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }
    /**
     * @return title of the book 
     */
    public String getTitle() {
        return title;
    }
    /**
     * @return price of the book 
     */
    public double getPrice() {
        return price;
    }
    /**
     * @return quantity of the book 
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * 
     * @param amount number of products purchased
     * <p> This method keep a value in quantity to increase the number of products in the stock.</p>
     */
    public void addQuantity(int amount) { 
        quantity += amount;
    }
    /**
     * 
     * @param amount number of products purchased
     * <p> This method will sell a book by decrease quantity. </p>
     */
    public void buy(int amount) { 
        quantity -= amount;
    }
    /**
     * 
     * @return String of title,price,quantity 
     */
    @Override
    public String toString() {
        return "\nTitle : " + title + "   \t" + "Price : " + price + " baht"+"\t" + "InStock : " + quantity + " book"+"\n-----------------------------------------------------";
        
    }

}
