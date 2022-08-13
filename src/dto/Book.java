/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.ArrayList;
import java.util.Scanner;
import myValidation.validation;

/**
 *
 * @author duyta
 */
public class Book {

    private String isbn;
    private String title;
    private double price;
    private String authorID;

    public Book(String isbn, String title, double price, String authorID) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.authorID = authorID;
    }

    public Book() {
        isbn = "";
        title = "";
        price = 1;
        authorID = "";
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public void inputBook(ArrayList<Author> authorList) {
        Scanner sc = new Scanner(System.in);
        boolean tieptuc = false;
        int count = 0, choice = 0;
        do {
            try {
                do {
                    sc = new Scanner(System.in);
                    System.out.println("Input ISBN: ");
                    System.out.println("Format:ISBN****(number)");
                    System.out.println("Ex:ISBN123,...");
                    isbn = sc.nextLine().toUpperCase().trim();
                    validation.checkString(isbn, "^ISBN[0-9]{3}");
                } while (isbn.length() > 20);
                tieptuc = false;
            } catch (Exception event) {
                if (event.getMessage() != null) {
                    System.out.println(event.getMessage());
                }
                tieptuc = true;
            }
        } while (tieptuc);

        do {
            try {
                do {
                    sc = new Scanner(System.in);
                    System.out.println("Input Title: ");
                    title = sc.nextLine().trim();
                    validation.checkString(title, "^[a-zA-Z]+(?!\\s).+$");
                } while (title.length() > 40);
                tieptuc = false;
            } catch (Exception event) {
                if (event.getMessage() != null) {
                    System.out.println(event.getMessage());
                }
                tieptuc = true;
            }
        } while (tieptuc);

        do {
            try {
                do {
                    sc = new Scanner(System.in);
                    System.out.print("Input Price ");
                    System.out.println("Price >0 or <  10000000");
                    price = sc.nextDouble();
                    if (price <= 0 || price > 10000000) {
                        System.out.println("Please input value > 0 or < 10000000");
                    }
                    tieptuc = false;
                } while (price <= 0 || price > 10000000);
            } catch (Exception event) {
                System.out.println("Please try again");
                tieptuc = true;
            }
        } while (tieptuc);

        System.out.println("\nAuthor list: ");
        System.out.printf("%-7s|%-20s|%12s\n", "STT", "AUTHOR NAME", "AUTHOR ID");
        for (Author author : authorList) {
            System.out.printf("%-7s",++count);
            author.outputAuthor();
        }
        do {
            try {
                System.out.println("Dont input anything except NUMBER, and just only choose value from 1 to 10: ");
                sc = new Scanner(System.in);
                System.out.print("Choose your Author: ");
                choice = sc.nextInt();
                validation.checkInt(choice, 1, 10);
                tieptuc = false;
            } catch (Exception event) {
                if (event.getMessage() != null) {
                    System.out.println(event.getMessage());
                } else {
                    System.out.println("System wrong! Just only for Integer number");
                }
                tieptuc = true;
            }
            System.out.println();
        } while (tieptuc);
        authorID = authorList.get(choice - 1).getAuthorID();
    }

    public void outputBook() {
        System.out.printf("| %-12s| %-24s| %-12s| %-12s \n", isbn, title, price, authorID);
    }

    @Override
    public String toString() {
       return isbn + "-" + title + "-" + price + "-" + authorID;
    }
 
}
