package dev.lightdream.rps.files.dto;


import dev.lightdream.api.databases.User;
import dev.lightdream.rps.Main;

import java.util.Objects;

public class RPSGame {

    public int id;
    public User user;
    public RPSType play;
    public int bet;

    public RPSGame(User user, RPSType play, int bet) {
        this.id = Main.instance.rpsManager.getId();
        this.user = user;
        this.play = play;
        this.bet = bet;
    }

    public User play(User user, RPSType play) {
        RPSEndState endState = this.play.getEndState(play);
        Main.instance.rpsManager.rpsGames.remove(this);
        switch (endState) {
            case WIN:
                return this.user;
            case TIE:
                return null;
            case LOSE:
                return user;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RPSGame rpsGame = (RPSGame) o;
        return Objects.equals(user, rpsGame.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

    public enum RPSType {
        ROCK, PAPER, SCISSORS;

        public static RPSType of(String value) {
            if (value.equalsIgnoreCase("r") || value.toLowerCase().equals(ROCK.toString())) {
                return ROCK;
            }
            if (value.equalsIgnoreCase("p") || value.toLowerCase().equals(PAPER.toString())) {
                return PAPER;
            }
            if (value.equalsIgnoreCase("S") || value.toLowerCase().equals(SCISSORS.toString())) {
                return SCISSORS;
            }
            return null;
        }

        public RPSEndState getEndState(RPSType opponent) {
            switch (this) {
                case ROCK:
                    switch (opponent) {
                        case ROCK:
                            return RPSEndState.TIE;
                        case PAPER:
                            return RPSEndState.LOSE;
                        case SCISSORS:
                            return RPSEndState.WIN;
                    }
                case PAPER:
                    switch (opponent) {
                        case ROCK:
                            return RPSEndState.WIN;
                        case PAPER:
                            return RPSEndState.TIE;
                        case SCISSORS:
                            return RPSEndState.LOSE;
                    }
                case SCISSORS:
                    switch (opponent) {
                        case ROCK:
                            return RPSEndState.LOSE;
                        case PAPER:
                            return RPSEndState.WIN;
                        case SCISSORS:
                            return RPSEndState.TIE;
                    }
            }
            return RPSEndState.TIE;
        }

        @Override
        public String toString() {
            return this.name().toLowerCase();
        }
    }

    public enum RPSEndState {
        WIN, LOSE, TIE
    }
}
