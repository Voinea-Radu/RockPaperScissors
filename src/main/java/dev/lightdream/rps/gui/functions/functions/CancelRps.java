package dev.lightdream.rps.gui.functions.functions;

import dev.lightdream.api.databases.User;
import dev.lightdream.api.utils.MessageBuilder;
import dev.lightdream.rps.Main;
import dev.lightdream.rps.files.dto.RPSGame;
import dev.lightdream.rps.gui.RPSGUI;
import dev.lightdream.rps.gui.functions.GUIFunction;

public class CancelRps implements GUIFunction {
    @Override
    public void execute(User user, Object args) {
        String arg = (String)((MessageBuilder) args).getBase();

        if(arg.equals("")){
            Main.instance.getMessageManager().sendMessage(user, Main.instance.lang.invalidMatch);
            return;
        }

        int id = Integer.parseInt(arg);

        RPSGame game = Main.instance.rpsManager.getRpsGame(id);

        if(game==null || !game.user.equals(user)){
            Main.instance.getMessageManager().sendMessage(user, Main.instance.lang.invalidMatch);
            return;
        }

        user.addMoney(game.bet);
        game.play(user, game.play);
        Main.instance.getMessageManager().sendMessage(user, Main.instance.lang.matchCanceled);

    }
}
