package Sleep_Management;

import java.util.ArrayList;
import java.util.List;

public class SleepManager {
    private List<SleepRecord> sleepRecords = new ArrayList<>();
    private int sleepGoal; // in hours
    private final int averageSleepDuration = 7; // Average sleep duration in hours

    public void addSleepRecord(SleepRecord record) {
        sleepRecords.add(record);
    }

    public void setSleepGoal(int hours) {
        this.sleepGoal = hours;
    }

    public int getSleepGoal() {
        return sleepGoal;
    }

    public List<SleepRecord> getSleepRecords() {
        return sleepRecords; // Return all sleep records
    }

    public void displaySleepRecordsForPerson(Person person) {
        System.out.println("Sleep records for " + person.getName() + ":");
        boolean hasRecords = false; // Flag to check if there are any records for the person
        for (SleepRecord record : sleepRecords) {
            if (record.getPerson().equals(person)) { // Ensure the record belongs to the person
                hasRecords = true; // Set flag to true if a record is found
                long duration = record.getSleepDurationInHours();
                long durationInMinutes = record.getSleepDurationInMinutes();
                System.out.println("Sleep Start: " + record.getSleepStart() +
                        ", Sleep End: " + record.getSleepEnd() +
                        ", Duration: " + duration + " hours " +
                        (durationInMinutes % 60) + " minutes, Interruptions: " + record.getInterruptions());
            }
        }
        if (!hasRecords) {
            System.out.println("No sleep records found for " + person.getName() + ".");
        }
    }

    public void compareWithAverageSleep() {
        for (SleepRecord record : sleepRecords) {
            long duration = record.getSleepDurationInHours();
            if (duration < averageSleepDuration) {
                System.out.println("You slept " + (averageSleepDuration - duration) + " hour(s) less than the average sleep duration.");
            } else if (duration > averageSleepDuration) {
                System.out.println("You slept " + (duration - averageSleepDuration) + " hour(s) more than the average sleep duration.");
            } else {
                System.out.println("You met the average sleep duration.");
            }
        }
    }
}