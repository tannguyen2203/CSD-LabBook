/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Author;
import dto.Book;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;

/**
 *
 * @author duyta
 */
public class TextFile {

    private static final String FILE_NAME = "BookList.dat";
    private static final String FILE_NAME2 = "Author.dat";

    public static void writeFileBook(ArrayList<Book> list) {
        PrintWriter write = null;
        try {
            write = new PrintWriter(FILE_NAME);
            for (Book book : list) {
                write.println(book);
            }
            System.out.println("Saved");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (write != null) {
                    write.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void writeAuthor(ArrayList<Author> list) {
        PrintWriter write = null;
        try {
            write = new PrintWriter(FILE_NAME2);
            for (Author author : list) {
                write.println(author);
            }
            System.out.println("Saved");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (write != null) {
                    write.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static ArrayList<Book> loadFileBook() {
        ArrayList<Book> list = new ArrayList();
        FileReader file = null; // doc du lieu tu file 
        BufferedReader buffer = null;
        try {
            file = new FileReader(FILE_NAME);
            buffer = new BufferedReader(file);
            while (buffer.ready()) {
                String tmp = buffer.readLine();//doc du lieu theo dong bang phuong thuc readLine
                if (tmp != null && !tmp.isEmpty()) {
                    String[] arr = tmp.split("-");//tach chuoi thanh nhung chuoi con 
                    if (arr.length == 4) {
                        Book book = new Book(arr[0], arr[1], parseDouble(arr[2]), arr[3]);
                        list.add(book);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Something wrong");
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
                if (buffer != null) {
                    buffer.close();
                }
            } catch (Exception e) {
                System.out.println("Something wrong");
            }
        }
        return list;
    }
    
        public static ArrayList<Author> loadFileAuthor() {
        ArrayList<Author> list = new ArrayList();
        FileReader file = null; // doc du lieu tu file 
        BufferedReader buffer = null;
        try {
            file = new FileReader(FILE_NAME2);
            buffer = new BufferedReader(file);
            while (buffer.ready()) {
                String tmp = buffer.readLine();//doc du lieu theo dong bang phuong thuc readLine
                if (tmp != null && !tmp.isEmpty()) {
                    String[] arr = tmp.split("-");//tach chuoi thanh nhung chuoi con 
                    if (arr.length == 2) {
                        Author author = new Author(arr[0], arr[1]);
                        list.add(author);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Something wrong");
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
                if (buffer != null) {
                    buffer.close();
                }
            } catch (Exception e) {
                System.out.println("Something wrong");
            }
        }
        return list;
    }
}
