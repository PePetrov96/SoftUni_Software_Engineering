import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task_4_Teamwork_Projects {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Team> teamList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("-");
            getTeams(teamList, input);
        }

        String input;

        while (!"end of assignment".equals(input = scan.nextLine())) {
            String[] command = input.split("->");
            getPlayers(teamList, command);
        }

        sortAndPrint(teamList);

    }
    private static void getTeams (List<Team> teamList, String[] input) {
        String team = input[1];
        String creator = input[0];
        if (teamList.stream().anyMatch(e -> e.getName().equals(team))) {
            System.out.printf("Team %s was already created!%n", team);
        } else if (teamList.stream().anyMatch(team1 -> team1.getCreator().equals(creator))) {
            System.out.printf("%s cannot create another team!%n", creator);
        } else {
            Team newTeam = new Team();
            newTeam.setName(team);
            newTeam.setCreator(creator);
            teamList.add(newTeam);
            System.out.printf("Team %s has been created by %s!%n", team, creator);
        }
    }
    private static void getPlayers (List<Team> teamList, String[] command) {
        String player = command[0];
        String team = command[1];
        if (teamList.stream().noneMatch(e -> e.getName().equals(team))) {
            System.out.printf("Team %s does not exist!%n", team);
        } else if (teamList.stream().anyMatch(e -> e.getCreator().equals(player)) || (teamList.stream().flatMap(e1 -> e1.getMembers().stream()).anyMatch(member -> member.equals(player)))) {
            System.out.printf("Member %s cannot join team %s!%n", player, team);
        } else {
            IntStream.range(0, teamList.size()).filter(i -> teamList.get(i).getName().equals(team)).forEach(i -> teamList.get(i).getMembers().add(player));
        }
    }
    private static void sortAndPrint (List<Team> teamList) {
        teamList.sort(Comparator.comparing(Team::getName));
        teamList.sort(Comparator.comparing(Team::numberOfMembers).reversed());
        IntStream.range(0, teamList.size()).filter(i -> !teamList.get(i).getMembers().isEmpty()).forEach(i -> {
            System.out.printf("%s%n", teamList.get(i).getName());
            System.out.printf("- %s%n", teamList.get(i).getCreator());
            teamList.forEach(member -> member.getMembers().sort(String::compareTo));
            teamList.get(i).getMembers().forEach(current -> System.out.printf("-- %s%n", current));
        });
        System.out.println("Teams to disband:");
        teamList.stream().filter(current -> current.getMembers().isEmpty()).forEach(currentTeam -> System.out.printf("%s%n", currentTeam.getName()));
    }
    static class Team {
        String name;
        String creator;
        List<String> members;

        public Team() {setMembers(new ArrayList<>());}

        public String getName() {return name;}
        public void setName(String team) {this.name = team;}
        public String getCreator() {return creator;}
        public void setCreator(String creator) {this.creator = creator;}
        public List<String> getMembers() {return members;}
        public void setMembers(List<String> members) {this.members = members;}
        public int numberOfMembers() {return members.size();}

    }
}