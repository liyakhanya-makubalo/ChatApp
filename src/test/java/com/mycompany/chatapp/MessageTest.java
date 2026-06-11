/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.chatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testMessageLengthValid() {

        Message msg = new Message(
                0,
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight?"
        );

        assertEquals(
                "Message ready to send.",
                msg.checkMessageLength()
        );
    }

    @Test
    public void testMessageLengthInvalid() {

        String longMessage = "A".repeat(260);

        Message msg = new Message(
                0,
                "+27718693002",
                longMessage
        );

        assertEquals(
                "Message exceeds 250 characters by 10; please reduce the size.",
                msg.checkMessageLength()
        );
    }

    @Test
    public void testRecipientValid() {

        Message msg = new Message(
                0,
                "+27718693002",
                "Hello"
        );

        assertEquals(
                "Cell phone number successfully captured.",
                msg.checkRecipientCell()
        );
    }

    @Test
    public void testRecipientInvalid() {

        Message msg = new Message(
                0,
                "08575975889",
                "Hello"
        );

        assertEquals(
                "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                msg.checkRecipientCell()
        );
    }

    @Test
    public void testMessageHashCreated() {

        Message msg = new Message(
                0,
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight"
        );

        String hash = msg.getMessageHash();

        assertNotNull(hash);
        assertTrue(hash.contains(":0:HITONIGHT"));
    }

    @Test
    public void testMessageIDCreated() {

        Message msg = new Message(
                0,
                "+27718693002",
                "Hello"
        );

        assertTrue(msg.checkMessageID());
        assertEquals(10, msg.getMessageID().length());
    }
}