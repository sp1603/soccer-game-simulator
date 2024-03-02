/**
 * The Attacker class is a SoccerPlayer representing one of the types of SoccerPlayer's.
 *
 * @author Sahithya Pasagada
 * @version 1.0
 */
public class Attacker extends SoccerPlayer {
    /**
     * Represents the total number of goals this Attacker has scored.
     */
    private int totalGoals;
    /**
     * Represents the total number of shots on target this player has had.
     */
    private int totalShotsOnTarget;
    /**
     * Represents this Attacker's overall rating.
     */
    private double attackingRating;

    /**
     * Represent's an Attacker's possible celebration moves.
     */
    public enum CelebrationMove {
        /**
         * Dive CelebrationMove.
         */
        DIVE,
        /**
         * Cartwheel CelebrationMove.
         */
        CARTWHEEL,
        /**
         * Siuu CelebrationMove.
         */
        SIUU
    }

    /**
     * Represents this Attacker's celebration move when scoring goals.
     */
    private CelebrationMove celebrationMove;

    /**
     * Constructor that instantiates a new Attacker.
     *
     * @param name               The name of the soccer player.
     * @param country            The name of the country the socccer player is from.
     * @param stamina            The starting stamina for the player.
     * @param totalGoals         Represents the total number of goals this Attacker has scored.
     * @param totalShotsOnTarget Represents the total number of shots on target this player has had.
     * @param attackingRating    Represents this Attacker's overall rating.
     * @param celebrationMove    Represent's an Attacker's possible celebration moves.
     */
    public Attacker(String name, String country, int stamina, int totalGoals,
                    int totalShotsOnTarget, double attackingRating, CelebrationMove celebrationMove) {
        super(name, country, stamina);
        this.totalGoals = totalGoals;
        if (totalGoals > totalShotsOnTarget) {
            this.totalGoals = totalShotsOnTarget;
        }
        this.totalShotsOnTarget = totalShotsOnTarget;
        this.attackingRating = attackingRating;
        this.celebrationMove = celebrationMove;
    }

    /**
     * This method calculates an attacker's attacking rating based on their statistics.
     *
     * @return the attacker's attacking rating
     */
    public double calculateRating() {
        if (totalShotsOnTarget != 0) {
            return (((double) totalGoals) / ((double) totalShotsOnTarget)) * 100;
        }
        return 0;
    }

    /**
     * This method decreases an attacker's stamina by a random amount
      and if their stamina is 0 then their performance is affected.
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
        int goals = 0;
        int shots = (int) (Math.random() * 101);
        if (this.getStamina() > 0) {
            goals = (int) (Math.random() * (shots + 1));
            if (CelebrationMove.SIUU == celebrationMove) {
                goals = (int) (1.1 * goals);
            }
        }

        totalGoals += goals;
        totalShotsOnTarget += shots;
        attackingRating = calculateRating();
    }

    /**
     * This method overrides SoccerPlayer's .toString().
     *
     * @return Returns a string representation of Attacker.
     */
    public String toString() {
        return super.toString() + "As an Attacker, I have scored " + totalGoals
                + " goals from " + totalShotsOnTarget + " shots on my target and my rating is "
                + String.format("%.2f", attackingRating) + ". My celebration is "
                + celebrationMove + ".";
    }

    /**
     * This method overrides SoccerPlayer's .equals() checking that an Attacker is equal to another Attacker
      when they both have the same name, country, total goals, total shots
      on target, attacking rating, and celebration move.
     *
     * @param o An Object
     * @return Returns a boolean value that indicates whether some other object is "equal to" this Attacker.
     */
    public boolean equals(Object o) {
        Attacker a;

        if (o == null) {
            return false;
        }

        if (!(o instanceof Attacker)) {
            return false;
        }

        a = (Attacker) o;

        return super.equals(o) && this.totalGoals == a.totalGoals
             && this.totalShotsOnTarget == a.totalShotsOnTarget
             && this.attackingRating == a.attackingRating
             && this.celebrationMove == a.celebrationMove;
    }
}
