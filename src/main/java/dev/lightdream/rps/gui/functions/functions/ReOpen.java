package dev.lightdream.rps.gui.functions.functions;

import dev.lightdream.api.databases.User;
import dev.lightdream.api.gui.GUI;
import dev.lightdream.rps.gui.functions.GUIFunction;
import dev.lightdream.rps.gui.functions.GUIFunctions;

import java.util.List;

public class ReOpen implements GUIFunction {
    @Override
    public void execute(GUI gui, User user, List<String> args) {
        gui.open(user);
    }
}
