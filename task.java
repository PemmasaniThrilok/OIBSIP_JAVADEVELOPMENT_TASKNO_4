package onlineExamination;

import java.util.*;

class task {

    Scanner sc = new Scanner(System.in);
    String username = "thrilok";
    String password = "1234";

    String name;
    String email;
    int phoneNumber;
    int score = 0;
    boolean examSubmitted = false;

    
    void login() {
        System.out.println("LOGIN");

        System.out.print("Enter Username: ");
        String u = sc.nextLine();
        System.out.print("Enter Password: ");
        String p = sc.nextLine();

        if (u.equals(username) && p.equals(password)) {
            System.out.println("Login Successful!");
            menu();
        } else {
            System.out.println("Invalid");
            login();
        }
    }

    // ---------------- Menu ------------------
    void menu() {
        while (true) {
            System.out.println("MENU");
            System.out.println("1. Update Profile");
            System.out.println("2. Change Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1 -> updateProfile();
                case 2 -> changePassword();
                case 3 -> startExam();
                case 4 -> logout();
                default -> System.out.println("Invalid choice");
            }
        }
    }
    void updateProfile() {
        System.out.println("Update Profile");

        System.out.print("Enter New Name: ");
        name = sc.nextLine();

        System.out.print("Enter New Email: ");
        email = sc.nextLine();
        
        System.out.print("Enter New PhoneNumber: ");
        phoneNumber = sc.nextInt();

        System.out.println("Profile Updated Successfully");
    }

    void changePassword() {
        System.out.println("Change Password");
        System.out.print("Enter Old Password: ");
        String oldPass = sc.nextLine();

        if (oldPass.equals(password)) {
            System.out.print("Enter New Password: ");
            password = sc.nextLine();
            System.out.println("Password Updated Successfully");
        } else {
            System.out.println("Wrong Old Password");
        }
    }
    void startExam() {
        System.out.println("EXAM STARTED");
        System.out.println("Timer: 20 seconds");

        Thread timer = new Thread(() -> {
            try {
                for (int i = 20; i >= 0; i--) {
                    
                    Thread.sleep(1000);
                }
                System.out.println("Time Over");
                examSubmitted = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        timer.start();

        askQuestions();
        try {
            timer.join();
        } catch (Exception e) {}

        submitExam();
    }

    void askQuestions() {
        System.out.println("Q1: Java is a?");
        System.out.println("1. Programming Language");
        System.out.println("2. Object Oriented Language");
        System.out.println("3. Dynamic Language");
        System.out.println("4. All the Above");
        System.out.print("Your Answer: ");
        int ans1 = sc.nextInt();
        if (ans1 == 4) score++;

        System.out.println("Q2: Java is a Platform Independent language ?");
        System.out.println("1. true");
        System.out.println("2. false");
        System.out.print("Your Answer: ");
        int ans2 = sc.nextInt();
        if (ans2 == 1) score++;

        System.out.println("Answers Saved and Auto Submit");
    }

    void submitExam() {
        System.out.println(" Exam Submitted ");
        System.out.println("Your Score: " + score + "/2\n");
        examSubmitted = true;
    }

    void logout() {
        System.out.println("Logging Out and Thank you again");
        System.exit(0);
    }

    public static void main(String[] args) {
        task obj = new task();
        obj.login();
    }
}

