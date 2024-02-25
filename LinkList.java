import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkList {
    private Node head;

    public LinkList() {
        this.head = null;
    }

    public void insert(Player player, String battingRecord) {
        Node newNode = new Node(player);
        char[] results = battingRecord.toCharArray();
        for (char result : results) {
            switch (result) {
                case 'H':
                    player.incrementHits();
                    player.incrementAtBats();
                    break;
                case 'O':
                    player.incrementAtBats();
                    break;
                case 'K':
                    player.incrementStrikeouts();
                    player.incrementAtBats();
                    break;
                case 'W':
                    player.incrementWalks();
                    break;
                case 'P':
                    player.incrementHitsByPitch();
                    // player.incrementAtBats();
                    break;
                case 'S':
                    player.incrementSacrifices();
                    break;
                default:
                    // Ignore invalid characters
            }
        }
        if (head == null || player.getName().compareTo(head.getPlayer().getName()) < 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null
                    && player.getName().compareTo(current.getNext().getPlayer().getName()) > 0) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.getPlayer()).append("\n");
            current = current.getNext();
        }
        return sb.toString();
    }

    public void displayLeagueLeaders(String category) {
        List<Player> players = new ArrayList<>();
        Node current = head;
        while (current != null) {
            players.add(current.getPlayer());
            current = current.getNext();
        }

        // Sort players based on the specified category
        switch (category) {
            case "Batting Average":
                Collections.sort(players,
                        (p1, p2) -> Double.compare(p2.calculateBattingAverage(), p1.calculateBattingAverage()));
                break;
            case "On-Base Percentage":
                Collections.sort(players,
                        (p1, p2) -> Double.compare(p2.calculateOnBasePercentage(), p1.calculateOnBasePercentage()));
                break;
            case "Hits":
                Collections.sort(players, (p1, p2) -> Integer.compare(p2.getHits(), p1.getHits()));
                break;
            case "Walks":
                Collections.sort(players, (p1, p2) -> Integer.compare(p2.getWalks(), p1.getWalks()));
                break;
            case "Strikeouts":
                Collections.sort(players, (p1, p2) -> Integer.compare(p1.getStrikeouts(), p2.getStrikeouts()));
                break;
            case "Hits by Pitch":
                Collections.sort(players, (p1, p2) -> Integer.compare(p2.getHitsByPitch(), p1.getHitsByPitch()));
                break;
            default:
                break;
        }

        // Map to store counts of leaders
        Map<Double, List<String>> leaderCounts = new HashMap<>();

        // Iterate over sorted players to find league leaders
        for (Player player : players) {
            double value = 0.0;
            switch (category) {
                case "Batting Average":
                    value = player.calculateBattingAverage();
                    break;
                case "On-Base Percentage":
                    value = player.calculateOnBasePercentage();
                    break;
                case "Hits":
                    value = player.getHits();
                    break;
                case "Walks":
                    value = player.getWalks();
                    break;
                case "Strikeouts":
                    value = player.getStrikeouts();
                    break;
                case "Hits by Pitch":
                    value = player.getHitsByPitch();
                    break;
                default:
                    break;
            }

            // Add leader to map
            if (!leaderCounts.containsKey(value)) {
                List<String> leaders = new ArrayList<>();
                leaders.add(player.getName());
                leaderCounts.put(value, leaders);
            } else {
                leaderCounts.get(value).add(player.getName());
            }
        }

        // Output leader information
        int place = 1;
        for (Map.Entry<Double, List<String>> entry : leaderCounts.entrySet()) {
            if (place > 3) {
                break; // Stop if already displayed 3 places
            }

            // Output current leader(s)
            System.out.print(place + ". " + entry.getKey() + "\t");
            List<String> leaders = entry.getValue();
            for (int i = 0; i < leaders.size(); i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(leaders.get(i));
            }
            System.out.println();
            place++;

            // Check if there's a tie for the next place
            if (place == 2 && entry.getValue().size() >= 3) {
                break; // No second place if first place has 3 or more ties
            }
        }
    }
}
