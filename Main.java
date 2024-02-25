import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input filename: ");
        String filename = scanner.nextLine();

        LinkList playerList = readFileAndBuildList(filename);

        displayPlayerStats(playerList);

        System.out.println("\nLEAGUE LEADERS");

        System.out.println("\nBatting Average:");
        playerList.displayLeagueLeaders("Batting Average");

        System.out.println("\nOn-Base Percentage:");
        playerList.displayLeagueLeaders("On-Base Percentage");

        System.out.println("\nHits:");
        playerList.displayLeagueLeaders("Hits");

        System.out.println("\nWalks:");
        playerList.displayLeagueLeaders("Walks");

        System.out.println("\nStrikeouts:");
        playerList.displayLeagueLeaders("Strikeouts");

        System.out.println("\nHits by Pitch:");
        playerList.displayLeagueLeaders("Hits by Pitch");
    }

    private static LinkList readFileAndBuildList(String filename) {
        LinkList playerList = new LinkList();
        try {
            Scanner fileScanner = new Scanner(new File(filename));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\\s+");
                String name = parts[0];
                String battingRecord = parts[1];
                Player player = new Player(name);
                playerList.insert(player, battingRecord);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return playerList;
    }

    private static void displayPlayerStats(LinkList playerList) {
        System.out.println(
                "Player\tAt-bats\tHits\tWalks\tStrikeouts\tHits by pitch\tSacrifices\tBatting average\tOn-base percentage");
        System.out.println(playerList);
    }
}
