/**
 * The GameSim class is the Driver class which is used to test code of the other classes
 where players and teams can be built to simulate
 soccer matches to help predict results of the real matches.
 *
 * @author Sahithya Pasagada
 * @version 1.0
 */
public class GameSim {
    /**
     * This is the main method which makes use of the other classes and its respective methods.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        Team t1 = new Team("Belgium");
        Team t2 = new Team("Brazil");
        Team t3 = new Team("Argentina");
        Team t4 = new Team("Germany");
        Team[] teams = new Team[4];
        teams[0] = t1;
        teams[1] = t2;
        teams[2] = t3;
        teams[3] = t4;

        Defender d1 = new Defender("W. Faes", "Belgium", 40, 2, 5, 8.6);
        GoalKeeper g1 = new GoalKeeper("M. Sels", "Belgium", 12, 32, 41, 7.2);
        Attacker a1 = new Attacker("E. Hazard", "Belgium", 0, 15, 3, 2.1, Attacker.CelebrationMove.DIVE);
        //Attacker a9 = new Attacker("E. Hazard", "Belgium", 0, 15, 3, 2.1, Attacker.CelebrationMove.DIVE);
        t1.addTeamMember(d1);
        t1.addTeamMember(g1);
        t1.addTeamMember(a1);
        //System.out.println(d1.calculateRating());
        d1.play();
        //d1.rest();
        //System.out.println(d1.getStamina());
        //t1.addTeamMember(a9);

        //System.out.println(t1.playAgainstTeam(t2));

        Defender d2 = new Defender("Danilo", "Brazil", 20, 12, -2, 8.6);
        GoalKeeper g2 = new GoalKeeper("Ederson", "Brazil", 32, 59, 12, 7.2);
        Attacker a2 = new Attacker("Pedro", "Brazil", 17, 4, 87, 2.1, Attacker.CelebrationMove.DIVE);

        t2.addTeamMember(d2);
        t2.addTeamMember(g2);
        t2.addTeamMember(a2);
        System.out.println(t1.playAgainstTeam(t2));

        Defender d3 = new Defender("F. Medina", "Argentina", 18, 4, 0, 10.4);
        GoalKeeper g3 = new GoalKeeper("G. Rulli", "Argentina", 20, 29, 14, 13.2);
        Attacker a3 = new Attacker("L. Messi", "Argentina", -2, 34, 46, 15.8, Attacker.CelebrationMove.CARTWHEEL);
        t3.addTeamMember(d3);
        t3.addTeamMember(g3);
        t3.addTeamMember(a3);

        Defender d4 = new Defender("D. Raum", "Germany", 20, 45, 92, 8.4);
        GoalKeeper g4 = new GoalKeeper("K. Trapp", "Germany", 3, 12, 16, 2);
        Attacker a4 = new Attacker("T. Werner", "Germany", 4, 17, 2, 14, Attacker.CelebrationMove.CARTWHEEL);
        t4.addTeamMember(d4);
        t4.addTeamMember(g4);
        t4.addTeamMember(a4);

    }
}
