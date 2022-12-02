package se.aoc2022.day2;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DayTwoAgent {


    /*
    Rock        - A & X     - 1pt
    Paper       - B & Y     - 2pt
    Scissors    - C & Z     - 3pt

    Opponent    - A, B, C
    Me          - X, Y, Z

    Loss        - 0pt
    Draw        - 3pt
    Win         - 6pt

    For example, suppose you were given the following strategy guide:
    A Y
    B X
    C Z
    This strategy guide predicts and recommends the following:

    In the first round,
    your opponent will choose Rock (A),
    and you should choose Paper (Y).
    This ends in a win for you with a score of 8 (2 because you chose Paper + 6 because you won).

    In the second round,
    your opponent will choose Paper (B),
    and you should choose Rock (X).
    This ends in a loss for you with a score of 1 (1 + 0).

    The third round is a draw with both players choosing Scissors,
    giving you a score of 3 + 3 = 6.
    */
    enum Choices {
        ROCK(1), PAPER(2), SCISSORS(3);
        private final int pt;
        Choices(final int pt) {
            this.pt = pt;
        }

        public int getPt() {
            return pt;
        }

        public Choices getWeakness() {
            return switch (this) {
                case ROCK -> PAPER;
                case PAPER -> SCISSORS;
                case SCISSORS -> ROCK;
            };
        }
    }

    public static class Game {
        Opponent opponent = new Opponent();
        Player player = new Player();
        List<String> guide;

        public Game(List<String> guide) {
            this.guide = guide;
        }

        public int play() {
            int score = 0;
            for (String line : guide) {
                String[] split = line.split(" ");
                opponent.setChoice(split[0]);
                player.setChoice(split[1]);
                Round round = new Round(opponent, player);
                score += round.getScore();
            }
            return score;
        }

    }

    public static class Round {
        private final Opponent opponent;
        private final Player player;

        public Round(Opponent opponent, Player player) {
            this.opponent = opponent;
            this.player = player;
        }

        public int getScore() {
            int playerScore = player.getChoice().getPt();
            if (opponent
                    .getChoice()
                    .equals(player.getChoice())) {
                playerScore += 3;
            } else if (opponent
                    .getChoice()
                    .getWeakness()
                    .equals(player.getChoice())) {
                playerScore += 6;
            }
            return playerScore;
        }
    }
    public static class Opponent {

        private Choices choice;
        public Opponent() {
        }

        public void setChoice(String choice) {
            switch (choice) {
                case "A" -> this.choice = Choices.ROCK;
                case "B" -> this.choice = Choices.PAPER;
                case "C" -> this.choice = Choices.SCISSORS;
            }
        }
        public Choices getChoice() {
            return choice;
        }

    }
    public static class Player {
        private Choices choice;

        public Player() {
        }

        public void setChoice(String choice) {
            switch (choice) {
                case "X" -> this.choice = Choices.ROCK;
                case "Y" -> this.choice = Choices.PAPER;
                case "Z" -> this.choice = Choices.SCISSORS;
            }
        }

        public Choices getChoice() {
            return choice;
        }
    }
}
