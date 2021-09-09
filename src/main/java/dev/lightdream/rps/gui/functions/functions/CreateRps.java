package dev.lightdream.rps.gui.functions.functions;

import dev.lightdream.api.databases.User;
import dev.lightdream.api.utils.MessageBuilder;
import dev.lightdream.rps.Main;
import dev.lightdream.rps.files.dto.RPSGame;
import dev.lightdream.rps.gui.functions.GUIFunction;

public class CreateRps implements GUIFunction {
    @Override
    public void execute(User user, Object args) {
        String arg = (String) ((MessageBuilder) args).getBase();

        if (arg.split("\\|")[0].equals("0") || arg.split("\\|")[0].equals("")) {
            return;
        }

        int amount = Integer.parseInt(arg.split("\\|")[0]);
        String rpsType = arg.split("\\|")[1];

        Main.instance.rpsManager.rpsGames.add(new RPSGame(user, RPSGame.RPSType.of(rpsType), amount));
        Main.instance.messageManager.sendMessage(user, Main.instance.lang.matchCreated);
    }
}
