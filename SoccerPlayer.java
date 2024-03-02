/**
 * SoccerPlayer is an abstract class. Concrete classes extend the attributes behaviors of this
    soccer player class. This class defines the generic behaviour of a soccer player.
 *
 * @author Sahithya Pasagada
 * @version 1.0
 */
public abstract class SoccerPlayer {
    /**
     * Represents the name of the soccer player.
     */
    private String name;
    /**
     * Represents the name of the country the soccer player is from.
     */
    private String country;
    /**
     * Represents the starting stamina for the player.
     */
    private int stamina;

    /**
     * Sets the name of the soccer player.
     *
     * @param name The name of the soccer player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the soccer player.
     *
     * @return The name of the soccer player.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the country the soccer player is from.
     *
     * @param country The name of the country the soccer player is from.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the name of the country the soccer player is from.
     *
     * @return The name of the country the soccer player is from.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the starting stamina for the player.
     *
     * @param stamina The starting stamina for the player.
     */
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    /**
     * Gets the starting stamina for the player.
     *
     * @return The starting stamina for the player.
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * Constructor that instantiates a new Soccer player.
     *
     * @param name    The name of the soccer player.
     * @param country The name of the country the soccer player is from.
     * @param stamina The starting stamina for the player.
     */
    public SoccerPlayer(String name, String country, int stamina) {
        this.name = name;
        this.country = country;
        this.stamina = 20;
        if (stamina >= 1) {
            this.stamina = stamina;
        }
    }

    /**
     * This method overrides Object's .toString().
     *
     * @return Returns a string representation of SoccerPlayer.
     */
    public String toString() {
        return name + " from " + country + " has " + stamina + " stamina left. ";
    }

    /**
     * This method overrides Object's .equals() checking that a SoccerPlayer is equal
        to another SoccerPlayer when they both have the same name and country.
     *
     * @param o An Object
     * @return Returns a boolean value that indicates whether some other object is "equal to" this SoccerPlayer
     */
    public boolean equals(Object o) {
        SoccerPlayer s;
        if (name == null || country == null) {
            return false;
        }

        if (!(o instanceof SoccerPlayer)) {
            return false;
        }

        s = (SoccerPlayer) o;

        return this.name.equals(s.name) && this.country.equals(s.country);
    }

    /**
     * An abstract method that will be used to represent a player playing a game.
     */
    public abstract void play();

    /**
     * An abstract method that will be used to determine the rating of a player based on their statistics.
     *
     * @return Returns a player's rating.
     */
    public abstract double calculateRating();

    /**
     * This method increases a soccerplayer's stamina by 5.
     */
    public void rest() {
        stamina += 5;
    }
}
