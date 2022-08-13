/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Scanner;
import myValidation.validation;

/**
 *
 * @author duyta
 */
public class Author  {


private String authorID;
    private String name;

    public Author(String authorID, String name) {
        this.authorID = authorID;
        this.name = name;
    }

    public Author() {
        authorID = "";
        name = "";
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public void outputAuthor(){
        System.out.printf("| %-20s| %-20s\n", name, authorID);
    }

    @Override
    public String toString() {
        return authorID + "-" + name;
    }
    
}
