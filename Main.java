package Sleep_Management;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static SleepManager sleepManager = new SleepManager();
    static Person_Manager personManager = new Person_Manager(sleepManager); // Pass SleepManager instance

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========== SLEEP DEPRIVATION MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Person");
            System.out.println("2. View People");
            System.out.println("3. Log Sleep");
            System.out.println("4. View Sleep Logs");
            System.out.println("5. View Sleep Quality History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    personManager.addPerson();
                    break;
                case 2:
                    personManager.viewPeople();
                    break;
                case 3:
                    System.out.print("Enter Person ID to log sleep: ");
                    int personId = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    Person person = personManager.getPersonById(personId);
                    if (person != null) {
                        System.out.print("Enter sleep start time (yyyy-MM-ddTHH:mm): ");
                        LocalDateTime sleepStart = LocalDateTime.parse(scanner.nextLine());
                        System.out.print("Enter sleep end time (yyyy-MM-ddTHH:mm): ");
                        LocalDateTime sleepEnd = LocalDateTime.parse(scanner.nextLine());
                        System.out.print("Enter number of interruptions: ");
                        int interruptions = scanner.nextInt();

                        try {
                            SleepRecord sleepRecord = new SleepRecord(person, sleepStart, sleepEnd, interruptions);
                            sleepManager.addSleepRecord(sleepRecord);
                            System.out.println("Sleep record logged successfully!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Person ID to view sleep logs: ");
                    int viewPersonId = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    Person viewPerson = personManager.getPersonById(viewPersonId);
                    if (viewPerson != null) {
                        sleepManager.displaySleepRecordsForPerson(viewPerson);
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;
                case 5:
                    personManager.viewSleepQualityHistory();
                    break;
                case 6:
                    System.out.println("Exiting the system...");
                    return; // Exit the application
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}