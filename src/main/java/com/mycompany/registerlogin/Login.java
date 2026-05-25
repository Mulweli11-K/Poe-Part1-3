/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerlogin;

/**
 *
 * @author Student
 */
import java.util.Scanner;


public class Login {
   
    private Registration reg;

    public Login(Registration reg) {
        this.reg = reg;
    }

    // RETURNS TRUE OR FALSE
    public boolean loginUser() {

        Scanner input = new Scanner(System.in);

        String usernameInput;
        String passwordInput;
        String cellphoneInput;

        System.out.println("Enter Registered Username:");
        usernameInput = input.nextLine();

        System.out.println("Enter Registered Password:");
        passwordInput = input.nextLine();

        System.out.println("Enter Registered Cellphone Number:");
        cellphoneInput = input.nextLine();

        if (usernameInput.equals(reg.username) &&
            passwordInput.equals(reg.password) &&
            cellphoneInput.equals(reg.cellphone)) {

            System.out.println(
                    "Login Successful\nHello "
                    + reg.name
                    + ", the System welcomes you");

            return true;

        } else {

            System.out.println(
                    "Login Failed!\nIncorrect details.");

            return false;
        }
    }
}
