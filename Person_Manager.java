package Sleep_Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person_Manager {
    private List<Person> people;
    private SleepManager sleepManager; // Reference to SleepManager
    private Scanner scanner;

    public Person_Manager(SleepManager sleepManager) {
        this.people = new ArrayList<>();
        this.sleepManager = sleepManager; // Initialize the SleepManager
        this.scanner = new Scanner(System.in);
    }

    public void addPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        int age;
        while (true) {
            System.out.print("Enter age: ");
            age = scanner.nextInt();
            if (age > 0) break; // Ensure age is positive
            System.out.println("Please enter a valid age.");
        }
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Person person = new Person(name, age, contact, email);
        people.add(person);
        System.out.println("Person added successfully!");
    }

    public void viewPeople() {
        if (people.isEmpty()) {
            System.out.println("No people added yet.");
        } else {
            System.out.println("List of People:");
            for (int i = 0; i < people.size(); i++) {
                Person person = people.get(i);
                System.out.println("ID: " + i + " - " + person);
            }
        }
    }

    public Person getPersonById(int id) {
        if (id >= 0 && id < people.size()) {
            return people.get(id);
        }
        return null;
    }

    public void viewSleepQualityHistory() {
        System.out.print("Enter Person ID to view sleep quality history: ");
        int personId = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        Person person = getPersonById(personId);
        if (person != null) {
            System.out.println("Sleep Quality History for " + person.getName() + ":");
            for (SleepRecord record : sleepManager.getSleepRecords()) {
                if (record.getPerson().equals(person)) { // Check if the record belongs to the person
                    long duration = record.getSleepDurationInHours();
                    int qualityRating = 8; // Placeholder value, you can modify this to get actual ratings if needed
                    int stressLevel = 3;   // Placeholder value, you can modify this to get actual stress levels if needed

                    SleepQuality sleepQuality = new SleepQuality(duration, qualityRating, stressLevel);
                    System.out.println("Sleep Duration: " + duration + " hours, Quality Rating: " + qualityRating +
                            ", Stress Level: " + stressLevel + " - " + sleepQuality.getRecommendation());
                }
            }
        } else {
            System.out.println("Person not found.");
        }
    }
}