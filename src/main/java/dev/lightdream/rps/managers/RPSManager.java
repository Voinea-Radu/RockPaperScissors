package dev.lightdream.rps.managers;

import dev.lightdream.api.databases.User;
import dev.lightdream.rps.Main;
import dev.lightdream.rps.files.dto.RPSGame;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RPSManager {

    public List<RPSGame> rpsGames = new ArrayList<>();
    private int id=0;

    public RPSManager(){

    }

    public @NotNull List<RPSGame> getRpsGames(User user) {
        List<RPSGame> output = new ArrayList<>();
        for (RPSGame rpsGame : rpsGames) {
            if(rpsGame.user.equals(user)){
                output.add(rpsGame);
            }
        }
        return output;
    }

    public @Nullable RPSGame getRpsGame(Integer id) {
        for (RPSGame rpsGame : rpsGames) {
            if(rpsGame.id==id){
                return rpsGame;
            }
        }
        return null;
    }


    public int getId(){
        id ++;
        return id;
    }
}
