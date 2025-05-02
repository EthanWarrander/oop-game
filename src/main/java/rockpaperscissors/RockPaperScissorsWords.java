package rockpaperscissors;

public enum RockPaperScissorsWords {

    ROCK("rock"), PAPER("paper"), SCISSORS("scissors");

    private final String word;

    RockPaperScissorsWords(String word) { this.word = word;}

    public String toString() { return word;}
}