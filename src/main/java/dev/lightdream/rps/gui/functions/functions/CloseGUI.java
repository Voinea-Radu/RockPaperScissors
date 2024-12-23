package dev.lightdream.rps.gui.functions.functions;

import dev.lightdream.api.databases.User;
import dev.lightdream.api.gui.GUI;
import dev.lightdream.rps.gui.functions.GUIFunction;

import java.util.List;

public class CloseGUI implements GUIFunction {
    @SuppressWarnings("ConstantConditions")
    @Override
    public void execute(GUI gui, User user, List<String> args) {
        if (!user.isOnline()) {
            return;
        }
        user.getPlayer().closeInventory();
    }
}
