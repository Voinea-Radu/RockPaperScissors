package dev.lightdream.rps.managers;

import dev.lightdream.api.databases.User;
import dev.lightdream.rps.files.dto.RPSGame;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RPSManager {

    public List<RPSGame> rpsGames = new ArrayList<>();

    public RPSManager(){

    }

    public @Nullable RPSGame getRpsGame(User user) {
        for (RPSGame rpsGame : rpsGames) {
            if(rpsGame.user.equals(user)){
                return rpsGame;
            }
        }
        return null;
    }
}
