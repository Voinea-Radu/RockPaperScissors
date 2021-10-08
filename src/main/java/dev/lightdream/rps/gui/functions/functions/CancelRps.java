package dev.lightdream.rps.gui.functions.functions;

import dev.lightdream.api.databases.User;
import dev.lightdream.rps.Main;
import dev.lightdream.rps.files.dto.RPSGame;
import dev.lightdream.rps.gui.functions.GUIFunction;

import java.util.List;

public class CancelRps implements GUIFunction {
    @Override
    public void execute(User user, List<String> args) {
        String arg = args.get(0);

        if (arg.equals("")) {
            Main.instance.getMessageManager().sendMessage(user, Main.instance.lang.invalidMatch);
            return;
        }

        int id = Integer.parseInt(arg);

        RPSGame game = Main.instance.rpsManager.getRpsGame(id);

        if (game == null || !game.user.equals(user)) {
            Main.instance.getMessageManager().sendMessage(user, Main.instance.lang.invalidMatch);
            return;
        }

        user.addMoney(game.bet);
        game.play(user, game.play);
        Main.instance.getMessageManager().sendMessage(user, Main.instance.lang.matchCanceled);

    }
}
