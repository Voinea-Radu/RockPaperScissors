package dev.lightdream.rps.gui.functions.functions;

import dev.lightdream.api.databases.User;
import dev.lightdream.api.utils.MessageBuilder;
import dev.lightdream.rps.Main;
import dev.lightdream.rps.files.dto.RPSGame;
import dev.lightdream.rps.gui.functions.GUIFunction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PlayRsp implements GUIFunction {
    @Override
    public void execute(User user, List<String> a) {
        List<String> args = Arrays.asList(a.get(0).split("\\|"));
        String idStr = args.get(0);
        String rpsType = args.get(1);

        if (idStr.equals("")) {
            return;
        }

        int id = Integer.parseInt(idStr);

        RPSGame game = Main.instance.rpsManager.getRpsGame(id);

        if (game == null) {
            Main.instance.getMessageManager().sendMessage(user, Main.instance.lang.invalidMatch);
            return;
        }

        if (!user.hasMoney(game.bet)) {
            Main.instance.getMessageManager().sendMessage(user, Main.instance.lang.notEnoughMoney);
            return;
        }

        if (game.user.equals(user)) {
            Main.instance.getMessageManager().sendMessage(user, Main.instance.lang.cannotBetYourself);
            return;
        }

        User winner = game.play(user, RPSGame.RPSType.of(rpsType));

        Main.instance.messageManager.sendAll(new MessageBuilder(Main.instance.lang.rpsMatchAnnounce).addPlaceholders(new HashMap<String, String>() {{
            put("player-1", user.name);
            put("player-2", game.user.name);
            put("winner", winner == null ? "TIE" : winner.name);
            put("amount", String.valueOf(game.bet));
        }}));

        if (winner == null) {
            user.addMoney(game.bet);
            game.user.addMoney(game.bet);
        } else {
            winner.addMoney(game.bet * 2);
        }
    }
}