
package com.mycompany.registerlogin;
import java.util.Scanner;
public class Registration {
    
    Scanner input = new Scanner(System.in);
   
    String name;
    String username;
    String password;
    String cellphone;

    public void registerUser() {

        System.out.println("Enter your name:");
        name = input.nextLine();

        System.out.println("Enter username:");
        username = input.nextLine();

        System.out.println("Enter password:");
        password = input.nextLine();

        System.out.println("Enter cellphone number:");
        cellphone = input.nextLine();

        System.out.println("Registration successful!");
    }
}
