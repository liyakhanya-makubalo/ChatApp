/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @author Student
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        // =========================
        // REGISTRATION
        // =========================
        System.out.println("=== USER REGISTRATION ===");

        System.out.print("Enter a username: ");
        String username = input.nextLine();

        System.out.print("Enter a password: ");
        String password = input.nextLine();

        System.out.print("Enter your South African number (+27...): ");
        String phoneNumber = input.nextLine();

        String registration =
                login.registerUser(username, password, phoneNumber);

        System.out.println(registration);

        // =========================
        // LOGIN
        // =========================
        System.out.println("\n=== USER LOGIN ===");

        System.out.print("Enter username: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = input.nextLine();

        boolean loggedIn =
                login.loginUser(loginUsername, loginPassword);

        System.out.println(
                login.returnLoginStatus(loggedIn));

        if (!loggedIn) {
            System.out.println("Login failed. Exiting...");
            input.close();
            return;
        }

        System.out.println("Welcome to QuickChat.");

        boolean running = true;

        while (running) {

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.println("4) Stored Messages");

            System.out.print("Choose an option: ");
            
