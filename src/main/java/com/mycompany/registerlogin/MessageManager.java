
package com.mycompany.registerlogin;
public class MessageManager {
    
//parallel arrays
String[] messageIDs = new String[100];
String[] messageHashes = new String[100];
String[] recipients = new String[100];
String[] messages = new String[100];
String[] statuses = new String[100];

//keeps track of stored messages
int count = 0;

//add a message to the arrays
public String addMessage(Message msg, String status) {

    //check if storage is full
    if (count >= 100) {
        return "Storage full. Cannot add more messages.";
    }

    //store message details
    messageIDs[count] = msg.getMessageID();
    messageHashes[count] = msg.getMessageHash();
    recipients[count] = msg.getRecipient();
    messages[count] = msg.getMessageText();
    statuses[count] = status;

    count++;
    return "Message added successfully.";
}

//display all stored messages
public String displayStoredMessages() {

    String result = "";

    //loop through stored messages
    for (int i = 0; i < count; i++) {

        //only display messages with stored status
        if (statuses[i] != null &&
            statuses[i].equalsIgnoreCase("Stored")) {

            result += "Message ID: " + messageIDs[i]
                    + "\nRecipient: " + recipients[i]
                    + "\nMessage: " + messages[i]
                    + "\nStatus: " + statuses[i]
                    + "\n\n";
        }
    }

    return result.isEmpty()
            ? "No stored messages found."
            : result;
}

//find and display the longest stored message
public String displayLongestMessage() {

    String longest = "";

    //loop through stored messages
    for (int i = 0; i < count; i++) {

        if (statuses[i] != null &&
            statuses[i].equalsIgnoreCase("Stored")) {

            //compare message lengths
            if (messages[i].length() > longest.length()) {
                longest = messages[i];
            }
        }
    }

    return longest.isEmpty()
            ? "No stored messages found."
            : longest;
}

//search for a message using message id
public String searchByMessageID(String id) {

    //loop through all messages
    for (int i = 0; i < count; i++) {

        if (messageIDs[i] != null && messageIDs[i].equals(id)) {

            return "Recipient: " + recipients[i]
                 + "\nMessage: " + messages[i];
        }
    }

    return "Message not found.";
}

//search for messages using recipient number
public String searchByRecipient(String recipient) {

    String result = "";

    //loop through all messages
    for (int i = 0; i < count; i++) {

        if (recipients[i] != null &&
            recipients[i].equalsIgnoreCase(recipient)) {

            result += "Message ID: " + messageIDs[i]
                    + "\nMessage: " + messages[i]
                    + "\n\n";
        }
    }

    return result.isEmpty()
            ? "No messages found."
            : result;
}

//delete a message using its hash
public String deleteMessageByHash(String hash) {

    //search for matching hash
    for (int i = 0; i < count; i++) {

        if (messageHashes[i] != null &&
            messageHashes[i].equals(hash)) {

            // shift remaining records left
            for (int j = i; j < count - 1; j++) {
                messageIDs[j] = messageIDs[j + 1];
                messageHashes[j] = messageHashes[j + 1];
                recipients[j] = recipients[j + 1];
                messages[j] = messages[j + 1];
                statuses[j] = statuses[j + 1];
            }

            count--;
            return "Message successfully deleted.";
        }
    }

    return "Message not found.";
}

//display report of all stored messages
public String displayReport() {

    String report = "";

    //loop through stored messages
    for (int i = 0; i < count; i++) {

        if (statuses[i] != null &&
            statuses[i].equalsIgnoreCase("Stored")) {

            report += "Message ID: " + messageIDs[i]
                    + "\nMessage Hash: " + messageHashes[i]
                    + "\nRecipient: " + recipients[i]
                    + "\nMessage: " + messages[i]
                    + "\nStatus: " + statuses[i]
                    + "\n\n";
        }
    }

    return report.isEmpty()
            ? "No stored messages available."
            : report;
    }
}