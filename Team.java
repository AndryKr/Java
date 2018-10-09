package Lesson_1.Marathon;

public class Team {

    private String teamName;
    private Competitor[] competitors;

    public Team (String teamName, Competitor[] competitors) {
        this.teamName = teamName;
        this.competitors = competitors;
    }

    Competitor[] getCompetitors () {
        return competitors;
    }
        void showResults () {
            System.out.println("\nРезультаты команды " + teamName + ":");
            for (Competitor c : competitors) {
                c.info();
            }
        }
}
