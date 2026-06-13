

package com.mycompany.registerlogin;
import java.util.Scanner;
public class RegisterLogin {

    public static void main(String[] args) {

  Scanner input = new Scanner(System.in);

    //registration
    Registration reg = new Registration();
    reg.registerUser();

    //login
    Login login = new Login(reg);

    boolean loggedIn = login.loginUser();

    //loop for login
    while (!loggedIn) {

        System.out.println("Login failed! Please try again.");
        loggedIn = login.loginUser();
    }

    //quickchat system
    MessageManager manager = new MessageManager();

    System.out.println("Welcome to QuickChat");
    System.out.println("How many messages would you like to send?");

    int totalMessages = Integer.parseInt(input.nextLine());
    int sentMessages = 0;

    while (true) {

        System.out.println("""
                
                ===== QUICKCHAT MENU =====
                
                1. Send Messages
                2. Show Stored Messages
                3. Search By Message ID
                4. Search By Recipient
                5. Delete Message By Hash
                6. Display Longest Stored Message
                7. Display Report
                8. Quit
                """);

        int option = Integer.parseInt(input.nextLine());

        switch (option) {

            //send message
            case 1:

                for (int i = 1; i <= totalMessages; i++) {

                    System.out.println("Enter recipient number using format (+27831234567)");
                    String recipient = input.nextLine();

                    System.out.println("Enter your message");
                    String text = input.nextLine();

                    Message msg = new Message(i, recipient, text);

                    //validate recipient
                    if (!msg.checkRecipientCell()) {

                        System.out.println("Cell phone number incorrectly formatted.");
                        continue;
                    }

                    //validate message length
                    if (!msg.checkMessageLength()) {

                        System.out.println("Please enter a message less than 250 characters.");
                        continue;
                    }

                    System.out.println("""
                            
                            Choose an option:
                            
                            1. Send Message
                            2. Disregard Message
                            3. Store Message
                            """);

                    int choice = Integer.parseInt(input.nextLine());

                    switch (choice) {

                        //send
                        case 1:

                            manager.addMessage(msg, "Sent");

                            System.out.println("Message successfully sent!\n");
                            System.out.println(msg.printMessage());

                            sentMessages++;
                            break;

                        //disregard
                        case 2:

                            System.out.println("Message disregarded.");
                            break;

                        //store
                        case 3:

                            manager.addMessage(msg, "Stored");

                            System.out.println("Message successfully stored.");
                            break;

                        default:

                            System.out.println("Invalid option.");
                    }
                }

                break;

            // display stored messages
            case 2:

                System.out.println(manager.displayStoredMessages());
                break;

            //search by message id
            case 3:

                System.out.println("Enter Message ID:");
                String id = input.nextLine();

                System.out.println(manager.searchByMessageID(id));
                break;

            //search by recipient
            case 4:

                System.out.println("Enter Recipient:");
                String recipient = input.nextLine();

                System.out.println(manager.searchByRecipient(recipient));
                break;

            // delete message by hash
            case 5:

                System.out.println("Enter Message Hash:");
                String hash = input.nextLine();

                System.out.println(manager.deleteMessageByHash(hash));
                break;

            //display longest message
            case 6:

                System.out.println("Longest Stored Message:");
                System.out.println(manager.displayLongestMessage());
                break;

            //display report
            case 7:

                System.out.println(manager.displayReport());
                break;

            //quit
            case 8:

                System.out.println("Total messages sent: " + sentMessages);
                System.out.println("Exiting QuickChat...");

                System.exit(0);
                break;

            default:

                System.out.println("Invalid menu option.");
            }
        }
    }
}