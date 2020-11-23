

import java.util.Scanner;

public class ListOfBooks {

    private Book[] books;
    private int totalBooks = 0;
    private boolean checkstock;
    private double totalReceive = 0;
    private int totalAmount = 0;
    private double totalIncome = 0;

    public ListOfBooks() {
        books = new Book[10];
    }

    public void addNewBook(Book addBook) {
        books[totalBooks] = addBook;
        totalBooks++;
        
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalReceieve() {
        return totalReceive;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getTotalBook() {
        return totalBooks;
    }

    public boolean getCheckStock() {
        return checkstock;
    }

    public void addBookQuantity(String title, int quantity) {
        for (int i = 0; i < totalBooks; i++) {
            if (title.equals(books[i].getTitle())) {
                books[i].addQuantity(quantity);
            }
        }
    }

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

    public void listBooks() {
        if (totalBooks != 0) {
            for (int i = 0; i < totalBooks; i++) {
                System.out.print(books[i].toString());;
            }
        } else {
            System.out.println("Not found book in store.");
        }
    }

    public void restore() {
        totalBooks = 0;
        totalIncome = 0;
        totalAmount = 0;
    }

}
