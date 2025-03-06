package Sleep_Management;

import java.time.LocalDateTime;
import java.time.Duration;

public class SleepRecord {
    private LocalDateTime sleepStart;
    private LocalDateTime sleepEnd;
    private int interruptions; // Number of interruptions during sleep
    private Person person; // Reference to the associated person

    public SleepRecord(Person person, LocalDateTime sleepStart, LocalDateTime sleepEnd, int interruptions) {
        if (sleepEnd.isBefore(sleepStart)) {
            throw new IllegalArgumentException("Sleep end time must be after sleep start time.");
        }
        this.person = person; // Associate the person
        this.sleepStart = sleepStart;
        this.sleepEnd = sleepEnd;
        this.interruptions = interruptions;
    }

    public long getSleepDurationInHours() {
        return Duration.between(sleepStart, sleepEnd).toHours();
    }

    public long getSleepDurationInMinutes() {
        return Duration.between(sleepStart, sleepEnd).toMinutes();
    }

    public int getInterruptions() {
        return interruptions;
    }

    public LocalDateTime getSleepStart() {
        return sleepStart;
    }

    public LocalDateTime getSleepEnd() {
        return sleepEnd;
    }

    public Person getPerson() {
        return person; // Getter for the associated person
    }

    @Override
    public String toString() {
        return "Sleep Start: " + sleepStart + ", Sleep End: " + sleepEnd +
                ", Duration: " + getSleepDurationInHours() + " hours " +
                (getSleepDurationInMinutes() % 60) + " minutes, Interruptions: " + interruptions;
    }
}