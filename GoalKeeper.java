/**
 * The GoalKeeper class is a SoccerPlayer representing one of the types of SoccerPlayer's.
 *
 * @author Sahithya Pasagada
 * @version 1.0
 */
public class GoalKeeper extends SoccerPlayer {
    /**
     * Represents the number of saves for this goalkeeper.
     */
    private int totalSaves;
    /**
     * Represents the number of shots on target on the net that is defended by this goalkeeper.
     */
    private int totalShotsOnTarget;
    /**
     * Represents the rating that is used to determine this goalkeeper's ballhandling skills.
     */
    private double ballHandling;

    /**
     * Constructor that instantiates a new Goalkeeper.
     *
     * @param name               The name of the soccer player.
     * @param country            The name of the country the socccer player is from.
     * @param stamina            The starting stamina for the player.
     * @param totalSaves         The number of saves for this goalkeeper.
     * @param totalShotsOnTarget The number of shots on target on the net that is defended by this goalkeeper.
     * @param ballHandling       The rating that is used to determine this goalkeeper's ballhandling skills.
     */
    public GoalKeeper(String name, String country, int stamina,
                    int totalSaves, int totalShotsOnTarget, double ballHandling) {
        super(name, country, stamina);
        this.totalSaves = totalSaves;
        if (totalSaves > totalShotsOnTarget) {
            this.totalSaves = totalShotsOnTarget;
        }
        this.totalShotsOnTarget = totalShotsOnTarget;
        this.ballHandling = ballHandling;
    }

    /**
     * This method calculates a goalkeeper's ballhandling rating based on their statistics.
     *
     * @return the goalkeeper's ballhandling rating
     */
    public double calculateRating() {
        if (totalShotsOnTarget != 0) {
            return (((double) totalSaves) / ((double) totalShotsOnTarget)) * 100;
        }

        return 0;
    }

    /**
     * This method decreases a goalkeeper's stamina by a
     random amount and if their stamina is 0 then their performance is affected.
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
        int saves = 0;
        int shots = (int) (Math.random() * 101);
        if (this.getStamina() > 0) {
            saves = (int) (Math.random() * (shots + 1));
        }

        totalSaves += saves;
        totalShotsOnTarget += shots;
        ballHandling = calculateRating();
    }

    /**
     * This method overrides SoccerPlayer's .toString().
     *
     * @return Returns a string representation of GoalKeeper.
     */
    public String toString() {
        return super.toString() + "As a Goalkeeper, I have stopped "
               + totalSaves + " shots from " + totalShotsOnTarget
               + " shots on target and my rating is " + String.format("%.2f", ballHandling);
    }

    /**
     * This method overrides SoccerPlayer's .equals() checking that a Goalkeeper is equal
     to another Goalkeeper when they both have the same name,
     country, total saves, total shots on target, and ball handling rating.
     *
     * @param o An Object
     * @return Returns a boolean value that indicates whether some other object is "equal to" this GoalKeeper.
     */
    public boolean equals(Object o) {
        GoalKeeper g;

        if (o == null) {
            return false;
        }

        if (!(o instanceof GoalKeeper)) {
            return false;
        }

        g = (GoalKeeper) o;

        return super.equals(o) && this.totalSaves == g.totalSaves
               && this.totalShotsOnTarget == g.totalShotsOnTarget
               && this.ballHandling == g.ballHandling;
    }


}
