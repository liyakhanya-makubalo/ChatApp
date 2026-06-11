/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Student
 */
public class Message {

private static List<String> sentMessages = new ArrayList<>();
private static List<String> storedMessages = new ArrayList<>();
private static List<String> messageHashes = new ArrayList<>();
private static List<String> messageIDs = new ArrayList<>();
private static List<String> recipientList = new ArrayList<>();

private String messageID;
private int messageNumber;
private String recipient;
private String messageText;
private String messageHash;

public Message(int messageNumber,
               String recipient,
               String messageText) {

    this.messageNumber = messageNumber;
    this.recipient = recipient;
    this.messageText = messageText;

    this.messageID = generateMessageID();
    this.messageHash = createMessageHash();
}

public String checkRecipientCell() {

    if (recipient != null
            && recipient.startsWith("0")
            && recipient.length() == 10) {

        return "Cell phone number successfully captured.";
    }

    return "Cell phone number is incorrectly formatted.";
}

public String checkMessageLength() {

    if (messageText.length() <= 250) {
        return "Message ready to send.";
    }

    int excess = messageText.length() - 250;

    return "Message exceeds 250 characters by "
            + excess
            + "; please reduce the size.";
}

public String createMessageHash() {

    String[] words = messageText.split(" ");

    String firstWord = words[0].toUpperCase();
    String lastWord = words[words.length - 1].toUpperCase();

    return messageID.substring(0, 2)
            + ":"
            + messageNumber
            + ":"
            + firstWord
            + lastWord;
}

public String sentMessage() {

    Scanner input = new Scanner(System.in);

    System.out.println("""
            Choose an option:
            1) Send Message
            2) Disregard Message
            3) Store Message
            """);

    int choice = input.nextInt();
    input.nextLine();

    switch (choice) {

        case 1:

            sentMessages.add(messageText);
            messageIDs.add(messageID);
            messageHashes.add(messageHash);
            recipientList.add(recipient);

            return "Message successfully sent.";

        case 2:
            return "Message disregarded.";

        case 3:

            String stored =
                    "Message ID: " + messageID
                    + "\nHash: " + messageHash
                    + "\nRecipient: " + recipient
                    + "\nMessage: " + messageText
                    + "\n------------------------";

            storedMessages.add(stored);

            messageIDs.add(messageID);
            messageHashes.add(messageHash);
            recipientList.add(recipient);

            return "Message successfully stored.";

        default:
            return "Invalid option.";
    }
}

public String printMessages() {

    return """
           Message ID: %s
           Message Hash: %s
           Recipient: %s
           Message: %s
           """.formatted(
            messageID,
            messageHash,
            recipient,
            messageText);
}

public static int returnTotalMessages() {
    return sentMessages.size() + storedMessages.size();
}

public static String displayLongestMessage() {

    if (storedMessages.isEmpty()) {
        return "No stored messages.";
    }

    String longest = storedMessages.get(0);

    for (String msg : storedMessages) {

        if (msg.length() > longest.length()) {
            longest = msg;
        }
    }

    return longest;
}

public static String searchByMessageID(String id) {

    int index = messageIDs.indexOf(id);

    if (index == -1) {
        return "Message not found.";
    }

    if (index < storedMessages.size()) {
        return storedMessages.get(index);
    }

    return "Message found.";
}

public static String searchByRecipient(String recipient) {

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < recipientList.size(); i++) {

        if (recipientList.get(i).equals(recipient)
                && i < storedMessages.size()) {

            result.append(storedMessages.get(i))
                    .append("\n");
        }
    }

    if (result.length() == 0) {
        return "No messages found.";
    }
public static String searchByRecipient(String recipient) {

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < recipientList.size(); i++) {

        if (recipientList.get(i).equals(recipient)
                && i < storedMessages.size()) {

            result.append(storedMessages.get(i))
                    .append("\n");
        }
    }

    if (result.length() == 0) {
        return "No messages found.";
    }

    return result.toString();
}

public static String deleteByHash(String hash) {

    int index = messageHashes.indexOf(hash);

    if (index == -1) {
        return "Hash not found.";
    }
}
public static String printReport() {

    StringBuilder report =
            new StringBuilder("=== FULL REPORT ===\n");

    for (String msg : storedMessages) {
        report.append(msg).append("\n");
    }

    return report.toString();
}

public static String generateMessageID() {

    long number =
            (long) (Math.random() * 10000000000L);

    return String.format("%010d", number);
}

public String getMessageHash() {
    return messageHash;
}

public boolean checkMessageID() {
    return messageID != null && messageID.length() == 10;
}

public String getMessageID() {
    return messageID;
}

}
