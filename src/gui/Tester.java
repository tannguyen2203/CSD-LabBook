/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dto.Author;
import dto.Book;
import java.util.Scanner;
import manager.Authorlist;
import manager.Booklist;

/**
 *
 * @author duyta
 */
public class Tester {

    public static void main(String[] args) {
        int choice = 0;
        Book book = null;
        Author author = null;
        Scanner sc = new Scanner(System.in);
        Booklist obj = new Booklist();
        Authorlist oby = new Authorlist();
        boolean isContinue = true;
        obj.importBookList();
        oby.importAuthorList();
        do {
            System.out.println("Welcome to HKT store - @ 2021 by <SE151388 - Nguyen Duy Tan>");
            System.out.println("Select the options below::");
            System.out.println("1.Show list");
            System.out.println("2.Add new book");
            System.out.println("3.Update book");
            System.out.println("4.Delete book");
            System.out.println("5.Search book");
            System.out.println("6.Delete author");
            System.out.println("7.Store data to file");
            System.out.println("Any number - Quit");
            boolean flag;
            do {
                try {
                    sc = new Scanner(System.in);
                    System.out.print("Choose your option : ");
                    choice = sc.nextInt();
                    myValidation.validation.checkValidOption(choice);
                    flag = false;
                } catch (Exception event) {
                    if (event.getMessage() != null) {
                        System.out.println(event.getMessage());
                    } else {
                        System.out.println("System Error! please choose the right option");
                    }
                    flag = true;
                }
            } while (flag);
            switch (choice) {
                case 1:
                    int choicelist = 0;
                    do {
                        System.out.println("1.Show Book's list");
                        System.out.println("2.Show Author's list");
                        System.out.println("3.Exit");
                        do {
                            try {
                                sc = new Scanner(System.in);
                                System.out.print("Choose your option : ");
                                choicelist = sc.nextInt();
                                myValidation.validation.checkValidOption(choicelist);
                                flag = false;
                            } catch (Exception event) {
                                if (event.getMessage() != null) {
                                    System.out.println(event.getMessage());
                                } else {
                                    System.out.println("System Error! please choose the right option");
                                }
                                flag = true;
                            }
                        } while (flag);
                        switch (choicelist) {
                            case 1:
                                obj.outputList();
                                break;
                            case 2:
                                oby.outputAuthor();
                                break;
                        }
                    } while (choicelist < 3);
                    break;
                case 2:
                    sc = new Scanner(System.in);
                    String flag1 = "";
                    do {
                        Book tmp = new Book();
                        tmp.inputBook(oby.getListAuThor());
                        if (obj.dupplicate(tmp.getIsbn())) {
                            System.out.println("Add failed! Book has already existed");
                        } else {
                            obj.addBook(tmp);
                            System.out.println("Add successfully");
                        }
                        do {
                            sc = new Scanner(System.in);
                            System.out.print("Do you want to continue?(yes/no): ");
                            flag1 = sc.nextLine().toLowerCase();
                            if (!flag1.equals("yes") && !flag1.equals("no")) {
                                System.out.println("\tMust choose yes/no!\n");
                            }
                            if (flag1.equals("yes")) {
                                System.out.print("\n");
                            }
                        } while (!flag1.equals("yes") && !flag1.equals("no"));
                    } while (flag1.equals("yes"));
                    break;
                case 3:
                    sc = new Scanner(System.in);
                    obj.outputList();
                    System.out.println("Input book to update: ");
                    String findisbn = sc.nextLine();
                    if (obj.findBook(findisbn) != null) {
                        obj.updateBook(findisbn);
                        obj.exportBookList();
                        System.out.println("Update succesful");
                    } else {
                        System.out.println("Can't find");
                    }
                    break;
                case 4:
                    sc = new Scanner(System.in);
                    obj.outputList();
                    System.out.println("Input book to delete");
                    String deletebook = sc.nextLine();
                    if (obj.findBook(deletebook) != null) {
                        obj.removeBook(deletebook);
                        obj.exportBookList();
                        System.out.println("Remove succesful");
                    } else {
                        System.out.println("Can't find");
                    }
                    break;
                case 5:
                    int choicesearch = 0;
                    do {
                        System.out.println("1.Search by book name");
                        System.out.println("2.Search by author name");
                        System.out.println("3.Exit");
                        do {
                            try {
                                sc = new Scanner(System.in);
                                System.out.print("Choose your option : ");
                                choicesearch = sc.nextInt();
                                myValidation.validation.checkValidOption(choicesearch);
                                flag = false;
                            } catch (Exception event) {
                                if (event.getMessage() != null) {
                                    System.out.println(event.getMessage());
                                } else {
                                    System.out.println("System Error! please choose the right option");
                                }
                                flag = true;
                            }
                        } while (flag);
                        switch (choicesearch) {
                            case 1:
                                sc = new Scanner(System.in);
                                System.out.println("Input book name: ");
                                String bookname = sc.nextLine();
                                if (obj.findBookbyName(bookname) != null) {
                                    obj.findBookbyName(bookname).outputBook();
                                } else {
                                    System.out.println("not found");
                                }
                                break;
                            case 2:
                                sc = new Scanner(System.in);
                                System.out.println("Input author name: ");
                                String authorname = sc.nextLine();
                                if(oby.searchAuthorbyName(authorname)!= null){
                                    oby.searchAuthorbyName(authorname).outputAuthor();
                                }else{
                                    System.out.println("not found");
                                }
                                break;
                        }
                    } while (choicesearch < 3);
                    sc = new Scanner(System.in);
                    System.out.println("Input book to search");
                    String searchbook = sc.nextLine();
                    if (obj.findBook(searchbook) != null) {
                        obj.findBook(searchbook).outputBook();
                    } else {
                        System.out.println("Can't find");
                    }
                    break;
                case 6:
                    oby.outputAuthor();
                    oby.deleteAuthor(obj.getList());
                    break;
                case 7:
                    obj.exportBookList();
                    break;
                default:
                    isContinue = false;
                    break;
            }
        } while (isContinue);
    }

}
