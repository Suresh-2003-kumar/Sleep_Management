package Sleep_Management;

import java.util.ArrayList;
import java.util.List;

public class SleepQuality {
    private long sleepDuration; // Duration in hours
    private int qualityRating;   // Self-reported quality rating (1-10)
    private int stressLevel;      // Stress level (1-10)
    private List<Integer> historicalScores; // List to store historical scores

    public SleepQuality(long sleepDuration, int qualityRating, int stressLevel) {
        this.sleepDuration = sleepDuration;
        this.qualityRating = qualityRating;
        this.stressLevel = stressLevel;
        this.historicalScores = new ArrayList<>();
        this.historicalScores.add(calculateQualityScore()); // Store the initial score
    }

    public int calculateQualityScore() {
        // Calculate sleep quality score
        int score = (int) sleepDuration + qualityRating - stressLevel;

        // Ensure the score is within a reasonable range
        if (score < 0) {
            return 0; // Minimum score
        } else if (score > 100) {
            return 100; // Maximum score
        }
        return score;
    }

    public void addScoreToHistory() {
        historicalScores.add(calculateQualityScore());
    }

    public List<Integer> getHistoricalScores() {
        return historicalScores;
    }

    public String getRecommendation() {
        int score = calculateQualityScore();
        StringBuilder recommendation = new StringBuilder();

        if (score >= 80) {
            recommendation.append("Excellent sleep quality! Keep maintaining your good habits.");
        } else if (score >= 60) {
            recommendation.append("Good sleep quality. Continue your routine but consider minor improvements.");
        } else if (score >= 40) {
            recommendation.append("Fair sleep quality. Evaluate your sleep environment and habits.");
            recommendation.append(" Try to sleep at least 8 hours to improve your energy levels.");
        } else {
            recommendation.append("Poor sleep quality. It's advisable to consult a healthcare professional for guidance.");
            recommendation.append(" Prioritize sleep; aim for at least 8 hours to avoid health issues.");
        }

        // Additional suggestions based on sleep duration
        if (sleepDuration < 8) {
            recommendation.append(" Remember, sleeping less than 8 hours can lead to fatigue, decreased productivity, and impaired decision-making.");
        } else if (sleepDuration > 8) {
            recommendation.append(" Sleeping more than 8 hours may lead to feelings of lethargy. Monitor your energy levels.");
        }

        return recommendation.toString();
    }

    @Override
    public String toString() {
        return "Sleep Duration: " + sleepDuration + " hours, Quality Rating: " + qualityRating +
                ", Stress Level: " + stressLevel + " - " + getRecommendation();
    }
}