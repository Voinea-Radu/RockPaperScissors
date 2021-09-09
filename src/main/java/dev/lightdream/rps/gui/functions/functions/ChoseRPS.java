package dev.lightdream.rps.gui.functions.functions;

import dev.lightdream.api.databases.User;
import dev.lightdream.api.utils.MessageBuilder;
import dev.lightdream.rps.Main;
import dev.lightdream.rps.gui.RPSChoseGUI;
import dev.lightdream.rps.gui.functions.GUIFunction;

public class ChoseRPS implements GUIFunction {
    @Override
    public void execute(User user, Object args) {
        String arg = (String)((MessageBuilder) args).getBase();
        new RPSChoseGUI(Main.instance, arg).open(user);
    }
}
