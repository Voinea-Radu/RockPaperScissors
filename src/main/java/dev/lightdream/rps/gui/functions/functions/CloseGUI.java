package dev.lightdream.rps.gui.functions.functions;

import dev.lightdream.api.databases.User;
import dev.lightdream.rps.gui.functions.GUIFunction;

public class CloseGUI implements GUIFunction
{
    @Override
    public void execute(User user, Object args) {
        if(!user.isOnline()){
            return;
        }
        user.getPlayer().closeInventory();
    }
}
