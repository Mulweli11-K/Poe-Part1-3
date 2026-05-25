/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registerlogin;

/**
 *
 * @author Student
 */
import java.util.Random;

public class Message {
    
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    // Constructor
    public Message(int messageNumber,
                   String recipient,
                   String messageText) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;

        generateMessageID();
        createMessageHash();
    }

    // =========================
    // GENERATE MESSAGE ID
    // =========================
    public void generateMessageID() {

        Random random = new Random();

        long number = 1000000000L
                + (long)(random.nextDouble() * 9000000000L);

        messageID = String.valueOf(number);
    }

    // =========================
    // VALIDATE RECIPIENT
    // =========================
    public boolean checkRecipientCell() {

        return recipient.matches("^\\+27\\d{9}$");
    }

    // =========================
    // VALIDATE MESSAGE LENGTH
    // =========================
    public boolean checkMessageLength() {

        return messageText.length() <= 250;
    }

    // =========================
    // CREATE MESSAGE HASH
    // =========================
    public void createMessageHash() {

        String[] words = messageText.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        messageHash = (
                messageID.substring(0, 2)
                + ":" + messageNumber
                + ":" + firstWord
                + lastWord
        ).toUpperCase();
    }

    // =========================
    // PRINT MESSAGE
    // =========================
    public String printMessage() {

        return """
               Message ID: %s
               Message Hash: %s
               Recipient: %s
               Message: %s
               """.formatted(
                messageID,
                messageHash,
                recipient,
                messageText
        );
    }
}
