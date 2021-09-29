package dev.lightdream.rps.gui.functions.functions;

import dev.lightdream.api.databases.User;
import dev.lightdream.api.utils.MessageBuilder;
import dev.lightdream.rps.gui.functions.GUIFunction;

public class CloseGUI implements GUIFunction
{
    @Override
    public void execute(User user, MessageBuilder args) {
        if(!user.isOnline()){
            return;
        }
        user.getPlayer().closeInventory();
    }
}
