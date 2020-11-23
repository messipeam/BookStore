

import java.util.Scanner;
/**<h1>List books</h1>
 * 
 * @author spide
 */
public class ListOfBooks {
    /**
     * Arrays slot book in bookstore.
     */
    private Book[] books;
    /**
     * The totalBooks of bookstore
     */
    private int totalBooks = 0;
     /**
     * The checkstock of bookstore
     */
    private boolean checkstock;
     /**
     * The totalReceive of bookstore
     */
    private double totalReceive = 0;
     /**
     * The totalAmount of bookstore
     */
    private int totalAmount = 0;
     /**
     * The totalIncome of bookstore
     */
    private double totalIncome = 0;
    /**
     * 
     * <p> Create a number of book slots in store. </p>
     */
    public ListOfBooks() {
        books = new Book[10];
    }
    /**
     * 
     * @param addBook Keep the value of the number of books in the store.
     * <p> This method will increase the number of books gradually up to 10. </p>
     */
    public void addNewBook(Book addBook) {
        books[totalBooks] = addBook;
        totalBooks++;
        
    }
     /**
     * @return totalIncome of the book 
     */
    public double getTotalIncome() {
        return totalIncome;
    }
     /**
     * @return totalReceive of the book 
     */
    public double getTotalReceieve() {
        return totalReceive;
    }
     /**
     * @return totalAmount of the book 
     */
    public int getTotalAmount() {
        return totalAmount;
    }
     /**
     * @return totalBooks of the book 
     */
    public int getTotalBook() {
        return totalBooks;
    }
     /**
     * @return checkstock boolean
     * <p> This method will checkstock if there is a book in the store, it can be sold. </p>
     */
    public boolean getCheckStock() {
        return checkstock;
    }
    /**
     * 
     * @param title get title of book from user.
     * @param quantity get quantity of book from user.
     * <p> This method will add quantity of the book that user choose by check the title of book in store compared to title user choose if it's true will add quantity of the book.</p>
     */
    public void addBookQuantity(String title, int quantity) {
        for (int i = 0; i < totalBooks; i++) {
            if (title.equals(books[i].getTitle())) {
                books[i].addQuantity(quantity);
            }
        }
    }
    /**
     * 
     * @param title get title of book from user.
     * @param quantity get quantity of book from user.
     * @return true when there is enough product in the store.
     * @return false when user want to buy book more than book in store have.
     * @return false when the book out of stock too.
     * <p> This method will check about quantity to sale the book if it not enough books for sale or out of stock they can't sell it. </p>
     */
    public boolean checkInStock(String title, int quantity) {
        for (int i = 0; i < totalBooks; i++) {
            if (title.equals(books[i].getTitle())) {
                if (quantity > books[i].getQuantity() && books[i].getQuantity() != 0) {
                    System.out.println("\nNot enough books for sale.");
                    return false;
                } else if (quantity <= books[i].getQuantity() && books[i].getQuantity() != 0) {
                    return true;
                } else {
                    System.out.println("\nSorry... " + title + " is out of stock.\n");
                    return false;

                }
            }
        }
        return false;
    }
    /**
     * 
     * @param title get title of book from user.
     * @param quantity get quantity of book from user.
     * @return true of checkstock.
     * <p> if there is enough product in the store to sale this method will return checkstock to true for sale books and keep the total number of books sold And keep the total number of books sold ,Total income in the store</p>
     */
    public boolean sellBook(String title, int quantity) {
        checkstock = checkInStock(title, quantity);
        if (checkstock == true) {
            for (int i = 0; i < totalBooks; i++) {
                if (title.equals(books[i].getTitle())) {
                    books[i].buy(quantity);
                    totalAmount += quantity;
                    totalReceive = ((books[i].getPrice()) * quantity);
                    totalIncome += totalReceive;
                }
            }

        }
        return false;
    }
    /**
     * <p> This method will show list of books including the price and the the quantity of books in the store. </p>
     */
    public void listBooks() {
        if (totalBooks != 0) {
            for (int i = 0; i < totalBooks; i++) {
                System.out.print(books[i].toString());;
            }
        } else {
            System.out.println("Not found book in store.");
        }
    }
    /**
     * <p> This method will reset the store to default. </p>
     */
    public void restore() {
        totalBooks = 0;
        totalIncome = 0;
        totalAmount = 0;
    }

}
