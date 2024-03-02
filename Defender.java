/**
 * The Defender class is a SoccerPlayer representing one of the types of SoccerPlayer's.
 *
 * @author Sahithya Pasagada
 * @version 1.0
 */
public class Defender extends SoccerPlayer {
    /**
     * Represents the total number of passes inititated by this defender.
     */
    private int totalPasses;
    /**
     * Represents the total number of passes completed.
     */
    private int totalPassesCompleted;
    /**
     * Represents this Defender's overall rating.
     */
    private double defenseRating;

    /**
     * Constructor that instantiates a new Defender.
     *
     * @param name                 The name of the soccer player.
     * @param country              The name of the country the socccer player is from.
     * @param stamina              The starting stamina for the player.
     * @param totalPasses          The total number of passes inititated by this defender.
     * @param totalPassesCompleted The total number of passes completed.
     * @param defenseRating        This Defender's overall rating.
     */
    public Defender(String name, String country, int stamina,
                    int totalPasses, int totalPassesCompleted, double defenseRating) {
        super(name, country, stamina);
        this.totalPassesCompleted = totalPassesCompleted;
        if (totalPassesCompleted > totalPasses) {
            this.totalPassesCompleted = totalPasses;
        }
        this.totalPasses = totalPasses;
        this.defenseRating = defenseRating;
    }

    /**
     * This method calculates a defender's defense rating based on their statistics.
     *
     * @return the defender's defense rating
     */
    public double calculateRating() {
        if (totalPasses > 0) {
            return (((double) totalPassesCompleted) / ((double) totalPasses)) * 100;
        }
        return 0;
    }

    /**
     * This method decreases a defender's stamina by a random
     amount and if their stamina is 0 then their performance is affected.
     */
    public void play() {
        int amount = 1 + (int) (Math.random() * 100);
        if (this.getStamina() > 0) {
            if ((this.getStamina() - amount) < 0) {
                this.setStamina(0);
            } else {
                this.setStamina(this.getStamina() - amount);
            }
        }
        int completedPasses = 0;
        int passes = (int) (Math.random() * 101);
        if (this.getStamina() > 0) {
            int percent = (int) (Math.random() * 10);
            if (percent == 0) {
                completedPasses = passes;
            }
            completedPasses = (int) (Math.random() * (passes + 1));
        }

        totalPasses += passes;
        totalPassesCompleted += completedPasses;
        defenseRating = calculateRating();
    }

    /**
     * This method overrides SoccerPlayer's .toString().
     *
     * @return Returns a string representation of Defender.
     */
    public String toString() {
        return super.toString() + "As a Defender, I have completed "
             + totalPassesCompleted + " passes from " + totalPasses
             + " initiated passes and my rating is " + String.format("%.2f", defenseRating);
    }

    /**
     * This method overrides SoccerPlayer's .equals() checking that a Defender is equal
     to another Defender when they both have the same name,
     country, total passes, total completed passes, and defense rating.
     *
     * @param o An Object
     * @return Returns a boolean value that indicates whether some other object is "equal to" this Defender.
     */
    public boolean equals(Object o) {
        Defender d;

        if (o == null) {
            return false;
        }

        if (!(o instanceof Defender)) {
            return false;
        }

        d = (Defender) o;

        return super.equals(o) && this.totalPasses == d.totalPasses
            && this.totalPassesCompleted == d.totalPassesCompleted
            && this.defenseRating == d.defenseRating;
    }
}
