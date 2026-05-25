/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerlogin;

/**
 *
 * @MULWELI
 */
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
