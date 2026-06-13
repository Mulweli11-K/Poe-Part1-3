
package com.mycompany.registerlogin;
import java.util.Random;
public class Message {
    
 private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    //Constructor
    public Message(int messageNumber, String recipient, String messageText) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;

        generateMessageID();
        createMessageHash();
    }

 
    //generate message ID

    public void generateMessageID() {

        Random random = new Random();

        long number = 1000000000L + (long)(random.nextDouble() * 9000000000L);

        messageID = String.valueOf(number);
    }

   
    //validate recipent

    public boolean checkRecipientCell() {

        return recipient.matches("^\\+27\\d{9}$");
    }


    //validate message length
  
    public boolean checkMessageLength() {

        return messageText.length() <= 250;
    }


    //create message hash
    
    public void createMessageHash() {
        
        if (messageText == null || messageText.trim().isEmpty()){
            messageHash = "INVALID";
            return;
        }
        
        String[] words = messageText.trim().split("\\s+");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        messageHash = ( messageID.substring(0, 2) + ":" + messageNumber + ":" + firstWord  + lastWord ).toUpperCase();
    }

   
    //print message
  
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
//return message id
public String getMessageID() {
return messageID;
}

//return message hash
public String getMessageHash() {
return messageHash;
}

//return recipient number
public String getRecipient() {
return recipient;
}

//return message text
public String getMessageText() {
return messageText;
}

}