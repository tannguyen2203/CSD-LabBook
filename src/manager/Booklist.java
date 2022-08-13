/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import dao.TextFile;
import dto.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import myValidation.validation;

/**
 *
 * @author duyta
 */
public class Booklist {

    ArrayList<Book> list = new ArrayList<>();

    public boolean addBook(Book book) {
        return list.add(book);
    }

    public boolean dupplicate(String isbn) {
        for (Book book : list) {
            if (book.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    public Book findBook(String isbn) {
        for (Book book : list) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    } 
    
       public Book findBookbyName(String title) {
        for (Book book : list) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
    

    public boolean updateBook(String isbn) {
        int choice;
        boolean tieptuc = false;
        String newisbn = "", newtitle = "";
        double newprice = 1;
        Scanner sc = new Scanner(System.in);
        Book result = findBook(isbn);
        do {
            System.out.println("1.Update Title");
            System.out.println("2.Update Price");
            System.out.println("3.Update All");
            System.out.println("Other to Exit");
            System.out.print("You choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    do {
                        try {
                            do {
                                sc = new Scanner(System.in);
                                System.out.print("Input Title: ");
                                newtitle = sc.nextLine();
                                validation.checkString(newtitle, "^[a-zA-Z0-9]+(?!\\s).+");
                            } while (newtitle.length() > 20);
                            tieptuc = false;
                        } catch (Exception event) {
                            if (event.getMessage() != null) {
                                System.out.println(event.getMessage());
                            }
                            tieptuc = true;
                        }
                    } while (tieptuc);
                    result.setTitle(newtitle);
                    break;
                case 2:
                    do {
                        try {
                            do {
                                sc = new Scanner(System.in);
                                System.out.print("Input Price: ");
                                System.out.println("Price >0 ");
                                newprice = sc.nextDouble();
                                if (newprice <= 0 || newprice > 10000000) {
                                    System.out.println("Please input value > 0");
                                }
                                tieptuc = false;
                            } while (newprice <= 0 || newprice > 10000000);
                        } catch (Exception event) {
                            System.out.println("Please try again");
                            tieptuc = true;
                        }
                    } while (tieptuc);
                    result.setPrice(newprice);
                    break;
                case 3:
                    do {
                        try {
                            do {
                                sc = new Scanner(System.in);
                                System.out.print("Input Title: ");
                                newtitle = sc.nextLine();
                                validation.checkString(newtitle, "^[a-zA-Z0-9]+(?!\\s).+");
                            } while (newtitle.length() > 20);
                            tieptuc = false;
                        } catch (Exception event) {
                            if (event.getMessage() != null) {
                                System.out.println(event.getMessage());
                            }
                            tieptuc = true;
                        }
                    } while (tieptuc);
                    result.setTitle(newtitle);

                    do {
                        try {
                            do {
                                sc = new Scanner(System.in);
                                System.out.print("Input Price: ");
                                System.out.println("Price >0 ");
                                newprice = sc.nextDouble();
                                if (newprice <= 0 || newprice > 1000000) {
                                    System.out.println("Please input value > 0");
                                }
                                tieptuc = false;
                            } while (newprice <= 0);
                        } catch (Exception event) {
                            System.out.println("Please try again");
                            tieptuc = true;
                        }
                    } while (tieptuc);
                    result.setPrice(newprice);
                    break;

                default:
                    break;
            }
        } while (choice < 4);
        return true;
    }

    public boolean removeBook(String isbn) {
        Book result = findBook(isbn);
        return list.remove(result);
    }

    public void exportBookList() {
        TextFile.writeFileBook(list);
    }

    public void importBookList() {
        list = TextFile.loadFileBook();
    }

    public void outputList() {
        System.out.printf("| %-12s| %-24s| %-12s| %-12s \n", "ISBN", "Title", "Price", "AuthorID");
        for (Book book : list) {
            book.outputBook();
        }
    }

    public ArrayList<Book> getList() {
        return list;
    }

}
