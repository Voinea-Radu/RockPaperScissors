package dev.lightdream.rps.gui.functions.functions;

import dev.lightdream.api.databases.User;
import dev.lightdream.api.utils.MessageBuilder;
import dev.lightdream.rps.Main;
import dev.lightdream.rps.files.dto.RPSGame;
import dev.lightdream.rps.gui.functions.GUIFunction;

import java.util.Arrays;
import java.util.List;

public class CreateRps implements GUIFunction {
    @Override
    public void execute(User user, Object a) {
        String arg = (String) ((MessageBuilder) a).getBase();
        List<String> args = Arrays.asList(arg.split("\\|"));

        if (args.get(0).equals("0") || args.get(0).equals("")) {
            return;
        }

        int amount = Integer.parseInt(args.get(0));
        String rpsType = args.get(1);

        if(!user.hasMoney(amount)){
            Main.instance.getMessageManager().sendMessage(user, Main.instance.lang.notEnoughMoney);
            return;
        }

        user.removeMoney(amount);


        Main.instance.rpsManager.rpsGames.add(new RPSGame(user, RPSGame.RPSType.of(rpsType), amount));
        Main.instance.messageManager.sendMessage(user, Main.instance.lang.matchCreated);


    }
}
