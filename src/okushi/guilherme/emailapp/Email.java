package okushi.guilherme.emailapp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private int defaultPasswordLenght = 10;
    private Scanner scanner;
    //Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //
        System.out.println("Email generated: " + this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + setDepartment() + "company.com");
        this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + "company.com";
        //
        this.password = randomPassword(this.defaultPasswordLenght);
        System.out.println("Your password is: " + this.password);

    }

    //Ask for the department
    private String setDepartment(){
        System.out.println("Select an department: \n[1]Sales\n[2]Development\n[3]Accounting\n[0]None");
        scanner = new Scanner(System.in);
        int optionDepartment = scanner.nextInt();
        switch (optionDepartment){
            case 1:
                this.department = "sales.";
                break;
            case 2:
                this.department = "development.";
                break;
            case 3:
                this.department = "accounting.";
                break;
            case 0:
                this.department = "";
                break;
            default:
                System.out.println("Invalid input, try again!");
        }
        return this.department;
    }
    //Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int)(Math.random()*passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    //Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    //Set alternate email
    public void setAlternateEmail(String email){
        this.alternateEmail = email;
    }
    //Change the password
    public void setPassword(String password){
        this.password = password;
    }
    
    //Get info
    public String getPassword() {
        return password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void getInfo(){
        System.out.println("Name: " + this.firstName + " " + this.lastName + "\nCompany email: " + this.email + "\nMailbox Capacity: " + this.mailboxCapacity + "mb");
    }
}
