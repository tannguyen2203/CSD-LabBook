/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import dao.TextFile;
import dto.Author;
import dto.Book;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author duyta
 */
public class Authorlist {

    ArrayList<Author> list = new ArrayList<>();

    public void importAuthorList() {
        list = TextFile.loadFileAuthor();
    }

    public void outputAuthor() {
        System.out.println("Author List");
        System.out.printf("| %-20s| %-20s \n", "Name", "AuthorID");
        for (Author author : list) {
            author.outputAuthor();
        }
    }

    public Author searchAuthor(String authorId) {
        for (Author author : list) {
            if (author.getAuthorID().equals(authorId)) {
                return author;
            }
        }
        return null;
    }
    
       public Author searchAuthorbyName(String name) {
        for (Author author : list) {
            if (author.getName().equals(name)) {
                return author;
            }
        }
        return null;
    }

    public void deleteAuthor(ArrayList<Book> listBook) {
        Scanner scanner = new Scanner(System.in);
        if (list.size() == 0) {
            System.out.println("no Author now! Cannot remove");
            return;
        } else {
            String flag;
            do {
                int count = 0;
                // thêm hêm xuàm author List
                System.out.print("Input the author Id: ");
                String authorId = scanner.nextLine();
                for (Book book : listBook) {
                    if (book.getAuthorID().equals(authorId)) {
                        count++;
                    }
                }
                if (count > 0) {
                    System.out.println("This author has book! Cannot remove! please Remove book before removing author");
                } else {
                    if (searchAuthor(authorId) == null) {
                        System.out.println("this author does not exist");
                    } else {
                        do {
                            scanner = new Scanner(System.in);
                            System.out.print("Are you sure you want to Remove?(yes/no): ");
                            flag = scanner.nextLine().toLowerCase();
                            if (!flag.equals("yes") && !flag.equals("no")) {
                                System.out.println("\tMust choose yes/no!\n");
                            }
                            if (flag.equals("yes")) {
                                System.out.print("\n");
                            }
                        } while (!flag.equals("yes") && !flag.equals("no"));
                        if (flag.equals("yes")) {
                            list.remove(searchAuthor(authorId));
                            System.out.println("Remove Sucessfully");
                        }
                    }
                }
                do {
                    scanner = new Scanner(System.in);
                    System.out.print("Do you want to continue?(yes/no): ");
                    flag = scanner.nextLine().toLowerCase();
                    if (!flag.equals("yes") && !flag.equals("no")) {
                        System.out.println("\tMust choose yes/no!\n");
                    }
                    if (flag.equals("yes")) {
                        System.out.print("\n");
                    }
                } while (!flag.equals("yes") && !flag.equals("no"));
            } while (flag.equals("yes"));
            exportAuthorList();
        }
    }

    public void exportAuthorList() {
        TextFile.writeAuthor(list);
    }

    public ArrayList<Author> getListAuThor() {
        return list;
    }

}
