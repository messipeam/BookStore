/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author USER
 */
public class menuBooks {

    public static void main (String[] args) {
        ListOfBooks bookstore = new ListOfBooks();
        Scanner input = new Scanner(System.in);
        int select;
        String menuList = "\n\t: BookStore :\n\n"
            + "1.Add new books to stock\n"
            + "2.Sell a books in stock\n"
            + "3.Add Quantity a books\n"
            + "4.List all the information about the books in stock\n"
            + "5.Print out the total amount and total income of the bookstore\n"
            + "6.Restore BookStore\n"
            + "7.EXIT..\n";
        do {
            System.out.println("\n" + menuList);
            System.out.print("Select your option : ");
            select = input.nextInt();
            switch (select) {
                case 1:
                    if (bookstore.getTotalBook() <= 9) {
                        System.out.print("\nEnter a title of book : ");
                        String title = input.next();
                        System.out.print("Enter a price of book : ");
                        double price = input.nextDouble();
                        System.out.print("Enter a quantity of book : ");
                        int quantity = input.nextInt();
                        Book book = new Book(title, price, quantity);
                        bookstore.addNewBook(book);
                        System.out.println("--------------------------\nbook is already in stock.");
                    } else {
                        System.out.println("--------------------------\nSorry can't add book, The space is not enough.");
                    }
                    break;
                case 2:
                    System.out.println("\nSelling books :");
                    System.out.print("Enter a title want to sell : ");
                    String s_title = input.next();
                    System.out.print("Enter a quantity : ");
                    int s_quantity = input.nextInt();
                    bookstore.sellBook(s_title, s_quantity);
                    if (bookstore.getCheckStock() == true) {
                        System.out.println("--------------------------\nbooks is sold.\nAmount received : " + bookstore.getTotalReceieve() + " baht");           
                    }      
                    break;
                case 3:
                    System.out.println("\n\t: Add Quantity a books : \n");
                    System.out.print("Enter a title your want to add quantity : ");
                    String a_title = input.next();
                    System.out.print("Enter amount of quantity your want to add : ");
                    int a_quantity = input.nextInt();
                    bookstore.addBookQuantity(a_title, a_quantity);
                    System.out.println("---------------------------\nQuantity added successfully\n ");                          
                    break;
                case 4:
                    System.out.println("\n\t: List information of books : \n");
                    bookstore.listBooks();
                    break;
                case 5:
                    System.out.println("\nTotal Amount : " + bookstore.getTotalAmount() + " books");
                    System.out.println("\nTotal Income : " + bookstore.getTotalIncome() + " baht");
                    break;
                case 6:
                    System.out.println("------------------------------\nBookStore has been restore.");
                    bookstore.restore();
                    break;
            }
            
        } while (select != 7);

    }


  
}
