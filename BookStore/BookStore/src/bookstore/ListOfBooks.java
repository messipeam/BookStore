package bookstore;

import java.util.Scanner;

public class ListOfBooks {

    private Book[] books; // อาเรย์เก็บลิสหนังสือ
    private int totalBooks; //จำนวนหนังสือทั้งหมด
    private boolean checkstock;
    private double totalReceive = 0;
    private int totalAmount = 0;
    private double totalIncome = 0;

    public ListOfBooks() {
        books = new Book[100];
        totalBooks = 0;
    }

    public void addNewBook(Book addBook) { //เพิ่มชื่อหนังสือ
        books[totalBooks] = addBook;
        totalBooks++;
        System.out.println("\nbook is already in stock.");

    }

    public void addBookQuantity(String title, int quantity) { // เพิ่มจำนวนหนังสือ
        for (int i = 0; i < totalBooks; i++) {
            if (title.equals(books[i].getTitle())) {
                books[i].addQuantity(quantity);
                System.out.println("Quantity added successfully");

            }

        }
    }

    public boolean checkInStock(String title, int quantity) {
        for (int i = 0; i < totalBooks; i++) {
            if (title.equals(books[i].getTitle())) {
                if (quantity > books[i].getQuantity() && books[i].getQuantity() != 0) {
                    System.out.println("\nSorry..." + title + " not enough books to buy");
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

    public boolean sellBook(String title, int quantity) { //ขายหนังสือ - ลดจำนวน quantity ลง
        boolean checkstock = checkInStock(title, quantity);
        if (checkstock) {
            for (int i = 0; i < totalBooks; i++) {
                if (title.equals(books[i].getTitle())) {
                    books[i].buy(quantity);
                    totalAmount += quantity;
                    totalReceive = ((books[i].getPrice()) * quantity);
                    totalIncome += totalReceive;
                    System.out.println("\nbooks is sold.\nAmount received : " + totalReceive);
                }
            }
        }
        return checkstock;
    }

    public void listTitles() { // แสดง list ของชื่อหนังสือ (เฉพาะชื่อ)
        if (totalBooks != 0) {
            for (int i = 0; i < totalBooks; i++) {
                System.out.println(books[i].getTitle());

            }
        } else {
            System.out.println("Not found book in store.");
        }

    }

    public void listBooks() {// แสดง list ของชื่อหนังสือ ราคาและปริมาณที่มีอยู่ในร้าน
        if (totalBooks != 0) {
            for (int i = 0; i < totalBooks; i++) {
                System.out.print(books[i].toString());;
            }
        } else {
            System.out.println("Not found book in store.");
        }
    }

    public void getIncome() {
        System.out.println("\nTotal income : " + totalIncome + "  \tAmount : " + totalAmount);

    }

}
