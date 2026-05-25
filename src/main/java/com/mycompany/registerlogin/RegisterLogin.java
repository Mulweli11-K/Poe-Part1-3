/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registerlogin;

/**
 *
 * @author Student
 */

    
import java.util.Scanner;

public class RegisterLogin {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        // =========================
        // REGISTRATION
        // =========================
        Registration reg = new Registration();

        reg.registerUser();

        // =========================
        // LOGIN
        // =========================
        Login login = new Login(reg);

        boolean loggedIn = login.loginUser();

        // =========================
        // LOGIN LOOP
        // =========================
        while (!loggedIn) {

            System.out.println(
                    "Login failed! Please try again."
            );

            loggedIn = login.loginUser();
        }

        // =========================
        // QUICKCHAT
        // =========================
        System.out.println("Welcome to QuickChat");

        System.out.println(
                "How many messages would you like to send?"
        );

        int totalMessages = Integer.parseInt(
                input.nextLine()
        );

        int sentMessages = 0;

        // STORE RECENT MESSAGES
        String recentMessages = "";

        while (true) {

            System.out.println(
                    """
                    ===== QUICKCHAT MENU =====
                      
                    1. Send Messages
                    2. Show Recently Sent Messages(Coming Soon feature is still in development)
                    3. Quit
                    """
            );

            String menu = input.nextLine();

            int option = Integer.parseInt(menu);

            switch (option) {

                // =========================
                // SEND MESSAGE
                // =========================
                case 1:

                    for (int i = 1; i <= totalMessages; i++) {

                        System.out.println(
                                "Enter recipient number use this format (+27831234567)"
                        );

                        String recipient =
                                input.nextLine();

                        System.out.println(
                                "Enter your message"
                        );

                        String text =
                                input.nextLine();

                        Message msg =
                                new Message(i, recipient, text);

                        // VALIDATE NUMBER
                        if (!msg.checkRecipientCell()) {

                            System.out.println(
                                    "Cell phone number incorrectly formatted.");

                        }

                        // VALIDATE MESSAGE LENGTH
                        else if (!msg.checkMessageLength()) {

                            System.out.println(
                                    "Please enter a message less than 250 characters.");

                        }

                        else {

                            System.out.println(
                                    """
                                    Choose an option:
                                      
                                    1. Send Message
                                    2. Disregard Message
                                    3. Store Message
                                    """
                            );

                            String choiceInput =
                                    input.nextLine();

                            int choice =
                                    Integer.parseInt(choiceInput);

                            switch (choice) {

                                // SEND
                                case 1:

                                    System.out.println(
                                            "Message successfully sent!\n\n"
                                            + msg.printMessage()
                                    );

                                    recentMessages +=
                                            msg.printMessage() + "\n";

                                    sentMessages++;

                                    break;

                                // DELETE
                                case 2:

                                    System.out.println(
                                            "Message disregarded."
                                    );

                                    break;

                                // STORE
                                case 3:

                                    System.out.println(
                                            "Message successfully stored."
                                    );

                                    recentMessages +=
                                            msg.printMessage() + "\n";

                                    break;

                                default:

                                    System.out.println(
                                            "Invalid option."
                                    );
                            }
                        }
                    }

                    break;

                // =========================
                // SHOW RECENT MESSAGES
                // =========================
                case 2:

                    if (recentMessages.isEmpty()) {

                        System.out.println(
                                "No messages stored yet."
                        );

                    } else {

                        System.out.println(
                                recentMessages
                        );
                    }

                    break;

                // =========================
                // QUIT
                // =========================
                case 3:

                    System.out.println(
                            "Total messages sent: "
                            + sentMessages
                    );

                    System.exit(0);

                    break;

                default:

                    System.out.println(
                            "Invalid menu option."
                    );
            }
        }
    }
}








