/**
 * The Team class represents a team at the World Cup which contains SoccerPlayer objects.
 *
 * @author Sahithya Pasagada
 * @version 1.0
 */
public class Team {
    /**
     * The name of the soccer team.
     */
    private String teamName;
    /**
     * The SoccerPlayers on the team.
     */
    private SoccerPlayer[] players;

    /**
     * Constructor that instantiates a new Team taking in a teamName
      and initializing the players array to have 11 empty spots.
     *
     * @param teamName The name of the soccer team.
     */
    public Team(String teamName) {
        this.teamName = teamName;
        players = new SoccerPlayer[11];
    }

    /**
     * This method overrides Object's .toString().
     *
     * @return Returns a string representation of Team followed by the toString() of each player on the team
     */
    public String toString() {
        String result = "Team name: " + teamName;

        for (SoccerPlayer s : players) {
            if (s != null) {
                result = result + "\n" + s.toString();
            }
        }

        return result;
    }

    /**
     * This method adds the passed in player into the players array.
     *
     * @param player Represents a soccerplayer.
     */
    public void addTeamMember(SoccerPlayer player) {
        for (int i = 0; i < 11; i++) {
            if (players[i] == null) {
                players[i] = player;
                break;
            }
        }
    }

    /**
     * This method determines which team would win based on each team's average rating.
     *
     * @param opponent Represents another Team that is being played against.
     * @return Returns a string of the teamname of the team that wins or a tie if that is the case.
     */
    public String playAgainstTeam(Team opponent) {
        double currentRating = 0;
        double opponentRating = 0;

        for (SoccerPlayer s : players) {
            if (s != null) {
                s.play();
                currentRating += s.calculateRating();
            }
        }

        for (SoccerPlayer o : opponent.players) {
            if (o != null) {
                o.play();
                opponentRating += o.calculateRating();
            }
        }

        if (currentRating > opponentRating) {
            return this.teamName;
        } else if (opponentRating > currentRating) {
            return opponent.teamName;
        }

        return "Tie.";

    }


}
