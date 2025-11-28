package backend;

/**
 * Data model representing a loan applicant.
 * Holds income, origin, and credit stats for the evaluation logic.
 */

public class Applicant {
    // Standard credit score in Swiss (300 - 850)
    public static final int MIN_SCORE = 300;
    public static final int MAX_SCORE = 850;

    private String id;
    private String name;
    private double income; // In CHF
    private int creditScore;
    private String canton;
    private String nationality;
    private int age;

    public Applicant(String id, String name, double income, int creditScore, String canton, String nationality,
            int age) {
        this.id = id;
        this.name = name;
        this.income = income;

        // Validate credit score range
        if (creditScore < MIN_SCORE || creditScore > MAX_SCORE) {
            throw new IllegalArgumentException("Credit Score must be between " + MIN_SCORE + " and " + MAX_SCORE);
        }
        this.creditScore = creditScore;


        this.canton = canton;
        this.nationality = nationality;
        this.age = age;
    }

    // Getters
    public double getIncome() {
        return income;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public String getCanton() {
        return canton;
    }

    public String getNationality() {
        return nationality;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /**
     * Immutable data model representing a loan applicant.
     * Setters are omitted to guarantee that profile data remains consistent during
     * the audit process.
     */

    @Override
    public String toString() {
        return String.format("Applicant [%s | %s | Income: %.0f CHF | Score: %d | Origin: %s]",
               name, canton, income, creditScore, nationality);
    }
}
