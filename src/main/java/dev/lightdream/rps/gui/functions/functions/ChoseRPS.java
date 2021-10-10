package dev.lightdream.rps.gui.functions.functions;

import dev.lightdream.api.databases.User;
import dev.lightdream.api.gui.GUI;
import dev.lightdream.rps.Main;
import dev.lightdream.rps.gui.RPSChoseGUI;
import dev.lightdream.rps.gui.functions.GUIFunction;

import java.util.List;

public class ChoseRPS implements GUIFunction {
    @Override
    public void execute(GUI gui, User user, List<String> args) {
        new RPSChoseGUI(Main.instance, Integer.parseInt(args.get(0)), true).open(user);
    }
}
