public class Player {
    private String name;
    private int atBats;
    private int hits;
    private int walks;
    private int strikeouts;
    private int hitsByPitch;
    private int sacrifices;

    public Player(String name) {
        this.name = name;
        this.atBats = 0;
        this.hits = 0;
        this.walks = 0;
        this.strikeouts = 0;
        this.hitsByPitch = 0;
        this.sacrifices = 0;
    }

    public String getName() {
        return name;
    }

    public void incrementAtBats() {
        this.atBats++;
    }

    public void incrementHits() {
        this.hits++;
    }

    public void incrementWalks() {
        this.walks++;
    }

    public void incrementStrikeouts() {
        this.strikeouts++;
    }

    public void incrementHitsByPitch() {
        this.hitsByPitch++;
    }

    public void incrementSacrifices() {
        this.sacrifices++;
    }

    public double calculateBattingAverage() {
        return atBats == 0 ? 0 : (double) hits / atBats;
    }

    public double calculateOnBasePercentage() {
        int plateAppearances = atBats + walks + hitsByPitch;
        return plateAppearances == 0 ? 0 : (double) (hits + walks + hitsByPitch) / plateAppearances;
    }

    public int getHits() {
        return hits;
    }

    public int getWalks() {
        return walks;
    }

    public int getStrikeouts() {
        return strikeouts;
    }

    public int getHitsByPitch() {
        return hitsByPitch;
    }

    @Override
    public String toString() {
        double battingAverage = calculateBattingAverage();
        double onBasePercentage = calculateOnBasePercentage();
        return name + "\t" + atBats + "\t" + hits + "\t" + walks + "\t" + strikeouts + "\t" +
                hitsByPitch + "\t" + sacrifices + "\t" + String.format("%.3f", battingAverage) + "\t" +
                String.format("%.3f", onBasePercentage);
    }
}
