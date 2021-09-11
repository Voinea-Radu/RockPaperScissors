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
    public void execute(User user, Object a) {
        String arg = (String) ((MessageBuilder) a).getBase();
        List<String> args = Arrays.asList(arg.split("\\|"));
        String opponent = args.get(0);
        String rpsType = args.get(1);

        if (opponent.equals("")) {
            return;
        }

        User opponentUser = Main.instance.databaseManager.getUser(opponent);

        if (opponentUser == null) {
            Main.instance.getMessageManager().sendMessage(user, Main.instance.lang.invalidMatch);
            return;
        }

        RPSGame game = Main.instance.rpsManager.getRpsGame(opponentUser);

        if (game == null) {
            Main.instance.getMessageManager().sendMessage(user, Main.instance.lang.invalidMatch);
            return;
        }

        User winner = game.play(user, RPSGame.RPSType.of(rpsType));

        Main.instance.messageManager.sendAll(new MessageBuilder(Main.instance.lang.rpsMatchAnnounce).addPlaceholders(new HashMap<String, String>() {{
            put("player-1", user.name);
            put("player-2", game.user.name);
            put("winner", winner == null ? "TIE" : winner.name);
            put("amount", String.valueOf(game.bet));
        }}));


    }
}
