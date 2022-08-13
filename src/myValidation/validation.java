/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myValidation;

/**
 *
 * @author duyta
 */
public class validation {

    public static boolean checkString(String input, String pattern) throws Exception {
        if (input == null) {
            throw new Exception("Your Input is empty");
        }
        if (pattern == null) {
            throw new Exception("Your Pattern is null");
        }
        if (!input.matches(pattern)) {
            throw new Exception("Wrong Pattern! Try again");
        }
        return true;
    }
    
    public static boolean checkInt(int value,int min, int max) throws Exception{
        if(value < min || value > max) throw new Exception("Try again! The value has been out of range!");
        return true;
    }
    
    public static boolean checkValidOption(int option) throws Exception {
        if (option < 1) {
            throw new Exception("This option is not in the menu, please choose option again!");
        }
        return true;
    }
}
